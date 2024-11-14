package com.example.demo;

import com.example.demo.controller.GameController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu {
    private Stage primaryStage;
    private GameController gameController;

    public MainMenu(Stage stage) {
        this.primaryStage = stage;
    }

    public Scene getMainMenuScene() {
        VBox menuLayout = new VBox(30);
        menuLayout.setAlignment(Pos.CENTER);

        Text title = new Text("Sky Battle");
        title.setFont(Font.font("Arial", 60));
        title.setStyle("-fx-fill: white;");

        Button startButton = new Button("Start Game");
        startButton.setPrefWidth(200);
        startButton.setPrefHeight(50);
        startButton.setFont(Font.font("Arial", 20));
        startButton.setOnAction(e -> startGame());

        Button exitButton = new Button("Exit");
        exitButton.setPrefWidth(200);
        exitButton.setPrefHeight(50);
        exitButton.setFont(Font.font("Arial", 20));
        exitButton.setOnAction(e -> exitGame());

        menuLayout.getChildren().addAll(title, startButton, exitButton);

        Image backgroundImage = new Image(getClass().getResource("/com/example/demo/images/background3.png").toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1300);
        backgroundImageView.setFitHeight(750);
        backgroundImageView.setPreserveRatio(false);

        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundImageView, menuLayout);

        Scene scene = new Scene(root, 1300, 750);
        return scene;
    }

    private void startGame() {
        gameController = new GameController(primaryStage);
        try {
            gameController.launchGame();
        } catch (Exception ex) {
            System.err.println("Error launching game.");
            ex.printStackTrace();
        }
    }

    private void exitGame() {
        primaryStage.close();
    }
}