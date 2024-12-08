package com.example.demo.levels;

import com.example.demo.ui.images.ShieldImage;
import javafx.scene.Group;

/**
 * The LevelBossView class represents the visual components of the boss level,
 * including the display and management of the shield image.
 */
public class LevelBossView extends LevelView {

    // Initial positions for the shield image
    private static final int SHIELD_X_POSITION = 355;
    private static final int SHIELD_Y_POSITION = 175;
    
    // Shield image instance
    private final ShieldImage shieldImage;

    /**
     * Constructor for LevelBossView.
     * 
     * @param root The root group of the scene.
     * @param heartsToDisplay The number of hearts to display for the player's health.
     */
    public LevelBossView(Group root, int heartsToDisplay) {
        super(root, heartsToDisplay);
        this.shieldImage = new ShieldImage(SHIELD_X_POSITION, SHIELD_Y_POSITION);
        showShieldImage();
    }

    /**
     * Shows the shield image by adding it to the root group and making it visible.
     */
    public void showShieldImage() {
        try {
            shieldImage.showShield();
            getRoot().getChildren().add(shieldImage);
            System.out.println("Added Shield: " + shieldImage.isVisible());
        } catch (Exception e) {
            System.err.println("Failed to add shield image: " + e.getMessage());
        }
    }

    /**
     * Hides the shield image by removing it from the root group and making it invisible.
     */
    public void hideShieldImage() {
        try {
            shieldImage.hideShield();
            getRoot().getChildren().remove(shieldImage);
            System.out.println("Removed Shield");
        } catch (Exception e) {
            System.err.println("Failed to remove shield image: " + e.getMessage());
        }
    }
}