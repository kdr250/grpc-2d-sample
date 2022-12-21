package com.example.client;

import org.apache.commons.lang3.tuple.Triple;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class GamePanel extends JPanel implements Runnable {

  // スクリーン設定
  private static final int maxScreenCol = 16;
  private static final int maxScreenRow = 12;
  public static final int screenWidth = Tile.TILE_SIZE * maxScreenCol; // 768 px
  public static final int screenHeight = Tile.TILE_SIZE * maxScreenRow; // 576 px
  public static final int screenCenterX = screenWidth / 2;
  public static final int screenCenterY = screenHeight / 2;

  Font arial15 = new Font("Arial", Font.BOLD, 15);

  // FPS設定
  private static final int FPS = 60;
  public static final double DRAW_INTERVAL = 1000000000 / FPS;

  private Thread gameThread;

  private final KeyInputHandler keyInputHandler;

  private final WorldMapService worldMapService;

  private final PlayerService playerService;

  private final TalkService talkService;

  private WorldMap worldMap;

  private boolean isUpdateFinished = false;

  public GamePanel(final KeyInputHandler keyInputHandler, final WorldMapService worldMapService, final PlayerService playerService, final TalkService talkService) {
    this.keyInputHandler = keyInputHandler;
    this.worldMapService = worldMapService;
    this.playerService = playerService;
    this.talkService = talkService;
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyInputHandler);
    this.setFocusable(true);
  }

  @PostConstruct
  public void init() {
    worldMap = worldMapService.worldMap();
  }

  public void startThread(String playerName, PlayerCharacterType playerCharacterType) {
    playerService.startThread(playerName, playerCharacterType);
    talkService.startThread();
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
    Player player = playerService.player();

    if (player == null || worldMap == null) return;

    List<Collidable> collidableList = createCollidableList(player.location().shift(vector));

    // プレイヤー
    if (!playerService.canMove(collidableList, vector)) {
      // TODO: 方向を変える
      return;
    }
    playerService.movePlayer(vector);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    draw(g2);
  }

  private void draw(Graphics2D g2) {
    if (worldMap == null) return;

    g2.setFont(arial15);
    g2.setColor(Color.black);

    Player player = playerService.player();

    // タイル
    for (Tile[] tiles : worldMap.tiles()) {
      for (Tile tile : tiles) {
        Triple<Boolean, Integer, Integer> result = canDisplayAndDistanceFromPlayer(tile.location(), player.location());
        if (Boolean.TRUE.equals(result.getLeft())) {
          g2.drawImage(tile.getBufferedImage(), GamePanel.screenCenterX + result.getMiddle(), GamePanel.screenCenterY + result.getRight(), null);
        }
      }
    }

    // 他のプレイヤー
    OtherPlayers otherPlayers = playerService.otherPlayers();

    otherPlayers.values().forEach(other -> {
      Triple<Boolean, Integer, Integer> result = canDisplayAndDistanceFromPlayer(other.location(), player.location());
      if (Boolean.TRUE.equals(result.getLeft())) {
        String name = other.name();
        drawOtherPlayerName(g2, name, result.getMiddle(), result.getRight());
        g2.drawImage(other.getAnimatedImage(), GamePanel.screenCenterX + result.getMiddle(), GamePanel.screenCenterY + result.getRight(), null);
      }
    });

    // プレイヤー
    if (player.isAnimationReady()) {
      String name = player.name();
      drawPlayerName(g2, name);
      g2.drawImage(player.getAnimatedImage(), GamePanel.screenCenterX, GamePanel.screenCenterY, null);
    }

    g2.dispose();
  }

  private Triple<Boolean, Integer, Integer> canDisplayAndDistanceFromPlayer(Location location, Location playerLocation) {
    int distanceX = location.getX() - playerLocation.getX();
    int distanceY = location.getY() - playerLocation.getY();
    boolean canDisplay = Math.abs(distanceX) <= GamePanel.screenWidth / 2 + Tile.TILE_SIZE &&
      Math.abs(distanceY) <= GamePanel.screenHeight / 2 + Tile.TILE_SIZE;

    return Triple.of(canDisplay, distanceX, distanceY);
  }

  private List<Collidable> createCollidableList(Location willMoveLocation) {
    Player player = playerService.player();

    List<Collidable> collidableList = new ArrayList<>();
    collidableList.add(player);
    collidableList.addAll(worldMap.getTilesFromLocation(willMoveLocation));
    return collidableList;
  }

  private void drawPlayerName(Graphics2D g2, String name) {
    int width = (int)g2.getFontMetrics().getStringBounds(name, g2).getWidth();
    int x = GamePanel.screenCenterX + Tile.TILE_SIZE / 2 - width / 2;
    int height = (int)g2.getFontMetrics().getStringBounds(name, g2).getHeight();
    int y = GamePanel.screenCenterY - height + 6;
    drawSubWindow(g2, x - 3, y - height, width + 6, height + 6);
    g2.setColor(Color.white);
    g2.drawString(name, x, y);
  }

  private void drawOtherPlayerName(Graphics2D g2, String name, int distanceX, int distanceY) {
    int width = (int)g2.getFontMetrics().getStringBounds(name, g2).getWidth();
    int x = GamePanel.screenCenterX + distanceX + Tile.TILE_SIZE / 2 - width / 2;
    int height = (int)g2.getFontMetrics().getStringBounds(name, g2).getHeight();
    int y = GamePanel.screenCenterY + distanceY - height + 6;
    drawSubWindow(g2, x - 3, y - height, width + 6, height + 6);
    g2.setColor(Color.white);
    g2.drawString(name, x, y);
  }

  private void drawSubWindow(Graphics2D g2, int x, int y, int width, int height) {
    g2.setColor(new Color(0, 0, 0, 160));
    g2.fillRoundRect(x, y, width, height, 3, 3);
  }
}
