package com.example.demo.actors;

import com.example.demo.ui.images.ShieldImage;

/**
 * The ShieldActivation class manages the activation and deactivation of a shield for an actor.
 * It includes logic for shield duration, cooldown, and visual representation.
 */
public class ShieldActivation {
    private static final int SHIELD_DURATION_FRAMES = 300; // Duration the shield remains active (in frames)
    private static final int SHIELD_COOLDOWN_FRAMES = 600; // Cooldown period before the shield can be reactivated (in frames)

    private boolean isShielded; // Flag to indicate if the shield is currently active
    private int framesWithShieldActivated; // Counter for the number of frames the shield has been active
    private int framesSinceLastShield; // Counter for the number of frames since the shield was last active
    private final ShieldImage shieldImage; // Visual representation of the shield

    /**
     * Constructor for ShieldActivation.
     * Initializes the shield with the specified image and sets initial states.
     *
     * @param shieldImage The image used to represent the shield.
     */
    public ShieldActivation(ShieldImage shieldImage) {
        this.shieldImage = shieldImage;
        this.framesWithShieldActivated = 0;
        this.framesSinceLastShield = SHIELD_COOLDOWN_FRAMES;
        this.isShielded = false;
    }

    /**
     * Updates the state of the shield.
     * Manages the activation, deactivation, and cooldown of the shield.
     */
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

    /**
     * Checks if the shield duration has been exhausted.
     *
     * @return True if the shield duration has been exhausted, false otherwise.
     */
    private boolean shieldExhausted() {
        return framesWithShieldActivated >= SHIELD_DURATION_FRAMES;
    }

    /**
     * Activates the shield.
     * Resets the activation counter and updates the visual representation.
     */
    public void activateShield() {
        isShielded = true;
        framesWithShieldActivated = 0;
        shieldImage.showShield();
    }

    /**
     * Deactivates the shield.
     * Resets the cooldown counter and updates the visual representation.
     */
    public void deactivateShield() {
        isShielded = false;
        framesSinceLastShield = 0;
        shieldImage.hideShield();
    }

    /**
     * Checks if the shield is currently active.
     *
     * @return True if the shield is active, false otherwise.
     */
    public boolean isShielded() {
        return isShielded;
    }
}