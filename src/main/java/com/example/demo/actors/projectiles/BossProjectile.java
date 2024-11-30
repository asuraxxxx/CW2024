package com.example.demo.actors.projectiles;

import com.example.demo.strategies.projectile.HorizontalProjectileMovementStrategy;

/**
 * The BossProjectile class represents a projectile fired by the boss plane in the game.
 * It extends the Projectile class and includes specific attributes and movement strategy.
 */
public class BossProjectile extends Projectile {
    private static final String IMAGE_NAME = "fireball.png"; // Image file name for the projectile
    private static final int IMAGE_HEIGHT = 50; // Height of the projectile image
    private static final int HORIZONTAL_VELOCITY = -15; // Horizontal velocity of the projectile
    private static final int INITIAL_X_POSITION = 950; // Initial X position of the projectile

    /**
     * Constructor for BossProjectile.
     * Initializes the projectile with specific attributes and sets its movement strategy.
     * @param initialYPos The initial Y position of the projectile.
     */
    public BossProjectile(double initialYPos) {
        super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, initialYPos);
        setMovementStrategy(new HorizontalProjectileMovementStrategy(HORIZONTAL_VELOCITY));
    }

    /**
     * Updates the state of the BossProjectile.
     * This includes updating its position.
     */
    @Override
    public void updateActor() {
        updatePosition();
    }
}