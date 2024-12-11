package com.example.demo.actors.projectiles;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.strategies.projectile.ProjectileMovementStrategy;

/**
 * Represents a projectile in the game, which can move and take damage.
 * This is an abstract class that provides common functionality for all projectiles.
 */
public abstract class Projectile extends ActiveActorDestructible {
    private ProjectileMovementStrategy movementStrategy;

    /**
     * Constructs a Projectile with specified parameters.
     *
     * @param imageName the name of the image representing the projectile
     * @param imageHeight the height of the projectile's image
     * @param initialXPos the initial X position of the projectile
     * @param initialYPos the initial Y position of the projectile
     */
    public Projectile(String imageName, int imageHeight, double initialXPos, double initialYPos) {
        super(imageName, imageHeight, initialXPos, initialYPos);
    }

    /**
     * Sets the movement strategy for the projectile.
     *
     * @param movementStrategy the movement strategy to be used
     */
    public void setMovementStrategy(ProjectileMovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    /**
     * Updates the position of the projectile based on its movement strategy.
     */
    @Override
    public void updatePosition() {
        if (movementStrategy != null) {
            movementStrategy.updatePosition(this);
        }
    }

    /**
     * Handles the projectile taking damage, which results in its destruction.
     */
    @Override
    public void takeDamage() {
        this.destroy();
    }
}