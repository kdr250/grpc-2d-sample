package com.example.client;

/**
 * ベクトル
 */
public class Vector {
  private final int x;
  private final int y;

  public static final Vector NONE = new Vector(0, 0);

  public Vector(final int x, final int y) {
    this.x = x;
    this.y = y;
  }

  public static Vector up(final int length) {
    return new Vector(0, length * -1);
  }

  public static Vector down(final int length) {
    return new Vector(0, length);
  }

  public static Vector left(final int length) {
    return new Vector(length * -1, 0);
  }

  public static Vector right(final int length) {
    return new Vector(length, 0);
  }

  public Direction direction() {
    if (x == 0 && y < 0) return Direction.UP;
    if (x == 0 && y > 0) return Direction.DOWN;
    if (x < 0 && y == 0) return Direction.LEFT;
    if (x > 0 && y == 0) return Direction.RIGHT;
    return Direction.NONE;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
