package com.example.demo.levels;

import com.example.demo.ui.images.GameOverImage;
import com.example.demo.ui.images.HeartDisplay;

import javafx.scene.Group;

public class LevelView {

    private static final double HEART_DISPLAY_X_POSITION = 5;
    private static final double HEART_DISPLAY_Y_POSITION = 25;
    private static final double GAME_OVER_IMAGE_WIDTH = 500;
    private static final double GAME_OVER_IMAGE_HEIGHT = 500;
    private final Group root;
    private final GameOverImage gameOverImage;
    private final HeartDisplay heartDisplay;

    public LevelView(Group root, int heartsToDisplay) {
        this.root = root;
        this.heartDisplay = new HeartDisplay(HEART_DISPLAY_X_POSITION, HEART_DISPLAY_Y_POSITION, heartsToDisplay);
        double windowWidth = root.getScene().getWidth();
        double windowHeight = root.getScene().getHeight();
        int lossScreenXPosition = (int) (windowWidth / 2 - GAME_OVER_IMAGE_WIDTH / 2);
        int lossScreenYPosition = (int) (windowHeight / 2 - GAME_OVER_IMAGE_HEIGHT / 2 - 40);
        this.gameOverImage = new GameOverImage(
            lossScreenXPosition, 
            lossScreenYPosition,
            GAME_OVER_IMAGE_WIDTH,
            GAME_OVER_IMAGE_HEIGHT
        );
    }

    public Group getRoot() {
        return root;
    }

    public void showHeartDisplay() {
        root.getChildren().add(heartDisplay.getContainer());
    }

    public void showWinImage() {
        // Removed: root.getChildren().add(winImage);
        // Removed: winImage.showWinImage();
    }

    public void showGameOverImage() {
        root.getChildren().add(gameOverImage);
    }

    public void removeHearts(int heartsRemaining) {
        int currentNumberOfHearts = heartDisplay.getContainer().getChildren().size();
        for (int i = 0; i < currentNumberOfHearts - heartsRemaining; i++) {
            heartDisplay.removeHeart();
        }
    }
}