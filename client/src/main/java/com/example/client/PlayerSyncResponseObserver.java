package com.example.client;

import com.example.shared.GrpcLocation;
import com.example.shared.GrpcPlayer;
import com.example.shared.MoveEvent;
import com.example.shared.PlayerSyncRequest;
import com.example.shared.PlayerSyncResponse;
import io.grpc.stub.StreamObserver;

import java.util.List;

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
    MoveEvent moveEvent = value.getMoveEvent();
    GrpcPlayer otherGrpcPlayer = moveEvent.getOtherPlayer();
    OtherPlayer otherPlayer = convert(otherGrpcPlayer);
    otherPlayers.moveOrAdd(otherPlayer);
  }

  @Override
  public void onError(Throwable t) {
    t.printStackTrace();
  }

  @Override
  public void onCompleted() {
    System.out.println("onCompleted!");
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
}
