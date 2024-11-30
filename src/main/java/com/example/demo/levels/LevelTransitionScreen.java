package com.example.demo.levels;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * The LevelTransitionScreen class creates a transition screen between levels,
 * displaying a message with a fade-in effect.
 */
public class LevelTransitionScreen {

    // The primary stage of the application
    private final Stage stage;
    
    // Scene and text for the transition screen
    private final Scene transitionScene;
    private final Text transitionText;

    /**
     * Constructor for LevelTransitionScreen.
     * 
     * @param stage The primary stage of the application.
     * @param message The message to display during the transition.
     * @param width The width of the transition screen.
     * @param height The height of the transition screen.
     */
    public LevelTransitionScreen(Stage stage, String message, double width, double height) {
        this.stage = stage;

        // Initialize the transition text with the provided message
        transitionText = new Text(message);
        transitionText.setFont(Font.font("Times New Roman", 55));
        transitionText.setFill(Color.BLACK);
        transitionText.setOpacity(0); // Initially invisible

        // Create a pane to hold the transition text
        Pane transitionPane = new Pane(transitionText);
        transitionPane.setStyle("-fx-background-color: white;");
        this.transitionScene = new Scene(transitionPane, width, height);

        // Center the transition text within the pane
        transitionText.setLayoutX(width / 2 - transitionText.getLayoutBounds().getWidth() / 2);
        transitionText.setLayoutY(height / 2);
    }

    /**
     * Shows the transition screen with a fade-in effect.
     * 
     * @param onTransitionEnd The action to perform when the transition ends.
     */
    public void showTransition(Runnable onTransitionEnd) {
        // Fade in the text
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), transitionText);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setOnFinished(e -> onTransitionEnd.run());

        stage.setScene(transitionScene);
        fadeIn.play();
    }

    /**
     * Returns the transition scene.
     * 
     * @return The transition scene.
     */
    public Scene getTransitionScene() {
        return this.transitionScene;
    }

    /**
     * Fades out the current scene and executes a callback when the fade-out is complete.
     * 
     * @param stage The primary stage of the application.
     * @param callback The action to perform after the fade-out.
     */
    public static void fadeOutCurrentScene(Stage stage, Runnable callback) {
        Scene currentScene = stage.getScene();
        // Fade out the current scene
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), currentScene.getRoot());
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setOnFinished(event -> callback.run());
        fadeOut.play();
    }
}