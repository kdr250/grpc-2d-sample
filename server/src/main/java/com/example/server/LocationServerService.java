package com.example.server;

import com.example.shared.GrpcLocation;
import com.example.shared.LocationRequest;
import com.example.shared.LocationResponse;
import com.example.shared.LocationSyncGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class LocationServerService extends LocationSyncGrpc.LocationSyncImplBase {

  @Override
  public StreamObserver<LocationRequest> syncLocation(StreamObserver<LocationResponse> responseObserver) {

    return new StreamObserver<LocationRequest>() {
      @Override
      public void onNext(LocationRequest value) {
        GrpcLocation requestLocation = value.getLocation();
        int x = (requestLocation.getX()+4) % 600;
        int y = (requestLocation.getY()+4) % 600;
        GrpcLocation location = GrpcLocation.newBuilder().setX(x).setY(y).build();
        LocationResponse locationResponse = LocationResponse.newBuilder().setLocation(location).build();
        responseObserver.onNext(locationResponse);
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
