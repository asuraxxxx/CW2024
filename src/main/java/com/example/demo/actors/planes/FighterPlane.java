package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.strategies.movement.MovementStrategy;
import com.example.demo.strategies.projectile.ProjectileFiringStrategy;

/**
 * Represents a fighter plane in the game, which can move and fire projectiles.
 * This is an abstract class that provides common functionality for all fighter planes.
 */
public abstract class FighterPlane extends ActiveActorDestructible {
    private int health;
    private MovementStrategy movementStrategy;
    private ProjectileFiringStrategy firingStrategy;

    /**
     * Constructs a FighterPlane with specified parameters.
     *
     * @param imageName the name of the image representing the plane
     * @param imageHeight the height of the plane's image
     * @param initialXPos the initial X position of the plane
     * @param initialYPos the initial Y position of the plane
     * @param health the initial health of the plane
     */
    public FighterPlane(String imageName, int imageHeight, double initialXPos, double initialYPos, int health) {
        super(imageName, imageHeight, initialXPos, initialYPos);
        this.health = health;
    }

    /**
     * Sets the movement strategy for the plane.
     *
     * @param movementStrategy the movement strategy to be used
     */
    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    /**
     * Sets the firing strategy for the plane.
     *
     * @param firingStrategy the firing strategy to be used
     */
    public void setFiringStrategy(ProjectileFiringStrategy firingStrategy) {
        this.firingStrategy = firingStrategy;
    }

    /**
     * Updates the position of the plane based on its movement strategy.
     */
    public void updatePosition() {
        if (movementStrategy != null) {
            movementStrategy.updatePosition(this);
        }
    }

    /**
     * Fires a projectile based on the plane's firing strategy.
     *
     * @return the fired projectile, or null if no projectile is fired
     */
    public ActiveActorDestructible fireProjectile() {
        if (firingStrategy != null) {
            return firingStrategy.fireProjectile();
        }
        return null;
    }

    /**
     * Reduces the plane's health by one. If health reaches zero, the plane is destroyed.
     */
    @Override
    public void takeDamage() {
        health--;
        if (health == 0) {
            this.destroy();
        }
    }

    /**
     * Gets the current health of the plane.
     *
     * @return the current health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Calculates the X position for firing a projectile.
     *
     * @param xPositionOffset the offset to be added to the current X position
     * @return the calculated X position
     */
    protected double getProjectileXPosition(double xPositionOffset) {
        return getLayoutX() + getTranslateX() + xPositionOffset;
    }

    /**
     * Calculates the Y position for firing a projectile.
     *
     * @param yPositionOffset the offset to be added to the current Y position
     * @return the calculated Y position
     */
    protected double getProjectileYPosition(double yPositionOffset) {
        return getLayoutY() + getTranslateY() + yPositionOffset;
    }
}