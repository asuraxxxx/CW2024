package com.example.demo.actors.projectiles;

import com.example.demo.audio.ProjectileSoundController;

/**
 * Represents a projectile fired by the user's plane in the game.
 * The projectile moves horizontally and plays a shooting sound when fired.
 */
public class UserProjectile extends Projectile {
    private static final String IMAGE_NAME = "userfire.png";
    private static final int IMAGE_HEIGHT = 125;
    private static final int HORIZONTAL_VELOCITY = 15;
    private static final String SHOOTING_SOUND = "/com/example/demo/audios/shooteffect.mp3";

    /**
     * Constructs a UserProjectile with specified initial positions.
     * Plays a shooting sound upon creation.
     *
     * @param initialXPos the initial X position of the projectile
     * @param initialYPos the initial Y position of the projectile
     */
    public UserProjectile(double initialXPos, double initialYPos) {
        super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos);
        ProjectileSoundController.playSound(SHOOTING_SOUND);
    }

    /**
     * Updates the position of the projectile by moving it horizontally.
     */
    @Override
    public void updatePosition() {
        moveHorizontally(HORIZONTAL_VELOCITY);
    }

    /**
     * Updates the state of the projectile, including its position.
     */
    @Override
    public void updateActor() {
        updatePosition();
    }
}