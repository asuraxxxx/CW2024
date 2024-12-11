package com.example.demo.managers;

import com.example.demo.levels.LevelParent;
import com.example.demo.ui.PauseScreen;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The PauseManager class manages the pause functionality in the game.
 */
public class PauseManager {
    private final LevelParent levelParent;
    private final Group root;
    private boolean isPaused = false;

    /**
     * Constructs a new PauseManager.
     *
     * @param levelParent the parent level
     * @param root the root group of the scene
     */
    public PauseManager(LevelParent levelParent, Group root) {
        this.levelParent = levelParent;
        this.root = root;
    }

    /**
     * Pauses the game managed by PauseManager.
     */
    public void pauseGame() {
        if (!isPaused) {
            levelParent.getTimelineManager().pause();
            isPaused = true;
            showPauseScreen();
            levelParent.getTimerManager().stopTimer(); // Stop the timer when the game is paused
        }
    }

    /**
     * Resumes the game managed by PauseManager.
     */
    public void resumeGame() {
        if (isPaused) {
            levelParent.getTimelineManager().resume();
            isPaused = false;
            levelParent.getBackgroundManager().getBackground().requestFocus();
            levelParent.getTimerManager().startTimer(); // Restart the timer when the game resumes
        }
    }

    /**
     * Checks if the game is paused.
     *
     * @return true if the game is paused, false otherwise
     */
    public boolean isPaused() {
        return isPaused;
    }

    /**
     * Displays the pause screen.
     */
    private void showPauseScreen() {
        PauseScreen pauseScreen = new PauseScreen((Stage) levelParent.getScene().getWindow(), this::resumeGame, this::showSettings);
        pauseScreen.show();
    }

    /**
     * Displays the settings screen.
     */
    private void showSettings() {
        // Implement settings logic here
    }

    /**
     * Removes the pause menu from the root group.
     *
     * @param pauseMenu the pause menu to remove
     */
    public void removePauseMenu(VBox pauseMenu) {
        root.getChildren().remove(pauseMenu);
    }

    /**
     * Adds the pause menu to the root group.
     *
     * @param pauseMenu the pause menu to add
     */
    public void addPauseMenu(VBox pauseMenu) {
        root.getChildren().add(pauseMenu);
    }

    /**
     * Adds a pause button to the screen.
     *
     * @param screenWidth the width of the screen
     */
    public void addPauseButton(double screenWidth) {
        Image pauseImage = new Image(getClass().getResource("/com/example/demo/images/pausescreenbutton.png").toExternalForm());
        ImageView pauseImageView = new ImageView(pauseImage);
        pauseImageView.setFitWidth(50);
        pauseImageView.setFitHeight(50);

        Button pauseButton = new Button();
        pauseButton.setGraphic(pauseImageView);
        pauseButton.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        pauseButton.setLayoutX(screenWidth - 100);
        pauseButton.setLayoutY(20);
        pauseButton.setOnAction(e -> pauseGame());
        root.getChildren().add(pauseButton);
    }
}