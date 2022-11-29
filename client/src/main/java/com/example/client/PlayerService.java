package com.example.client;

import com.example.shared.GrpcLocation;
import com.example.shared.GrpcPlayer;
import com.example.shared.PlayerGrpc.PlayerStub;
import com.example.shared.PlayerSyncRequest;
import com.example.shared.PlayerSyncResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class PlayerService {

  @GrpcClient("server")
  private PlayerStub playerStub;

  public List<Player> synchronize(Player player) {
    Location location = player.location();
    GrpcLocation grpcLocation = GrpcLocation.newBuilder().setX(location.getX()).setY(location.getY()).build();
    GrpcPlayer grpcPlayer = GrpcPlayer.newBuilder().setId(player.id()).setName(player.name()).setLocation(grpcLocation).build();
    PlayerSyncRequest playerSyncRequest = PlayerSyncRequest.newBuilder().setPlayer(grpcPlayer).build();

    List<GrpcPlayer> otherGrpcPlayers = new ArrayList<>();

    CountDownLatch finishLatch = new CountDownLatch(1);

    StreamObserver<PlayerSyncRequest> streamObserver = playerStub.sync(new StreamObserver<PlayerSyncResponse>() {
      @Override
      public void onNext(PlayerSyncResponse value) {
        otherGrpcPlayers.addAll(value.getOtherPlayerList());
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
      finishLatch.await(5, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    return otherGrpcPlayers.stream().map(this::convert).collect(Collectors.toList());
  }

  private Player convert(GrpcPlayer grpcPlayer) {
    String id = grpcPlayer.getId();
    String name = grpcPlayer.getName();
    GrpcLocation grpcLocation = grpcPlayer.getLocation();
    Location location = new Location(grpcLocation.getX(), grpcLocation.getY());
    return new Player(id, name, location);
  }
}
