package com.example.client;

import java.util.UUID;

public class Player {
  private String id;
  private String name;
  private Location location;

  public Player(final String id, final String name, final Location location) {
    this.id = id;
    this.name = name;
    this.location = location;
  }

  public Player(final String name, final Location location) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.location = location;
  }

  public void move(final Vector vector) {
    location = location.shift(vector);
  }

  public void warp(final Location location) {
    this.location = location;
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
}
