package com.example.server;

import com.example.shared.GrpcPlayer;
import com.example.shared.PlayerSyncRequest;
import com.example.shared.PlayerSyncResponse;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.function.Function;

public class PlayerSyncRequestObserver implements StreamObserver<PlayerSyncRequest> {

  private final StreamObserver<PlayerSyncResponse> playerSyncResponseStreamObserver;

  private final Function<PlayerSyncRequest, List<GrpcPlayer>> playerGetFunction;

  public PlayerSyncRequestObserver(
    final StreamObserver<PlayerSyncResponse> playerSyncResponseStreamObserver,
    final Function<PlayerSyncRequest, List<GrpcPlayer>> playerGetFunction
  ) {
    this.playerSyncResponseStreamObserver = playerSyncResponseStreamObserver;
    this.playerGetFunction = playerGetFunction;
  }

  @Override
  public void onNext(PlayerSyncRequest value) {
    List<GrpcPlayer> otherPlayerList = playerGetFunction.apply(value);
    for (GrpcPlayer other : otherPlayerList) {
      PlayerSyncResponse response = PlayerSyncResponse.newBuilder().setOtherPlayer(other).build();
      playerSyncResponseStreamObserver.onNext(response);
    }
  }

  @Override
  public void onError(Throwable t) {
    t.printStackTrace();
  }

  @Override
  public void onCompleted() {
    System.out.println("onCompleted!");
    playerSyncResponseStreamObserver.onCompleted();
  }
}
