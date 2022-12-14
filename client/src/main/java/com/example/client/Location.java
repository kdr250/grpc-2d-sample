package com.example.client;

/**
 * 位置
 */
public class Location {
  private final int x;
  private final int y;

  public Location(final int x, final int y) {
    if (!valid(x, y)) {
      throw new IllegalArgumentException("不正な位置です");
    }

    this.x = x;
    this.y = y;
  }

  public Location shift(final int shiftX, final int shiftY) {
    final int nextX = x + shiftX;
    final int nextY = y + shiftY;
    return new Location(nextX, nextY);
  }

  public Location shift(final Vector vector) {
    final int nextX = x + vector.getX();
    final int nextY = y + vector.getY();
    return new Location(nextX, nextY);
  }

  public Vector vector(final Location destination) {
    int diffX = destination.x - this.x;
    int diffY = destination.y - this.y;
    return new Vector(diffX, diffY);
  }

  public static final Location EMPTY = new Location(0, 0);

  private boolean valid(int x, int y) {
    return x >= 0 && y >= 0;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
