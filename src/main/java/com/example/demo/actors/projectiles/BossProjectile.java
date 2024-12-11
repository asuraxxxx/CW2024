package com.example.demo.actors.projectiles;

import com.example.demo.strategies.projectile.HorizontalProjectileMovementStrategy;

/**
 * Represents a projectile fired by the boss plane in the game.
 * The projectile moves horizontally with a specified velocity.
 */
public class BossProjectile extends Projectile {
    private static final String IMAGE_NAME = "fireball.png";
    private static final int IMAGE_HEIGHT = 50;
    private static final int HORIZONTAL_VELOCITY = -15;
    private static final int INITIAL_X_POSITION = 950;

    /**
     * Constructs a BossProjectile with a specified initial Y position.
     *
     * @param initialYPos the initial Y position of the projectile
     */
    public BossProjectile(double initialYPos) {
        super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, initialYPos);
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