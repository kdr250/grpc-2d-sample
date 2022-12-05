package com.example.client;

import com.example.shared.GrpcLocation;
import com.example.shared.GrpcPlayer;
import com.example.shared.PlayerGrpc.PlayerStub;
import com.example.shared.PlayerSyncRequest;
import com.example.shared.PlayerSyncResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

  @GrpcClient("server")
  private PlayerStub playerStub;

  private StreamObserver<PlayerSyncResponse> streamObserverResponse;

  public void synchronize(Player player, OtherPlayers otherPlayers) {
    Location location = player.location();
    GrpcLocation grpcLocation = GrpcLocation.newBuilder().setX(location.getX()).setY(location.getY()).build();
    GrpcPlayer grpcPlayer = GrpcPlayer.newBuilder().setId(player.id()).setName(player.name()).setLocation(grpcLocation).build();
    PlayerSyncRequest playerSyncRequest = PlayerSyncRequest.newBuilder().setPlayer(grpcPlayer).build();

    //CountDownLatch finishLatch = new CountDownLatch(1);

    if (streamObserverResponse == null) {
      streamObserverResponse = new StreamObserver<PlayerSyncResponse>() {
        @Override
        public void onNext(PlayerSyncResponse value) {
          GrpcPlayer otherGrpcPlayer = value.getOtherPlayer();
          OtherPlayer otherPlayer = convert(otherGrpcPlayer);
          otherPlayers.moveOrAdd(otherPlayer);
        }

        @Override
        public void onError(Throwable t) {
          t.printStackTrace();
        }

        @Override
        public void onCompleted() {
          // TODO: アプリケーションが終了したらクローズする処理を作成すること
          System.out.println("Disconnected!");
        }
      };
    }

    StreamObserver<PlayerSyncRequest> streamObserver = playerStub.sync(streamObserverResponse);

    streamObserver.onNext(playerSyncRequest);
  }

  private OtherPlayer convert(GrpcPlayer grpcPlayer) {
    String id = grpcPlayer.getId();
    String name = grpcPlayer.getName();
    GrpcLocation grpcLocation = grpcPlayer.getLocation();
    Location location = new Location(grpcLocation.getX(), grpcLocation.getY());
    return new OtherPlayer(id, name, location);
  }
}
