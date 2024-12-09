package com.example.demo.actors.projectiles;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.strategies.projectile.ProjectileMovementStrategy;

public abstract class Projectile extends ActiveActorDestructible {
    private ProjectileMovementStrategy movementStrategy;

    public Projectile(String imageName, int imageHeight, double initialXPos, double initialYPos) {
        super(imageName, imageHeight, initialXPos, initialYPos);
    }

    public void setMovementStrategy(ProjectileMovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    @Override
    public void updatePosition() {
        if (movementStrategy != null) {
            movementStrategy.updatePosition(this);
        }
    }

    @Override
    public void takeDamage() {
        this.destroy();
    }
}