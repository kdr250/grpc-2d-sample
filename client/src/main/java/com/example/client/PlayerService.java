package com.example.client;

import com.example.shared.GrpcLocation;
import com.example.shared.GrpcPlayer;
import com.example.shared.PlayerGrpc.PlayerStub;
import com.example.shared.PlayerSyncRequest;
import com.example.shared.PlayerSyncResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Service
public class PlayerService {

  @GrpcClient("server")
  private PlayerStub playerStub;

  public void synchronize(Player player, List<Player> otherPlayers) {
    Location location = player.location();
    GrpcLocation grpcLocation = GrpcLocation.newBuilder().setX(location.getX()).setY(location.getY()).build();
    GrpcPlayer grpcPlayer = GrpcPlayer.newBuilder().setId(player.id()).setName(player.name()).setLocation(grpcLocation).build();
    PlayerSyncRequest playerSyncRequest = PlayerSyncRequest.newBuilder().setPlayer(grpcPlayer).build();

    CountDownLatch finishLatch = new CountDownLatch(1);

    StreamObserver<PlayerSyncRequest> streamObserver = playerStub.sync(new StreamObserver<PlayerSyncResponse>() {
      @Override
      public void onNext(PlayerSyncResponse value) {
        GrpcPlayer otherGrpcPlayer = value.getOtherPlayer();
        move(otherPlayers, otherGrpcPlayer);
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

    streamObserver.onNext(playerSyncRequest);

    streamObserver.onCompleted();;

    try {
      finishLatch.await(10, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  private void move(List<Player> otherPlayers, GrpcPlayer grpcPlayer) {
    String id = grpcPlayer.getId();
    String name = grpcPlayer.getName();
    GrpcLocation grpcLocation = grpcPlayer.getLocation();
    Location location = new Location(grpcLocation.getX(), grpcLocation.getY());

    Optional<Player> optionalPlayer = otherPlayers.stream()
      .filter(p -> p.id().equals(id))
      .peek(p -> p.warp(location))
      .findFirst();

    if (optionalPlayer.isEmpty()) {
      otherPlayers.add(new Player(id, name, location));
    }
  }
}
