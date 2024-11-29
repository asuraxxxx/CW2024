package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.strategies.movement.MovementStrategy;
import com.example.demo.strategies.projectile.ProjectileFiringStrategy;

public abstract class FighterPlane extends ActiveActorDestructible {
    private int health;
    private MovementStrategy movementStrategy;
    private ProjectileFiringStrategy firingStrategy;

    public FighterPlane(String imageName, int imageHeight, double initialXPos, double initialYPos, int health) {
        super(imageName, imageHeight, initialXPos, initialYPos);
        this.health = health;
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public void setFiringStrategy(ProjectileFiringStrategy firingStrategy) {
        this.firingStrategy = firingStrategy;
    }

    public void updatePosition() {
        if (movementStrategy != null) {
            movementStrategy.updatePosition(this);
        }
    }

    public ActiveActorDestructible fireProjectile() {
        if (firingStrategy != null) {
            return firingStrategy.fireProjectile();
        }
        return null;
    }

    @Override
    public void takeDamage() {
        health--;
        if (health == 0) {
            this.destroy();
        }
    }

    public int getHealth() {
        return health;
    }

    protected double getProjectileXPosition(double xPositionOffset) {
        return getLayoutX() + getTranslateX() + xPositionOffset;
    }

    protected double getProjectileYPosition(double yPositionOffset) {
        return getLayoutY() + getTranslateY() + yPositionOffset;
    }
}