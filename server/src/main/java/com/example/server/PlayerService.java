package com.example.server;

import com.example.shared.GrpcPlayer;
import com.example.shared.PlayerGrpc;
import com.example.shared.PlayerSyncRequest;
import com.example.shared.PlayerSyncResponse;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

import java.util.List;
import java.util.function.Supplier;

@GRpcService
public class PlayerService extends PlayerGrpc.PlayerImplBase {

  private final RegisterPlayerToRedisComponent registerPlayerToRedisComponent;

  public PlayerService(final RegisterPlayerToRedisComponent registerPlayerToRedisComponent) {
    this.registerPlayerToRedisComponent = registerPlayerToRedisComponent;
  }

  @Override
  public StreamObserver<PlayerSyncRequest> sync(StreamObserver<PlayerSyncResponse> responseObserver) {
    return new StreamObserver<PlayerSyncRequest>() {
      @Override
      public void onNext(PlayerSyncRequest value) {
        GrpcPlayer grpcPlayer = value.getPlayer();
        registerPlayerToRedisComponent.register("world1", grpcPlayer);

        List<Supplier<GrpcPlayer>> otherPlayerSupplierList = registerPlayerToRedisComponent.get("world1", grpcPlayer.getId());
        for (Supplier<GrpcPlayer> supplier : otherPlayerSupplierList) {
          PlayerSyncResponse playerSyncResponse = PlayerSyncResponse.newBuilder().setOtherPlayer(supplier.get()).build();
          responseObserver.onNext(playerSyncResponse);
        }
      }

      @Override
      public void onError(Throwable t) {
        t.printStackTrace();
      }

      @Override
      public void onCompleted() {
        responseObserver.onCompleted();
      }
    };
  }
}
