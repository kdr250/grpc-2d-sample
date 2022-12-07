package com.example.client;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class PlayerController implements Runnable {
  // FPS設定
  private static final double UPDATE_INTERVAL = GamePanel.DRAW_INTERVAL * 10;

  private Thread playerThread;

  private final PlayerService playerService;

  private final Player player = new Player("Taro", new Location(200, 200));

  private OtherPlayers otherPlayers = new OtherPlayers();

  public PlayerController(final PlayerService playerService) {
    this.playerService = playerService;
  }

  public void startPlayerThread() {
    playerService.synchronize(player, otherPlayers);
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
        //update();
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

  public Set<OtherPlayer> otherPlayers() {
    System.out.println(otherPlayers.values());
    return otherPlayers.values();
  }

  private void update() {
    playerService.synchronize(player, otherPlayers);
  }
}
