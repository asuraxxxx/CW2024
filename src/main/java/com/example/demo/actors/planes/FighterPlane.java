package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.strategies.movement.MovementStrategy;
import com.example.demo.strategies.projectile.ProjectileFiringStrategy;

/**
 * The FighterPlane class is an abstract class that represents a generic fighter plane in the game.
 * It extends the ActiveActorDestructible class and includes health, movement, and firing strategies.
 */
public abstract class FighterPlane extends ActiveActorDestructible {
    private int health; // Health of the fighter plane
    private MovementStrategy movementStrategy; // Strategy for plane movement
    private ProjectileFiringStrategy firingStrategy; // Strategy for firing projectiles

    /**
     * Constructor for FighterPlane.
     * Initializes the plane with specific attributes.
     * @param imageName The image file name for the plane.
     * @param imageHeight The height of the plane image.
     * @param initialXPos The initial X position of the plane.
     * @param initialYPos The initial Y position of the plane.
     * @param health The health of the plane.
     */
    public FighterPlane(String imageName, int imageHeight, double initialXPos, double initialYPos, int health) {
        super(imageName, imageHeight, initialXPos, initialYPos);
        this.health = health;
    }

    /**
     * Sets the movement strategy for the plane.
     * @param movementStrategy The movement strategy to be set.
     */
    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    /**
     * Sets the firing strategy for the plane.
     * @param firingStrategy The firing strategy to be set.
     */
    public void setFiringStrategy(ProjectileFiringStrategy firingStrategy) {
        this.firingStrategy = firingStrategy;
    }

    /**
     * Updates the position of the plane based on the current movement strategy.
     */
    public void updatePosition() {
        if (movementStrategy != null) {
            movementStrategy.updatePosition(this);
        }
    }

    /**
     * Fires a projectile based on the current firing strategy.
     * @return The fired projectile, or null if no projectile is fired.
     */
    public ActiveActorDestructible fireProjectile() {
        if (firingStrategy != null) {
            return firingStrategy.fireProjectile();
        }
        return null;
    }

    /**
     * Handles the damage taken by the plane.
     * Reduces health and destroys the plane if health reaches zero.
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
     * @return The health of the plane.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Calculates the X position for the projectiles fired by the plane.
     * @param xPositionOffset The offset to be added to the X position.
     * @return The calculated X position for the projectile.
     */
    protected double getProjectileXPosition(double xPositionOffset) {
        return getLayoutX() + getTranslateX() + xPositionOffset;
    }

    /**
     * Calculates the Y position for the projectiles fired by the plane.
     * @param yPositionOffset The offset to be added to the Y position.
     * @return The calculated Y position for the projectile.
     */
    protected double getProjectileYPosition(double yPositionOffset) {
        return getLayoutY() + getTranslateY() + yPositionOffset;
    }
}