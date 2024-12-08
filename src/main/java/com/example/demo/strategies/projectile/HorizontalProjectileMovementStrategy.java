package com.example.demo.strategies.projectile;

import com.example.demo.actors.projectiles.Projectile;

/**
 * The HorizontalProjectileMovementStrategy class implements the ProjectileMovementStrategy interface.
 * It defines a strategy for moving a projectile horizontally.
 */
public class HorizontalProjectileMovementStrategy implements ProjectileMovementStrategy {
    private final int velocity; // The velocity at which the projectile moves horizontally

    /**
     * Constructor for HorizontalProjectileMovementStrategy.
     * Initializes the strategy with a specific velocity.
     * @param velocity The horizontal velocity for the projectile.
     */
    public HorizontalProjectileMovementStrategy(int velocity) {
        this.velocity = velocity;
    }

    /**
     * Updates the position of the projectile by moving it horizontally.
     * @param projectile The projectile whose position is to be updated.
     */
    @Override
    public void updatePosition(Projectile projectile) {
        projectile.moveHorizontally(velocity);
    }
}