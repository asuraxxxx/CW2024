package com.example.demo.actors.projectiles;

import com.example.demo.strategies.projectile.HorizontalProjectileMovementStrategy;

/**
 * Represents a projectile fired by an enemy plane in the game.
 * The projectile moves horizontally with a specified velocity.
 */
public class EnemyProjectile extends Projectile {
    private static final String IMAGE_NAME = "enemyFire.png";
    private static final int IMAGE_HEIGHT = 50;
    private static final int HORIZONTAL_VELOCITY = -10;

    /**
     * Constructs an EnemyProjectile with specified initial positions.
     *
     * @param initialXPos the initial X position of the projectile
     * @param initialYPos the initial Y position of the projectile
     */
    public EnemyProjectile(double initialXPos, double initialYPos) {
        super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos);
        setMovementStrategy(new HorizontalProjectileMovementStrategy(HORIZONTAL_VELOCITY));
    }

    /**
     * Updates the state of the projectile, including its position.
     */
    @Override
    public void updateActor() {
        updatePosition();
    }
}