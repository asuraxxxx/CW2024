package com.example.demo.actors.projectiles;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.strategies.projectile.ProjectileMovementStrategy;

/**
 * The Projectile class is an abstract class that represents a projectile in the game.
 * It extends the ActiveActorDestructible class and includes a movement strategy.
 */
public abstract class Projectile extends ActiveActorDestructible {
    private ProjectileMovementStrategy movementStrategy; // Strategy for projectile movement

    /**
     * Constructor for Projectile.
     * Initializes the projectile with specific attributes.
     * @param imageName The image file name for the projectile.
     * @param imageHeight The height of the projectile image.
     * @param initialXPos The initial X position of the projectile.
     * @param initialYPos The initial Y position of the projectile.
     */
    public Projectile(String imageName, int imageHeight, double initialXPos, double initialYPos) {
        super(imageName, imageHeight, initialXPos, initialYPos);
    }

    /**
     * Sets the movement strategy for the projectile.
     * @param movementStrategy The movement strategy to be set.
     */
    public void setMovementStrategy(ProjectileMovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    /**
     * Updates the position of the projectile based on the current movement strategy.
     */
    @Override
    public void updatePosition() {
        if (movementStrategy != null) {
            movementStrategy.updatePosition(this);
        }
    }

    /**
     * Handles the damage taken by the projectile.
     * Destroys the projectile when it takes damage.
     */
    @Override
    public void takeDamage() {
        this.destroy();
    }
}