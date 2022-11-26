package com.example.server;

import com.example.shared.GrpcWorldMap;
import com.example.shared.InitializeRequest;
import com.example.shared.InitializeResponse;
import com.example.shared.WorldMapGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class WorldMapService extends WorldMapGrpc.WorldMapImplBase {

  private final RegisterWorldMapToRedisComponent registerWorldMapToRedisComponent;

  public WorldMapService(final RegisterWorldMapToRedisComponent registerWorldMapToRedisComponent) {
    this.registerWorldMapToRedisComponent = registerWorldMapToRedisComponent;
  }

  @Override
  public void initialize(InitializeRequest request, StreamObserver<InitializeResponse> responseObserver) {
    GrpcWorldMap worldMap = registerWorldMapToRedisComponent.grpcWorldMap("world1");

    InitializeResponse initializeResponse = InitializeResponse.newBuilder().setWorldMap(worldMap).build();

    responseObserver.onNext(initializeResponse);
    responseObserver.onCompleted();
  }
}
