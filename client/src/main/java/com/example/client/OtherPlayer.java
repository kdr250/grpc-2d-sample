package com.example.client;

import java.awt.image.BufferedImage;

public class OtherPlayer {
  private final String id;
  private final String name;
  private Location location;
  private Direction direction;
  private PlayerAnimation playerAnimation; // TODO: finalに修正したい

  private static final long MAX_LIFE_SPAN = 5000;
  private long lastUpdatedTime;

  public OtherPlayer(final String id, final String name, final Location location) {
    this.id = id;
    this.name = name;
    this.location = location;
    this.direction = Direction.DOWN;
    this.lastUpdatedTime = System.currentTimeMillis();
  }

  public OtherPlayer(final String id, final String name, final Location location, final PlayerAnimation playerAnimation) {
    this.id = id;
    this.name = name;
    this.location = location;
    this.direction = Direction.DOWN;
    this.playerAnimation = playerAnimation;
    this.lastUpdatedTime = System.currentTimeMillis();
  }

  public void move(final Vector vector) {
    location = location.shift(vector);
  }

  public void move(final Location destinationLocation) {
    this.direction = this.location.vector(destinationLocation).direction();
    this.location = destinationLocation;
    this.lastUpdatedTime = System.currentTimeMillis();
  }

  public String name() {
    return name;
  }

  public String id() {
    return id;
  }

  public Location location() {
    return location;
  }

  // TODO: 完全コンストラクタで初期化するよう修正したい
  public void setPlayerAnimation(final PlayerAnimation playerAnimation) {
    this.playerAnimation = playerAnimation;
  }

  public BufferedImage getAnimatedImage() {
    return playerAnimation.getAnimatedImage(direction);
  }

  public boolean isAlive() {
    return System.currentTimeMillis() - lastUpdatedTime < MAX_LIFE_SPAN;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Player)) return false;

    OtherPlayer other = (OtherPlayer)obj;

    return this.id.equals(other.id);
  }
}
