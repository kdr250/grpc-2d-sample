package com.example.client;

/**
 * 衝突可能
 */
public interface Collidable {
  Location location();
  Collision collision();
}
