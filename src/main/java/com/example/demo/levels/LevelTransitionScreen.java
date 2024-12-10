package com.example.demo.levels;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LevelTransitionScreen {

    private final Stage stage;
    private final Scene transitionScene;
    private final Text transitionText;
    private final Pane penguinShape;

    public LevelTransitionScreen(Stage stage, String message, double width, double height) {
        this.stage = stage;

        transitionText = new Text(message);
        transitionText.setFont(Font.font("Impact", 55));
        transitionText.setFill(Color.BLACK);

        // Create penguin shape
        penguinShape = new Pane();

        // Body
        Ellipse body = new Ellipse(50, 75);
        body.setFill(Color.BLACK);
        body.setLayoutX(50);
        body.setLayoutY(75);

        // Belly
        Ellipse belly = new Ellipse(30, 50);
        belly.setFill(Color.WHITE);
        belly.setLayoutX(50);
        belly.setLayoutY(75);

        // Left wing
        Ellipse leftWing = new Ellipse(15, 35);
        leftWing.setFill(Color.BLACK);
        leftWing.setLayoutX(15);
        leftWing.setLayoutY(75);

        // Right wing
        Ellipse rightWing = new Ellipse(15, 35);
        rightWing.setFill(Color.BLACK);
        rightWing.setLayoutX(85);
        rightWing.setLayoutY(75);

        // Head
        Circle head = new Circle(25);
        head.setFill(Color.BLACK);
        head.setLayoutX(50);
        head.setLayoutY(25);

        // Left eye
        Circle leftEye = new Circle(5);
        leftEye.setFill(Color.WHITE);
        leftEye.setLayoutX(40);
        leftEye.setLayoutY(20);

        // Right eye
        Circle rightEye = new Circle(5);
        rightEye.setFill(Color.WHITE);
        rightEye.setLayoutX(60);
        rightEye.setLayoutY(20);

        // Beak
        Polygon beak = new Polygon();
        beak.getPoints().addAll(
            50.0, 30.0,
            45.0, 40.0,
            55.0, 40.0
        );
        beak.setFill(Color.ORANGE);

        // Feet
        Rectangle leftFoot = new Rectangle(10, 10);
        leftFoot.setFill(Color.ORANGE);
        leftFoot.setLayoutX(35);
        leftFoot.setLayoutY(125);

        Rectangle rightFoot = new Rectangle(10, 10);
        rightFoot.setFill(Color.ORANGE);
        rightFoot.setLayoutX(55);
        rightFoot.setLayoutY(125);

        penguinShape.getChildren().addAll(body, belly, leftWing, rightWing, head, leftEye, rightEye, beak, leftFoot, rightFoot);

        Pane transitionPane = new Pane(transitionText, penguinShape);
        transitionPane.setStyle("-fx-background-color: white;");
        this.transitionScene = new Scene(transitionPane, width, height);

        transitionText.setLayoutX(width / 2 - transitionText.getLayoutBounds().getWidth() / 2);
        transitionText.setLayoutY(height / 2); 
        penguinShape.setLayoutY(height - 150); 
        penguinShape.setLayoutX(-100);
    }

    public void showTransition(Runnable onTransitionEnd) {
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), transitionText);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(4);
        fadeIn.setAutoReverse(true);

        TranslateTransition penguinAnimation = new TranslateTransition(Duration.seconds(3), penguinShape);
        penguinAnimation.setFromX(-100);
        penguinAnimation.setToX(transitionScene.getWidth() + 100);
        penguinAnimation.setCycleCount(1);
        penguinAnimation.setAutoReverse(false);

        stage.setScene(transitionScene);

        fadeIn.play();
        penguinAnimation.play();
        penguinAnimation.setOnFinished(event -> onTransitionEnd.run());
    }

    public Scene getTransitionScene() {
        return this.transitionScene;
    }

    public static void fadeOutCurrentScene(Stage stage, Runnable callback) {
        Scene currentScene = stage.getScene();
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), currentScene.getRoot());
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setOnFinished(event -> callback.run());
        fadeOut.play();
    }
}