package com.example.demo.actors;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The ActiveActor class is an abstract class that represents an active actor in the game.
 * It extends the ImageView class and includes methods for setting up the actor's image and position,
 * as well as methods for moving the actor.
 */
public abstract class ActiveActor extends ImageView {
    private static final String IMAGE_LOCATION = "/com/example/demo/images/"; // Base location for image files

    /**
     * Constructor for ActiveActor.
     * Initializes the actor with a specific image, size, and initial position.
     *
     * @param imageName The image file name for the actor.
     * @param imageHeight The height of the actor image.
     * @param initialXPos The initial X position of the actor.
     * @param initialYPos The initial Y position of the actor.
     */
    public ActiveActor(String imageName, int imageHeight, double initialXPos, double initialYPos) {
        this.setImage(new Image(getClass().getResource(IMAGE_LOCATION + imageName).toExternalForm()));
        this.setLayoutX(initialXPos);
        this.setLayoutY(initialYPos);
        this.setFitHeight(imageHeight);
        this.setPreserveRatio(true);
    }

    /**
     * Abstract method to update the position of the actor.
     * Must be implemented by subclasses.
     */
    public abstract void updatePosition();

    /**
     * Moves the actor horizontally by a specified amount.
     *
     * @param horizontalMove The amount to move the actor horizontally.
     */
    public void moveHorizontally(double horizontalMove) {
        this.setTranslateX(getTranslateX() + horizontalMove);
    }

    /**
     * Moves the actor vertically by a specified amount.
     *
     * @param verticalMove The amount to move the actor vertically.
     */
    public void moveVertically(double verticalMove) {
        this.setTranslateY(getTranslateY() + verticalMove);
    }
}