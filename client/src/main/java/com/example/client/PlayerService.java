package com.example.client;

import com.example.shared.AddEvent;
import com.example.shared.GrpcImageType;
import com.example.shared.GrpcLocation;
import com.example.shared.GrpcPlayer;
import com.example.shared.PlayerGrpc.PlayerBlockingStub;
import com.example.shared.PlayerGrpc.PlayerStub;
import com.example.shared.PlayerSyncRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PlayerService implements Runnable {

  @GrpcClient("server")
  private PlayerStub playerStub;

  @GrpcClient("server")
  private PlayerBlockingStub playerBlockingStub;

  private static final double UPDATE_INTERVAL = GamePanel.DRAW_INTERVAL * 10;

  private Thread playerThread;

  private final Player player = new Player("Taro", new Location(11 * Tile.TILE_SIZE, 27 * Tile.TILE_SIZE));

  private final OtherPlayers otherPlayers = new OtherPlayers();

  private PlayerSyncResponseObserver playerSyncResponseObserver;

  public void startPlayerThread() {
    GrpcLocation grpcLocation = GrpcLocation.newBuilder().setX(player.location().getX()).setY(player.location().getY()).build();
    GrpcPlayer grpcPlayer = GrpcPlayer.newBuilder().setId(player.id()).setName(player.name()).setLocation(grpcLocation).build();
    AddEvent addEvent = playerBlockingStub.initialize(grpcPlayer);

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

    PlayerAnimation playerAnimation = new PlayerAnimation(map);
    player.setPlayerAnimation(playerAnimation);

    playerSyncResponseObserver = new PlayerSyncResponseObserver(player, otherPlayers);
    StreamObserver<PlayerSyncRequest> requestStreamObserver = playerStub.sync(playerSyncResponseObserver);
    playerSyncResponseObserver.startSync(requestStreamObserver);
    playerThread = new Thread(this);
    playerThread.start();
  }

  @Override
  public void run() {
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;

    while (playerThread != null) {
      currentTime = System.nanoTime();
      delta += (currentTime - lastTime) / UPDATE_INTERVAL;
      lastTime = currentTime;

      if (delta >= 1) {
        playerSyncResponseObserver.syncPlayer();
        delta--;
      }
    }
  }

  public void movePlayer(final Vector vector) {
    player.move(vector);
  }

  public boolean canMove(final List<Collidable> collidableList, final Vector vector) {
    return player.canMove(collidableList, vector);
  }

  public Player player() {
    return player;
  }

  public OtherPlayers otherPlayers() {
    return otherPlayers;
  }
}
