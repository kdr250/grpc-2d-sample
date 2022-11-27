package com.example.client;

import org.apache.commons.lang3.tuple.Triple;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class GamePanel extends JPanel implements Runnable {

  // スクリーン設定
  private static final int maxScreenCol = 16;
  private static final int maxScreenRow = 12;
  public static final int TILE_SIZE = 48;
  public static final int screenWidth = TILE_SIZE * maxScreenCol; // 768 px
  public static final int screenHeight = TILE_SIZE * maxScreenRow; // 576 px
  public static final int screenCenterX = screenWidth / 2;
  public static final int screenCenterY = screenHeight / 2;

  // FPS設定
  private static final int FPS = 60;
  private static final double DRAW_INTERVAL = 1000000000 / FPS;

  private Thread gameThread;

  private final KeyInputHandler keyInputHandler;

  private final LocationClientService locationClientService;

  private final WorldMapService worldMapService;

  private WorldMap worldMap;

  private final Player player = new Player(new Location(200, 200));

  private final Player player2 = new Player(new Location(100, 100));

  private boolean isUpdateFinished = false;

  public GamePanel(final KeyInputHandler keyInputHandler, final LocationClientService locationClientService, final WorldMapService worldMapService) {
    this.keyInputHandler = keyInputHandler;
    this.locationClientService = locationClientService;
    this.worldMapService = worldMapService;
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyInputHandler);
    this.setFocusable(true);
  }

  @PostConstruct
  public void init() {
    worldMap = worldMapService.worldMap();
    System.out.println(worldMap);
  }

  public void startGameThread() {
    gameThread = new Thread(this);
    gameThread.start();
  }

  @Override
  public void run() {
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;

    while (gameThread != null) {
      currentTime = System.nanoTime();
      delta += (currentTime - lastTime) / DRAW_INTERVAL;
      lastTime = currentTime;

      if (!isUpdateFinished) {
        update();
        isUpdateFinished = true;
      }

      if (delta >= 1) {
        repaint();
        delta--;
        isUpdateFinished = false;
      }
    }
  }

  private void update() {
    Vector vector = keyInputHandler.getKeyInputType().getVector();
    player.move(vector);
    locationClientService.receiveLocation(player2);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    draw(g2);
  }

  private void draw(Graphics2D g2) {
    if (player == null || worldMap == null) return;

    // タイル
    for (Tile[] tiles : worldMap.tiles()) {
      for (Tile tile : tiles) {
        Triple<Boolean, Integer, Integer> result = canDisplayAndDistanceFromPlayer(tile.location(), player.location());
        if (Boolean.TRUE.equals(result.getLeft())) {
          g2.drawImage(tile.getBufferedImage(), GamePanel.screenCenterX + result.getMiddle(), GamePanel.screenCenterY + result.getRight(), null);
        }
      }
    }

    // プレイヤー1
    g2.setColor(Color.white);
    g2.fillRect(screenCenterX, screenCenterY, TILE_SIZE, TILE_SIZE);
    // プレイヤー2
    g2.setColor(Color.red);
    g2.fillRect(player2.location().getX(), player2.location().getY(), TILE_SIZE, TILE_SIZE);
    g2.dispose();
  }

  private Triple<Boolean, Integer, Integer> canDisplayAndDistanceFromPlayer(Location location, Location playerLocation) {
    int distanceX = location.getX() - playerLocation.getX();
    int distanceY = location.getY() - playerLocation.getY();
    boolean canDisplay = Math.abs(distanceX) <= GamePanel.screenWidth / 2 + Tile.TILE_SIZE &&
      Math.abs(distanceY) <= GamePanel.screenHeight / 2 + Tile.TILE_SIZE;

    return Triple.of(canDisplay, distanceX, distanceY);
  }
}
