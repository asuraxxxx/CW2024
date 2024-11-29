package com.example.demo.strategies.projectile;

import com.example.demo.actors.projectiles.Projectile;

public class HorizontalProjectileMovementStrategy implements ProjectileMovementStrategy {
    private final int velocity;

    public HorizontalProjectileMovementStrategy(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public void updatePosition(Projectile projectile) {
        projectile.moveHorizontally(velocity);
    }
}