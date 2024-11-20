package com.example.demo;

import javafx.animation.ScaleTransition;
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
        transitionText.setScaleX(0);
        transitionText.setScaleY(0);

        Pane transitionPane = new Pane(transitionText);
        transitionPane.setStyle("-fx-background-color: white;");
        this.transitionScene = new Scene(transitionPane, width, height);

        transitionText.setLayoutX(width / 2 - transitionText.getLayoutBounds().getWidth() / 2);
        transitionText.setLayoutY(height / 2);
    }

    public void showTransition(Runnable onTransitionEnd) {
        // Zoom in the text
        ScaleTransition zoomIn = new ScaleTransition(Duration.seconds(3), transitionText);
        zoomIn.setFromX(0);
        zoomIn.setToX(1);
        zoomIn.setFromY(0);
        zoomIn.setToY(1);
        zoomIn.setOnFinished(e -> onTransitionEnd.run());

        stage.setScene(transitionScene);
        zoomIn.play();
    }

    public Scene getTransitionScene() {
        return this.transitionScene;
    }

    public static void fadeOutCurrentScene(Stage stage, Runnable callback) {
        Scene currentScene = stage.getScene();
        // Zoom out the current scene
        ScaleTransition zoomOut = new ScaleTransition(Duration.seconds(1), currentScene.getRoot());
        zoomOut.setFromX(1);
        zoomOut.setToX(0);
        zoomOut.setFromY(1);
        zoomOut.setToY(0);
        zoomOut.setOnFinished(event -> callback.run());
        zoomOut.play();
    }
}