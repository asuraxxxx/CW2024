package com.example.demo.strategies.projectile;

import com.example.demo.actors.ActiveActorDestructible;

/**
 * The ProjectileFiringStrategy interface defines the method required for a projectile firing strategy.
 * Any class implementing this interface must provide an implementation for firing a projectile.
 */
public interface ProjectileFiringStrategy {

    /**
     * Fires a projectile.
     * @return The fired projectile, or null if no projectile is fired.
     */
    ActiveActorDestructible fireProjectile();
}