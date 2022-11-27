package com.example.client;

public class Player {
  private Location location;

  public Player(final Location location) {
    this.location = location;
  }

  public void move(final Vector vector) {
    location = location.shift(vector);
  }

  public void warp(final Location location) {
    this.location = location;
  }

  public Location location() {
    return location;
  }
}
