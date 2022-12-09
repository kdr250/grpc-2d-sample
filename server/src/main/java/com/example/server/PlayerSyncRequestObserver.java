package com.example.server;

import com.example.shared.PlayerSyncRequest;
import com.example.shared.PlayerSyncResponse;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.function.Function;

public class PlayerSyncRequestObserver implements StreamObserver<PlayerSyncRequest> {

  private final StreamObserver<PlayerSyncResponse> playerSyncResponseStreamObserver;

  private final Function<PlayerSyncRequest, List<PlayerSyncResponse>> playerSyncFunction;

  public PlayerSyncRequestObserver(
    final StreamObserver<PlayerSyncResponse> playerSyncResponseStreamObserver,
    final Function<PlayerSyncRequest, List<PlayerSyncResponse>> playerSyncFunction
  ) {
    this.playerSyncResponseStreamObserver = playerSyncResponseStreamObserver;
    this.playerSyncFunction = playerSyncFunction;
  }

  @Override
  public void onNext(PlayerSyncRequest value) {
    List<PlayerSyncResponse> responseList = playerSyncFunction.apply(value);
    for (PlayerSyncResponse response : responseList) {
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
