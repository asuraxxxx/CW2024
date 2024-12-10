package com.example.demo.levels;

import com.example.demo.ui.images.GameOverImage;
import com.example.demo.ui.images.HeartDisplay;
import javafx.scene.Group;

/**
 * The LevelView class represents the visual components of a game level,
 * including the display of hearts for player health and a game over image.
 */
public class LevelView {

    // Positions for the heart display
    private static final double HEART_DISPLAY_X_POSITION = 5;
    private static final double HEART_DISPLAY_Y_POSITION = 25;
    
    // Dimensions for the game over image
    private static final double GAME_OVER_IMAGE_WIDTH = 500;
    private static final double GAME_OVER_IMAGE_HEIGHT = 500;
    
    // Root group of the scene
    private final Group root;
    
    // Game over image and heart display instances
    private final GameOverImage gameOverImage;
    private final HeartDisplay heartDisplay;

    /**
     * Constructor for LevelView.
     *
     * @param root The root group of the scene.
     * @param heartsToDisplay The number of hearts to display for the player's health.
     */
    public LevelView(Group root, int heartsToDisplay) {
        this.root = root;
        this.heartDisplay = new HeartDisplay(HEART_DISPLAY_X_POSITION, HEART_DISPLAY_Y_POSITION, heartsToDisplay);
        
        // Calculate the position for the game over image
        double windowWidth = root.getScene().getWidth();
        double windowHeight = root.getScene().getHeight();
        int lossScreenXPosition = (int) (windowWidth / 2 - GAME_OVER_IMAGE_WIDTH / 2);
        int lossScreenYPosition = (int) (windowHeight / 2 - GAME_OVER_IMAGE_HEIGHT / 2 - 40);
        
        // Initialize the game over image
        this.gameOverImage = new GameOverImage(
            lossScreenXPosition, 
            lossScreenYPosition,
            GAME_OVER_IMAGE_WIDTH,
            GAME_OVER_IMAGE_HEIGHT
        );
    }

    /**
     * Returns the root group of the scene.
     *
     * @return The root group.
     */
    public Group getRoot() {
        return root;
    }

    /**
     * Displays the heart display on the screen.
     */
    public void showHeartDisplay() {
        root.getChildren().add(heartDisplay.getContainer());
    }

    /**
     * Displays the game over image on the screen.
     */
    public void showGameOverImage() {
        root.getChildren().add(gameOverImage);
    }

    /**
     * Removes hearts from the heart display to reflect the player's remaining health.
     *
     * @param heartsRemaining The number of hearts remaining.
     */
    public void removeHearts(int heartsRemaining) {
        int currentNumberOfHearts = heartDisplay.getContainer().getChildren().size();
        for (int i = 0; i < currentNumberOfHearts - heartsRemaining; i++) {
            heartDisplay.removeHeart();
        }
    }   
}