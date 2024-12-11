package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.projectiles.UserProjectile;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Represents the user's plane in the game, which can move in all directions and fire projectiles.
 * The plane has a hitbox for collision detection and tracks the number of kills.
 */
public class UserPlane extends FighterPlane {
    private int verticalVelocityMultiplier;
    private int horizontalVelocityMultiplier;
    private int numberOfKills;
    private Rectangle hitbox;

    /**
     * Constructs a UserPlane with specified initial health.
     *
     * @param initialHealth the initial health of the user's plane
     */
    public UserPlane(int initialHealth) {
        super("userplane.png", 150, 5.0, 300.0, initialHealth);
        verticalVelocityMultiplier = 0;
        horizontalVelocityMultiplier = 0;
        hitbox = new Rectangle();
        hitbox.setStroke(Color.RED);
        hitbox.setFill(Color.TRANSPARENT);
        updateHitbox();
    }

    /**
     * Updates the position of the user's plane based on its velocity multipliers.
     * Ensures the plane stays within the game area bounds.
     */
    @Override
    public void updatePosition() {
        if (verticalVelocityMultiplier != 0) {
            double initialTranslateY = getTranslateY();
            moveVertically(8 * verticalVelocityMultiplier);
            double newPositionY = getLayoutY() + getTranslateY();
            if (newPositionY < -40 || newPositionY > 600.0) {
                setTranslateY(initialTranslateY);
            }
        }
        if (horizontalVelocityMultiplier != 0) {
            double initialTranslateX = getTranslateX();
            moveHorizontally(8 * horizontalVelocityMultiplier);
            double newPositionX = getLayoutX() + getTranslateX();
            if (newPositionX < 0.0 || newPositionX > 800.0) {
                setTranslateX(initialTranslateX);
            }
        }
        updateHitbox();
    }

    /**
     * Updates the state of the user's plane, including its position.
     */
    @Override
    public void updateActor() {
        updatePosition();
    }

    /**
     * Fires a projectile from the user's plane.
     *
     * @return the fired projectile
     */
    @Override
    public ActiveActorDestructible fireProjectile() {
        return new UserProjectile(110, getProjectileYPosition(20));
    }

    /**
     * Moves the plane up by setting the vertical velocity multiplier.
     */
    public void moveUp() {
        verticalVelocityMultiplier = -1;
    }

    /**
     * Moves the plane down by setting the vertical velocity multiplier.
     */
    public void moveDown() {
        verticalVelocityMultiplier = 1;
    }

    /**
     * Moves the plane left by setting the horizontal velocity multiplier.
     */
    public void moveLeft() {
        horizontalVelocityMultiplier = -1;
    }

    /**
     * Moves the plane right by setting the horizontal velocity multiplier.
     */
    public void moveRight() {
        horizontalVelocityMultiplier = 1;
    }

    /**
     * Stops the vertical movement of the plane.
     */
    public void stopVerticalMovement() {
        verticalVelocityMultiplier = 0;
    }

    /**
     * Stops the horizontal movement of the plane.
     */
    public void stopHorizontalMovement() {
        horizontalVelocityMultiplier = 0;
    }

    /**
     * Gets the number of kills made by the user's plane.
     *
     * @return the number of kills
     */
    public int getNumberOfKills() {
        return numberOfKills;
    }

    /**
     * Increments the kill count of the user's plane.
     */
    public void incrementKillCount() {
        numberOfKills++;
    }

    /**
     * Gets the custom bounds of the user's plane for collision detection.
     *
     * @return the custom bounds of the plane
     */
    public Bounds getCustomBounds() {
        double hitboxWidth = getFitWidth() * 0.3;
        double hitboxHeight = getFitHeight() * 0.3;
        double offsetX = (getFitWidth() - hitboxWidth) / 2;
        double offsetY = (getFitHeight() - hitboxHeight) / 2;
        return new Rectangle(getLayoutX() + offsetX, getLayoutY() + offsetY, hitboxWidth, hitboxHeight).getBoundsInParent();
    }

    /**
     * Updates the hitbox of the user's plane based on its current position and size.
     */
    private void updateHitbox() {
        Bounds bounds = getCustomBounds();
        hitbox.setX(bounds.getMinX());
        hitbox.setY(bounds.getMinY());
        hitbox.setWidth(bounds.getWidth());
        hitbox.setHeight(bounds.getHeight());
    }

    /**
     * Gets the hitbox of the user's plane.
     *
     * @return the hitbox
     */
    public Rectangle getHitbox() {
        return hitbox;
    }
}