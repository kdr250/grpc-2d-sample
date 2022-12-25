package com.example.client;

import com.example.shared.AddEvent;
import com.example.shared.GrpcImageType;
import com.example.shared.GrpcLocation;
import com.example.shared.GrpcPlayer;
import com.example.shared.MoveEvent;
import com.example.shared.PlayerSyncRequest;
import com.example.shared.PlayerSyncResponse;
import io.grpc.stub.StreamObserver;
import org.apache.commons.lang3.tuple.Pair;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayerSyncResponseObserver implements StreamObserver<PlayerSyncResponse> {

  private StreamObserver<PlayerSyncRequest> playerSyncRequestStreamObserver;

  private final Player player;
  private final OtherPlayers otherPlayers;

  public PlayerSyncResponseObserver(final Player player, final OtherPlayers otherPlayers) {
    this.player = player;
    this.otherPlayers = otherPlayers;
  }

  @Override
  public void onNext(PlayerSyncResponse value) {
    if (value.hasMoveEvent()) {
      MoveEvent moveEvent = value.getMoveEvent();
      GrpcPlayer otherGrpcPlayer = moveEvent.getOtherPlayer();
      OtherPlayer otherPlayer = convert(otherGrpcPlayer);
      otherPlayers.moveOrAdd(otherPlayer);
      return;
    }
    if (value.hasAddEvent()) {
      AddEvent addEvent = value.getAddEvent();
      GrpcPlayer otherGrpcPlayer = addEvent.getOtherPlayer();
      OtherPlayer otherPlayer = convert(otherGrpcPlayer);
      PlayerAnimation playerAnimation = playerAnimation(addEvent);
      otherPlayer.setPlayerAnimation(playerAnimation);
      otherPlayers.moveOrAdd(otherPlayer);
    }
  }

  @Override
  public void onError(Throwable t) {
    t.printStackTrace();
  }

  @Override
  public void onCompleted() {
    System.out.println("onCompleted!");
    playerSyncRequestStreamObserver.onCompleted();
  }

  public void startSync(StreamObserver<PlayerSyncRequest> playerSyncRequestStreamObserver) {
    this.playerSyncRequestStreamObserver = playerSyncRequestStreamObserver;
    syncPlayer();
  }

  public void syncPlayer() {
    Location location = player.location();
    GrpcLocation grpcLocation = GrpcLocation.newBuilder().setX(location.getX()).setY(location.getY()).build();
    GrpcPlayer grpcPlayer = GrpcPlayer.newBuilder().setId(player.id()).setName(player.name()).setLocation(grpcLocation).build();
    List<String> otherPlayerIdList = otherPlayers.idList();
    PlayerSyncRequest playerSyncRequest = PlayerSyncRequest.newBuilder().setPlayer(grpcPlayer).addAllOtherPlayerIdList(otherPlayerIdList).build();
    playerSyncRequestStreamObserver.onNext(playerSyncRequest);
  }

  private OtherPlayer convert(GrpcPlayer grpcPlayer) {
    String id = grpcPlayer.getId();
    String name = grpcPlayer.getName();
    GrpcLocation grpcLocation = grpcPlayer.getLocation();
    Location location = new Location(grpcLocation.getX(), grpcLocation.getY());
    return new OtherPlayer(id, name, location);
  }

  public static PlayerAnimation playerAnimation(AddEvent addEvent) {
    List<GrpcImageType> imageTypeList = addEvent.getImageTypeList();
    Map<PlayerAnimationType, BufferedImage> map = imageTypeList.stream().map(i -> {
      PlayerAnimationType type = PlayerAnimationType.valueOf(i.getName());
      byte[] decodedBytes = Base64.getDecoder().decode(i.getBase64Image());
      ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
      BufferedImage scaledImage;
      try {
        BufferedImage original = ImageIO.read(bis);
        scaledImage = new BufferedImage(Tile.TILE_SIZE, Tile.TILE_SIZE, original.getType());
        Graphics2D g2 = scaledImage.createGraphics();
        g2.drawImage(original, 0, 0, Tile.TILE_SIZE, Tile.TILE_SIZE, null);
      } catch (IOException e) {
        throw new IllegalStateException(e.getMessage(), e);
      }
      return Pair.of(type, scaledImage);
    }).collect(Collectors.toMap(Pair::getLeft, Pair::getRight));

    return new PlayerAnimation(map);
  }
}
