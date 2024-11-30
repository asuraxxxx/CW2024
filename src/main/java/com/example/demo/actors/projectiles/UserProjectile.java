package com.example.demo.actors.projectiles;

import com.example.demo.audio.ProjectileSoundController;

/**
 * The UserProjectile class represents a projectile fired by the user's plane in the game.
 * It extends the Projectile class and includes specific attributes and behaviors.
 */
public class UserProjectile extends Projectile {
    private static final String IMAGE_NAME = "userfire.png"; // Image file name for the projectile
    private static final int IMAGE_HEIGHT = 125; // Height of the projectile image
    private static final int HORIZONTAL_VELOCITY = 15; // Horizontal velocity of the projectile
    private static final String SHOOTING_SOUND = "/com/example/demo/audios/shooteffect.mp3"; // Sound effect for shooting

    /**
     * Constructor for UserProjectile.
     * Initializes the projectile with specific attributes and plays the shooting sound.
     * @param initialXPos The initial X position of the projectile.
     * @param initialYPos The initial Y position of the projectile.
     */
    public UserProjectile(double initialXPos, double initialYPos) {
        super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos);
        ProjectileSoundController.playSound(SHOOTING_SOUND);
    }

    /**
     * Updates the position of the UserProjectile.
     * Moves the projectile horizontally based on its velocity.
     */
    @Override
    public void updatePosition() {
        moveHorizontally(HORIZONTAL_VELOCITY);
    }

    /**
     * Updates the state of the UserProjectile.
     * This includes updating its position.
     */
    @Override
    public void updateActor() {
        updatePosition();
    }
}