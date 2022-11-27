package com.example.client;

import java.awt.image.BufferedImage;

public class Tile implements Collidable {
  private final String name;
  private final Location location;
  private final BufferedImage bufferedImage;
  private final Collision collision;
  public static final int TILE_SIZE = 48; // 1タイル48px四方

  public Tile(final String name, final Location location, final BufferedImage bufferedImage, final boolean isCollidable) {
    this.name = name;
    this.location = location;
    this.bufferedImage = bufferedImage;
    collision = isCollidable ? new Collision(location) : Collision.NO_COLLISION;
  }

  public boolean contains(final Location location) {
    int diffX = location.getX() - this.location.getX();
    int diffY = location.getY() - this.location.getY();

    boolean containsX = diffX >= TILE_SIZE * -1 && diffX <= TILE_SIZE;
    boolean containsY = diffY >= TILE_SIZE * -1 && diffY <= TILE_SIZE;

    return containsX && containsY;
  }

  @Override
  public Location location() {
    return location;
  }

  @Override
  public Collision collision() {
    return collision;
  }

  public BufferedImage getBufferedImage() {
    return bufferedImage;
  }
}

