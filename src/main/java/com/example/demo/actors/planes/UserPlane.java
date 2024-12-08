package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.projectiles.UserProjectile;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * The UserPlane class represents the player's plane in the game.
 * It extends the FighterPlane class and includes movement, firing, and hitbox functionalities.
 */
public class UserPlane extends FighterPlane {
    private int verticalVelocityMultiplier; // Multiplier for vertical movement speed
    private int horizontalVelocityMultiplier; // Multiplier for horizontal movement speed
    private int numberOfKills; // Counter for the number of kills made by the player
    private Rectangle hitbox; // Hitbox for collision detection

    /**
     * Constructor for UserPlane.
     * Initializes the plane with specific attributes and sets up the hitbox.
     * @param initialHealth The initial health of the plane.
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
     * Updates the position of the UserPlane based on the current velocity multipliers.
     * Ensures the plane does not move out of the allowed bounds.
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
     * Updates the state of the UserPlane.
     * This includes updating its position.
     */
    @Override
    public void updateActor() {
        updatePosition();
    }

    /**
     * Fires a projectile from the UserPlane.
     * @return The fired projectile.
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
     * Gets the number of kills made by the player.
     * @return The number of kills.
     */
    public int getNumberOfKills() {
        return numberOfKills;
    }

    /**
     * Increments the kill count by one.
     */
    public void incrementKillCount() {
        numberOfKills++;
    }

    /**
     * Gets the custom bounds for the hitbox of the plane.
     * @return The bounds of the hitbox.
     */
    public Bounds getCustomBounds() {
        double hitboxWidth = getFitWidth() * 0.3;
        double hitboxHeight = getFitHeight() * 0.3;
        double offsetX = (getFitWidth() - hitboxWidth) / 2;
        double offsetY = (getFitHeight() - hitboxHeight) / 2;
        return new Rectangle(getLayoutX() + offsetX, getLayoutY() + offsetY, hitboxWidth, hitboxHeight).getBoundsInParent();
    }

    /**
     * Updates the hitbox position and size based on the current bounds.
     */
    private void updateHitbox() {
        Bounds bounds = getCustomBounds();
        hitbox.setX(bounds.getMinX());
        hitbox.setY(bounds.getMinY());
        hitbox.setWidth(bounds.getWidth());
        hitbox.setHeight(bounds.getHeight());
    }

    /**
     * Gets the hitbox of the plane.
     * @return The hitbox.
     */
    public Rectangle getHitbox() {
        return hitbox;
    }
}