package com.example.demo.strategies.projectile;

import com.example.demo.actors.projectiles.Projectile;

public interface ProjectileMovementStrategy {
    void updatePosition(Projectile projectile);
}