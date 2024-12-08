package com.example.demo.actors.projectiles;

import com.example.demo.strategies.projectile.HorizontalProjectileMovementStrategy;

/**
 * The EnemyProjectile class represents a projectile fired by enemy planes in the game.
 * It extends the Projectile class and includes specific attributes and movement strategy.
 */
public class EnemyProjectile extends Projectile {
    private static final String IMAGE_NAME = "enemyFire.png"; // Image file name for the projectile
    private static final int IMAGE_HEIGHT = 50; // Height of the projectile image
    private static final int HORIZONTAL_VELOCITY = -10; // Horizontal velocity of the projectile

    /**
     * Constructor for EnemyProjectile.
     * Initializes the projectile with specific attributes and sets its movement strategy.
     * @param initialXPos The initial X position of the projectile.
     * @param initialYPos The initial Y position of the projectile.
     */
    public EnemyProjectile(double initialXPos, double initialYPos) {
        super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos);
        setMovementStrategy(new HorizontalProjectileMovementStrategy(HORIZONTAL_VELOCITY));
    }

    /**
     * Updates the state of the EnemyProjectile.
     * This includes updating its position.
     */
    @Override
    public void updateActor() {
        updatePosition();
    }
}