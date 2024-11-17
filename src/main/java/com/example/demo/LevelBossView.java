package com.example.demo;

import javafx.scene.Group;

public class LevelBossView extends LevelTwoView {

    private static final int SHIELD_X_POSITION = 355;
    private static final int SHIELD_Y_POSITION = 175;
    private final Group root;
    private final ShieldImage shieldImage;

    public LevelBossView(Group root, int heartsToDisplay) {
        super(root, heartsToDisplay);
        this.root = root;
        this.shieldImage = new ShieldImage(SHIELD_X_POSITION, SHIELD_Y_POSITION);
        showShieldImage();
    }

    public void showShieldImage() {
        shieldImage.showShield();
        root.getChildren().add(shieldImage);
        System.out.println("Added Shield");
    }
}