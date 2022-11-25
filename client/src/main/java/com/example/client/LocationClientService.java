package com.example.client;

import com.example.shared.GrpcLocation;
import com.example.shared.LocationRequest;
import com.example.shared.LocationResponse;
import com.example.shared.LocationSyncGrpc.LocationSyncStub;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Service
public class LocationClientService {

  @GrpcClient("server")
  private LocationSyncStub locationSyncStub;

  public void receiveLocation(Player player) {
    Location location = player.getLocation();
    GrpcLocation grpcLocation = GrpcLocation.newBuilder()
      .setX(location.getX())
      .setY(location.getY())
      .build();
    LocationRequest locationRequest = LocationRequest.newBuilder().setLocation(grpcLocation).build();

    CountDownLatch finishLatch = new CountDownLatch(1);

    StreamObserver<LocationRequest> streamObserver = locationSyncStub.syncLocation(new StreamObserver<LocationResponse>() {
      @Override
      public void onNext(LocationResponse value) {
        Location location = new Location(value.getLocation().getX(), value.getLocation().getY());
        player.warp(location);
      }

      @Override
      public void onError(Throwable t) {
        t.printStackTrace();
      }

      @Override
      public void onCompleted() {
        finishLatch.countDown();
      }
    });

    streamObserver.onNext(locationRequest);

    streamObserver.onCompleted();

    try {
      finishLatch.await(10, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
