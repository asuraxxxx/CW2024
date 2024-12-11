package com.example.demo.actors.planes;

import com.example.demo.actors.projectiles.EnemyProjectile;
import com.example.demo.strategies.movement.HorizontalMovementStrategy;

/**
 * Represents a second type of enemy plane in the game, which moves horizontally and can fire projectiles.
 */
public class EnemyPlane2 extends FighterPlane {

    /**
     * Constructs an EnemyPlane2 with specified initial positions.
     *
     * @param initialXPos the initial X position of the enemy plane
     * @param initialYPos the initial Y position of the enemy plane
     */
    public EnemyPlane2(double initialXPos, double initialYPos) {
        super("enemyplane2.png", 80, initialXPos, initialYPos, 1);
        setMovementStrategy(new HorizontalMovementStrategy(-5));
        setFiringStrategy(() -> Math.random() < 0.01 ? new EnemyProjectile(getProjectileXPosition(-100.0), getProjectileYPosition(50.0)) : null);
    }

    /**
     * Updates the state of the enemy plane, including its position.
     */
    @Override
    public void updateActor() {
        updatePosition();
    }
}