package com.example.demo.actors.planes;

import com.example.demo.actors.projectiles.EnemyProjectile;
import com.example.demo.strategies.movement.HorizontalMovementStrategy;

public class EnemyPlane2 extends FighterPlane {
    public EnemyPlane2(double initialXPos, double initialYPos) {
        super("enemyplane2.png", 80, initialXPos, initialYPos, 1);
        setMovementStrategy(new HorizontalMovementStrategy(-5));
        setFiringStrategy(() -> Math.random() < 0.01 ? new EnemyProjectile(getProjectileXPosition(-100.0), getProjectileYPosition(50.0)) : null);
    }

    @Override
    public void updateActor() {
        updatePosition();
    }
}