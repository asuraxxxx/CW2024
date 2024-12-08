package com.example.demo.ui.images;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The ShieldImage class extends ImageView to display a shield image
 * at a specified position and size within a JavaFX application.
 */
public class ShieldImage extends ImageView {
    
    // Path to the shield image file
    private static final String IMAGE_NAME = "/com/example/demo/images/shield.png";
    
    // Public constant for the shield image size
    public static final int SHIELD_SIZE = 200;

    /**
     * Constructor for creating a ShieldImage.
     * 
     * @param xPosition The x-coordinate for the image's position.
     * @param yPosition The y-coordinate for the image's position.
     */
    public ShieldImage(double xPosition, double yPosition) {
        // Set the x and y coordinates for the image's layout position
        this.setLayoutX(xPosition);
        this.setLayoutY(yPosition);
        
        // Load the shield image
        Image image = new Image(getClass().getResource(IMAGE_NAME).toExternalForm());
        
        // Check if the image loaded successfully
        if (image.isError()) {
            System.out.println("Error loading shield image");
        } else {
            this.setImage(image);
        }
        
        // Initially set the image to be invisible
        this.setVisible(false);
        
        // Set the dimensions of the image
        this.setFitHeight(SHIELD_SIZE);
        this.setFitWidth(SHIELD_SIZE);
    }

    /**
     * Makes the shield image visible.
     */
    public void showShield() {
        this.setVisible(true);
    }
    
    /**
     * Hides the shield image.
     */
    public void hideShield() {
        this.setVisible(false);
    }
}