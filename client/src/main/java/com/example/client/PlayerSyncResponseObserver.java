package com.example.client;

import com.example.shared.GrpcLocation;
import com.example.shared.GrpcPlayer;
import com.example.shared.PlayerSyncRequest;
import com.example.shared.PlayerSyncResponse;
import com.google.common.util.concurrent.Uninterruptibles;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

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
    GrpcPlayer otherGrpcPlayer = value.getOtherPlayer();
    if (!player.id().equals(otherGrpcPlayer.getId())) {
      OtherPlayer otherPlayer = convert(otherGrpcPlayer);
      otherPlayers.moveOrAdd(otherPlayer);
    }
    syncPlayer();
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

  private void syncPlayer() {
    Uninterruptibles.sleepUninterruptibly(32, TimeUnit.MILLISECONDS);

    Location location = player.location();
    GrpcLocation grpcLocation = GrpcLocation.newBuilder().setX(location.getX()).setY(location.getY()).build();
    GrpcPlayer grpcPlayer = GrpcPlayer.newBuilder().setId(player.id()).setName(player.name()).setLocation(grpcLocation).build();
    PlayerSyncRequest playerSyncRequest = PlayerSyncRequest.newBuilder().setPlayer(grpcPlayer).build();

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
