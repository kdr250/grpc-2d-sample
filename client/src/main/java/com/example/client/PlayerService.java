package com.example.client;

import com.example.shared.PlayerGrpc.PlayerStub;
import com.example.shared.PlayerSyncRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PlayerService implements Runnable {

  @GrpcClient("server")
  private PlayerStub playerStub;

  private static final double UPDATE_INTERVAL = GamePanel.DRAW_INTERVAL * 10;

  private Thread playerThread;

  private final Player player = new Player("Taro", new Location(200, 200));

  private final OtherPlayers otherPlayers = new OtherPlayers();

  private PlayerSyncResponseObserver playerSyncResponseObserver;

  public PlayerService() {

  }

  public void startPlayerThread() {
    playerSyncResponseObserver = new PlayerSyncResponseObserver(player, otherPlayers);
    StreamObserver<PlayerSyncRequest> requestStreamObserver = playerStub.sync(playerSyncResponseObserver);
    playerSyncResponseObserver.startSync(requestStreamObserver);
    playerThread = new Thread(this);
    playerThread.start();
  }

  @Override
  public void run() {
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;

    while (playerThread != null) {
      currentTime = System.nanoTime();
      delta += (currentTime - lastTime) / UPDATE_INTERVAL;
      lastTime = currentTime;

      if (delta >= 1) {
        playerSyncResponseObserver.syncPlayer();
        delta--;
      }
    }
  }

  public void movePlayer(final Vector vector) {
    player.move(vector);
  }

  public Player player() {
    return player;
  }

  public OtherPlayers otherPlayers() {
    return otherPlayers;
  }
}
