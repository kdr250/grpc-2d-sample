package com.example.client;

import java.awt.event.KeyEvent;

public enum KeyInputType {
  UP(Vector.up(8)),
  DOWN(Vector.down(8)),
  LEFT(Vector.left(8)),
  RIGHT(Vector.right(8)),
  DECIDE(Vector.NONE),
  DISPLAY_ITEM_LIST(Vector.NONE),
  NONE(Vector.NONE);

  private final Vector vector;

  KeyInputType(Vector vector) {
    this.vector = vector;
  }

  public static KeyInputType from(int keyCode) {
    switch (keyCode) {
      case KeyEvent.VK_W:
        return KeyInputType.UP;
      case KeyEvent.VK_S:
        return KeyInputType.DOWN;
      case KeyEvent.VK_A:
        return KeyInputType.LEFT;
      case KeyEvent.VK_D:
        return KeyInputType.RIGHT;
      case KeyEvent.VK_I:
        return KeyInputType.DISPLAY_ITEM_LIST;
      case KeyEvent.VK_ENTER:
        return KeyInputType.DECIDE;
      default:
        return KeyInputType.NONE;
    }
  }

  public Vector getVector() {
    return vector;
  }
}
