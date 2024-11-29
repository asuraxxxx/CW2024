package com.example.demo.actors.projectiles;

import com.example.demo.strategies.projectile.HorizontalProjectileMovementStrategy;

public class BossProjectile extends Projectile {
    private static final String IMAGE_NAME = "fireball.png";
    private static final int IMAGE_HEIGHT = 50; 
    private static final int HORIZONTAL_VELOCITY = -15;
    private static final int INITIAL_X_POSITION = 950;

    public BossProjectile(double initialYPos) {
        super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, initialYPos);
        setMovementStrategy(new HorizontalProjectileMovementStrategy(HORIZONTAL_VELOCITY));
    }

    @Override
    public void updateActor() {
        updatePosition();
    }
}