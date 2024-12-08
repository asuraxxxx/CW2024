package com.example.demo.ui.images;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * The HeartDisplay class manages a display of heart images within a JavaFX HBox.
 * It allows for initializing a specified number of hearts and removing them as needed.
 */
public class HeartDisplay {
	
    // Path to the heart image file
	private static final String HEART_IMAGE_NAME = "/com/example/demo/images/heart.png";
    
    // Height of each heart image
	private static final int HEART_HEIGHT = 50;
    
    // Index used to remove the first heart from the container
	private static final int INDEX_OF_FIRST_ITEM = 0;
    
    // HBox container to hold the heart images
	private HBox container;
    
    // X and Y positions for the container's layout
	private double containerXPosition;
	private double containerYPosition;
    
    // Number of hearts to display
	private int numberOfHeartsToDisplay;
	
    /**
     * Constructor for creating a HeartDisplay.
     * 
     * @param xPosition The x-coordinate for the container's position.
     * @param yPosition The y-coordinate for the container's position.
     * @param heartsToDisplay The number of heart images to display.
     */
	public HeartDisplay(double xPosition, double yPosition, int heartsToDisplay) {
		this.containerXPosition = xPosition;
		this.containerYPosition = yPosition;
		this.numberOfHeartsToDisplay = heartsToDisplay;
		initializeContainer();
		initializeHearts();
	}
	
    /**
     * Initializes the HBox container and sets its position.
     */
	private void initializeContainer() {
		container = new HBox();
		container.setLayoutX(containerXPosition);
		container.setLayoutY(containerYPosition);		
	}
	
    /**
     * Initializes the heart images and adds them to the container.
     */
	private void initializeHearts() {
		for (int i = 0; i < numberOfHeartsToDisplay; i++) {
			ImageView heart = new ImageView(new Image(getClass().getResource(HEART_IMAGE_NAME).toExternalForm()));
			heart.setFitHeight(HEART_HEIGHT);
			heart.setPreserveRatio(true);
			container.getChildren().add(heart);
		}
	}
	
    /**
     * Removes one heart image from the container, if any are present.
     */
	public void removeHeart() {
		if (!container.getChildren().isEmpty())
			container.getChildren().remove(INDEX_OF_FIRST_ITEM);
	}
	
    /**
     * Returns the HBox container holding the heart images.
     * 
     * @return The HBox container.
     */
	public HBox getContainer() {
		return container;
	}

}