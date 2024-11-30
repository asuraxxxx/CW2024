package com.example.demo.actors.planes;

import com.example.demo.actors.projectiles.EnemyProjectile;
import com.example.demo.strategies.movement.HorizontalMovementStrategy;

/**
 * The EnemyPlane class represents a basic enemy plane in the game.
 * It extends the FighterPlane class and includes specific movement and firing strategies.
 */
public class EnemyPlane extends FighterPlane {

    /**
     * Constructor for EnemyPlane.
     * Initializes the plane with specific attributes and sets its movement and firing strategies.
     * @param initialXPos The initial X position of the plane.
     * @param initialYPos The initial Y position of the plane.
     */
    public EnemyPlane(double initialXPos, double initialYPos) {
        super("enemyplane.png", 150, initialXPos, initialYPos, 1);
        setMovementStrategy(new HorizontalMovementStrategy(-6));
        setFiringStrategy(() -> Math.random() < 0.01 ? new EnemyProjectile(getProjectileXPosition(-100.0), getProjectileYPosition(50.0)) : null);
    }

    /**
     * Updates the state of the EnemyPlane.
     * This includes updating its position.
     */
    @Override
    public void updateActor() {
        updatePosition();
    }
}