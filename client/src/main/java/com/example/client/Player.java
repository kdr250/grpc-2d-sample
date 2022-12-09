package com.example.client;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.UUID;

public class Player implements Collidable {
  private final String id;
  private final String name;
  private Location location;
  private Collision collision;
  private Direction direction;
  private PlayerAnimation playerAnimation; // TODO: finalに修正したい

  public Player(final String id, final String name, final Location location, final PlayerAnimation playerAnimation) {
    this.id = id;
    this.name = name;
    this.location = location;
    this.collision = new Collision(location);
    this.playerAnimation = playerAnimation;
  }

  public Player(final String name, final Location location) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.location = location;
    this.collision = new Collision(location);
    this.direction = Direction.DOWN;
  }

  public void move(final Vector vector) {
    location = location.shift(vector);
    collision = collision.shift(vector);
    direction = vector.direction();
  }

  public boolean canMove(final List<Collidable> collidableList, final Vector vector) {
    return collidableList.stream()
      .filter(collidable -> this != collidable)
      .noneMatch(collidable -> collision.willCollide(collidable.collision(), vector));
  }

  public BufferedImage getAnimatedImage() {
    return playerAnimation.getAnimatedImage(direction);
  }

  public boolean isAnimationReady() {
    return playerAnimation != null;
  }

  public String name() {
    return name;
  }

  public String id() {
    return id;
  }

  // TODO: 完全コンストラクタで初期化するよう修正したい
  public void setPlayerAnimation(final PlayerAnimation playerAnimation) {
    this.playerAnimation = playerAnimation;
  }

  @Override
  public Location location() {
    return location;
  }

  @Override
  public Collision collision() {
    return collision;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Player)) return false;

    Player other = (Player)obj;

    return this.id.equals(other.id);
  }
}
