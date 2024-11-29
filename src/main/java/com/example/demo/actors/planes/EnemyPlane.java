package com.example.demo.actors.planes;

import com.example.demo.actors.projectiles.EnemyProjectile;
import com.example.demo.strategies.movement.HorizontalMovementStrategy;

public class EnemyPlane extends FighterPlane {
    public EnemyPlane(double initialXPos, double initialYPos) {
        super("enemyplane.png", 150, initialXPos, initialYPos, 1);
        setMovementStrategy(new HorizontalMovementStrategy(-6));
        setFiringStrategy(() -> Math.random() < 0.01 ? new EnemyProjectile(getProjectileXPosition(-100.0), getProjectileYPosition(50.0)) : null);
    }

    @Override
    public void updateActor() {
        updatePosition();
    }
}