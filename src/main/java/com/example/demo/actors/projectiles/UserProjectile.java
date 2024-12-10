package com.example.demo.actors.projectiles;

import com.example.demo.audio.ProjectileSoundController;

public class UserProjectile extends Projectile {
    private static final String IMAGE_NAME = "userfire.png";
    private static final int IMAGE_HEIGHT = 125;
    private static final int HORIZONTAL_VELOCITY = 15;
    private static final String SHOOTING_SOUND = "/com/example/demo/audios/shooteffect.mp3";

    public UserProjectile(double initialXPos, double initialYPos) {
        super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos);
        ProjectileSoundController.playSound(SHOOTING_SOUND);
    }

    @Override
    public void updatePosition() {
        moveHorizontally(HORIZONTAL_VELOCITY);
    }

    @Override
    public void updateActor() {
        updatePosition();
    }
}