package com.example.demo.managers;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BackgroundManager {

    private final ImageView background;
    private final double screenHeight;
    private final double screenWidth;

    public BackgroundManager(String backgroundImageName, double screenHeight, double screenWidth) {
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.background = new ImageView(new Image(getClass().getResource(backgroundImageName).toExternalForm()));
        initializeBackground();
    }

    private void initializeBackground() {
        background.setFitHeight(screenHeight);
        background.setFitWidth(screenWidth);
    }

    public void addToRoot(Group root) {
        root.getChildren().add(background);
    }

    public void updateBackground() {
        // Implement any background update logic here, if needed
    }

    public ImageView getBackground() {
        return background;
    }
}