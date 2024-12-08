package com.example.demo.ui.images;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The GameOverImage class is a custom ImageView that displays a "Game Over" image.
 */
public class GameOverImage extends ImageView {
    
    // Path to the "Game Over" image file
    private static final String IMAGE_NAME = "/com/example/demo/images/gameover.png";

    /**
     * Constructor for creating a GameOverImage.
     * 
     * @param xPosition The x-coordinate for the image's position.
     * @param yPosition The y-coordinate for the image's position.
     * @param width The width of the image.
     * @param height The height of the image.
     */
    public GameOverImage(double xPosition, double yPosition, double width, double height) {
        // Load and set the "Game Over" image
        setImage(new Image(getClass().getResource(IMAGE_NAME).toExternalForm()));
        
        // Set the dimensions of the image
        setFitWidth(width);
        setFitHeight(height);
        
        // Position the image at the specified coordinates
        setLayoutX(xPosition);
        setLayoutY(yPosition);
    }
}