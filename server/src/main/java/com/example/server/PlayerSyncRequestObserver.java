package com.example.server;

import com.example.shared.GrpcPlayer;
import com.example.shared.PlayerSyncRequest;
import com.example.shared.PlayerSyncResponse;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class PlayerSyncRequestObserver implements StreamObserver<PlayerSyncRequest> {

  private final StreamObserver<PlayerSyncResponse> playerSyncResponseStreamObserver;

  private final Function<PlayerSyncRequest, List<PlayerSyncResponse>> playerSyncFunction;

  private final Consumer<GrpcPlayer> playerDeregisterFunction;

  private GrpcPlayer grpcPlayer;

  public PlayerSyncRequestObserver(
    final StreamObserver<PlayerSyncResponse> playerSyncResponseStreamObserver,
    final Function<PlayerSyncRequest, List<PlayerSyncResponse>> playerSyncFunction,
    final Consumer<GrpcPlayer> playerDeregisterFunction
  ) {
    this.playerSyncResponseStreamObserver = playerSyncResponseStreamObserver;
    this.playerSyncFunction = playerSyncFunction;
    this.playerDeregisterFunction = playerDeregisterFunction;
  }

  @Override
  public void onNext(PlayerSyncRequest value) {
    if (grpcPlayer == null) grpcPlayer = value.getPlayer();
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
    playerDeregisterFunction.accept(grpcPlayer);
    System.out.println("Player onCompleted!");
    playerSyncResponseStreamObserver.onCompleted();
  }
}
