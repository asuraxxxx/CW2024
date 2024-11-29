package com.example.demo.actors;

import com.example.demo.ui.images.ShieldImage;

public class ShieldActivation {
    private static final int SHIELD_DURATION_FRAMES = 300;
    private static final int SHIELD_COOLDOWN_FRAMES = 600;

    private boolean isShielded;
    private int framesWithShieldActivated;
    private int framesSinceLastShield;
    private final ShieldImage shieldImage;

    public ShieldActivation(ShieldImage shieldImage) {
        this.shieldImage = shieldImage;
        this.framesWithShieldActivated = 0;
        this.framesSinceLastShield = SHIELD_COOLDOWN_FRAMES;
        this.isShielded = false;
    }

    public void updateShield() {
        if (isShielded) {
            framesWithShieldActivated++;
            if (shieldExhausted()) {
                deactivateShield();
            }
        } else {
            framesSinceLastShield++;
            if (framesSinceLastShield >= SHIELD_COOLDOWN_FRAMES) {
                activateShield();
            }
        }
    }

    private boolean shieldExhausted() {
        return framesWithShieldActivated >= SHIELD_DURATION_FRAMES;
    }

    public void activateShield() {
        isShielded = true;
        framesWithShieldActivated = 0;
        shieldImage.showShield();
    }

    public void deactivateShield() {
        isShielded = false;
        framesSinceLastShield = 0;
        shieldImage.hideShield();
    }

    public boolean isShielded() {
        return isShielded;
    }
}