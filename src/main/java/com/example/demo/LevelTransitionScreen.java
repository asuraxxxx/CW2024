package com.example.demo;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LevelTransitionScreen {

    private final Stage stage;
    private final Scene transitionScene;
    private final Text transitionText;

    public LevelTransitionScreen(Stage stage, String message, double width, double height) {
        this.stage = stage;

        transitionText = new Text(message);
        transitionText.setFont(Font.font("Times New Roman", 55));
        transitionText.setFill(Color.BLACK);
        transitionText.setOpacity(0); // Initially invisible

        Pane transitionPane = new Pane(transitionText);
        transitionPane.setStyle("-fx-background-color: white;");
        this.transitionScene = new Scene(transitionPane, width, height);

        transitionText.setLayoutX(width / 2 - transitionText.getLayoutBounds().getWidth() / 2);
        transitionText.setLayoutY(height / 2);
    }

    public void showTransition(Runnable onTransitionEnd) {
        // Fade in the text
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), transitionText);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setOnFinished(e -> onTransitionEnd.run());

        stage.setScene(transitionScene);
        fadeIn.play();
    }

    public Scene getTransitionScene() {
        return this.transitionScene;
    }

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