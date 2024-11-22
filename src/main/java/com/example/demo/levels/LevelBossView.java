package com.example.demo.levels;

import com.example.demo.ShieldImage;
import javafx.scene.Group;

public class LevelBossView extends LevelView {

    private static final int SHIELD_X_POSITION = 355;
    private static final int SHIELD_Y_POSITION = 175;
    private final ShieldImage shieldImage;

    public LevelBossView(Group root, int heartsToDisplay) {
        super(root, heartsToDisplay);
        this.shieldImage = new ShieldImage(SHIELD_X_POSITION, SHIELD_Y_POSITION);
        showShieldImage();
    }

    public void showShieldImage() {
        try {
            shieldImage.showShield();
            getRoot().getChildren().add(shieldImage);
            System.out.println("Added Shield: " + shieldImage.isVisible());
        } catch (Exception e) {
            System.err.println("Failed to add shield image: " + e.getMessage());
        }
    }

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