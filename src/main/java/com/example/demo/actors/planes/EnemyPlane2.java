package com.example.demo.actors.planes;

import com.example.demo.actors.projectiles.EnemyProjectile;
import com.example.demo.strategies.movement.HorizontalMovementStrategy;

/**
 * The EnemyPlane2 class represents another type of enemy plane in the game.
 * It extends the FighterPlane class and includes specific movement and firing strategies.
 */
public class EnemyPlane2 extends FighterPlane {

    /**
     * Constructor for EnemyPlane2.
     * Initializes the plane with specific attributes and sets its movement and firing strategies.
     * @param initialXPos The initial X position of the plane.
     * @param initialYPos The initial Y position of the plane.
     */
    public EnemyPlane2(double initialXPos, double initialYPos) {
        super("enemyplane2.png", 80, initialXPos, initialYPos, 1);
        setMovementStrategy(new HorizontalMovementStrategy(-5));
        setFiringStrategy(() -> Math.random() < 0.01 ? new EnemyProjectile(getProjectileXPosition(-100.0), getProjectileYPosition(50.0)) : null);
    }

    /**
     * Updates the state of the EnemyPlane2.
     * This includes updating its position.
     */
    @Override
    public void updateActor() {
        updatePosition();
    }
}