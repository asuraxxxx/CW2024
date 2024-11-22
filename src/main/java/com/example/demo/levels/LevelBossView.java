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
        shieldImage.showShield();
        getRoot().getChildren().add(shieldImage);
        System.out.println("Added Shield: " + shieldImage.isVisible());
    }

    public void hideShieldImage() {
        shieldImage.hideShield();
        getRoot().getChildren().remove(shieldImage);
        System.out.println("Removed Shield");
    }
}