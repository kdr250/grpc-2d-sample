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

  public void synchronize(Player player, OtherPlayers otherPlayers) {
    PlayerSyncResponseObserver playerSyncResponseObserver = new PlayerSyncResponseObserver(player, otherPlayers);
    StreamObserver<PlayerSyncRequest> requestStreamObserver = playerStub.sync(playerSyncResponseObserver);

    playerSyncResponseObserver.startSync(requestStreamObserver);
  }
}
