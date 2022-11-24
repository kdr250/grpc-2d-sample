package com.example.client;

public class Player {
  private Location location;

  public Player(final Location location) {
    this.location = location;
  }

  public void move(final Vector vector) {
    location = location.shift(vector);
  }

  public Location getLocation() {
    return location;
  }
}
