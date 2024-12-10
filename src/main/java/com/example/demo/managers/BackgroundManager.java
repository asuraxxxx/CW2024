package com.example.demo.managers;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The BackgroundManager class manages the background image for the game.
 */
public class BackgroundManager {

    private final ImageView background;
    private final double screenHeight;
    private final double screenWidth;

    /**
     * Constructs a new BackgroundManager.
     *
     * @param backgroundImageName the name of the background image file
     * @param screenHeight the height of the screen
     * @param screenWidth the width of the screen
     */
    public BackgroundManager(String backgroundImageName, double screenHeight, double screenWidth) {
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.background = new ImageView(new Image(getClass().getResource(backgroundImageName).toExternalForm()));
        initializeBackground();
    }

    /**
     * Initializes the background image size to fit the screen dimensions.
     */
    private void initializeBackground() {
        background.setFitHeight(screenHeight);
        background.setFitWidth(screenWidth);
    }

    /**
     * Adds the background image to the root group managed by BackgroundManager.
     *
     * @param root the root group of the scene
     */
    public void addToRoot(Group root) {
        root.getChildren().add(background);
    }

    /**
     * Updates the background image. Implement any background update logic here, if needed.
     */
    public void updateBackground() {
        // Implement any background update logic here, if needed
    }

    /**
     * Gets the background image.
     *
     * @return the background image
     */
    public ImageView getBackground() {
        return background;
    }
}