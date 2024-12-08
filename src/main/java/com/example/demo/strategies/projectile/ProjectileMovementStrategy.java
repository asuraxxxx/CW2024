package com.example.demo.strategies.projectile;

import com.example.demo.actors.projectiles.Projectile;

/**
 * The ProjectileMovementStrategy interface defines the method required for a projectile movement strategy.
 * Any class implementing this interface must provide an implementation for updating the position of a projectile.
 */
public interface ProjectileMovementStrategy {

    /**
     * Updates the position of the specified projectile.
     * @param projectile The projectile whose position is to be updated.
     */
    void updatePosition(Projectile projectile);
}