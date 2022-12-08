package com.example.client;

import java.util.List;
import java.util.UUID;

public class Player implements Collidable {
  private final String id;
  private final String name;
  private Location location;
  private Collision collision;

  public Player(final String id, final String name, final Location location) {
    this.id = id;
    this.name = name;
    this.location = location;
    this.collision = new Collision(location);
  }

  public Player(final String name, final Location location) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.location = location;
    this.collision = new Collision(location);
  }

  public void move(final Vector vector) {
    location = location.shift(vector);
    collision = collision.shift(vector);
  }

  public void warp(final Location location) {
    this.location = location;
  }

  public boolean canMove(final List<Collidable> collidableList, final Vector vector) {
    return collidableList.stream()
      .filter(collidable -> this != collidable)
      .noneMatch(collidable -> collision.willCollide(collidable.collision(), vector));
  }

  public String name() {
    return name;
  }

  public String id() {
    return id;
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
