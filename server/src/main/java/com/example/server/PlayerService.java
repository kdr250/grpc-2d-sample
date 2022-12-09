package com.example.server;

import com.example.shared.GrpcPlayer;
import com.example.shared.PlayerGrpc;
import com.example.shared.PlayerSyncRequest;
import com.example.shared.PlayerSyncResponse;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

import java.util.List;

@GRpcService
public class PlayerService extends PlayerGrpc.PlayerImplBase {

  private final RegisterPlayerToRedisComponent registerPlayerToRedisComponent;

  public PlayerService(final RegisterPlayerToRedisComponent registerPlayerToRedisComponent) {
    this.registerPlayerToRedisComponent = registerPlayerToRedisComponent;
  }

  @Override
  public StreamObserver<PlayerSyncRequest> sync(StreamObserver<PlayerSyncResponse> responseObserver) {
    return new PlayerSyncRequestObserver(responseObserver, playerSyncRequest -> {
      GrpcPlayer grpcPlayer = playerSyncRequest.getPlayer();
      List<String> otherPlayerIdList = playerSyncRequest.getOtherPlayerIdListList();
      registerPlayerToRedisComponent.register("world1", grpcPlayer);
      return registerPlayerToRedisComponent.get("world1", grpcPlayer.getId(), otherPlayerIdList);
    });
  }
}
