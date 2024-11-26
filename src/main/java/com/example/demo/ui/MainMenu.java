package com.example.demo.ui;

import com.example.demo.audio.MusicController;
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
    private static final String MENU_MUSIC = "/com/example/demo/audios/MainMenuMusic.mp3";

    public MainMenu(Stage stage) {
        this.primaryStage = stage;
        MusicController.getInstance().playMusic(MENU_MUSIC); // Start background music
    }

    public Scene getMainMenuScene() {
        VBox menuLayout = new VBox(30);
        menuLayout.setAlignment(Pos.CENTER);

        Text title = new Text("Sky Invaders");
        title.setFont(Font.font("Impact", 60));
        title.setStyle("-fx-fill: black;");

        Button startButton = new Button("Start Game");
        startButton.setPrefWidth(200);
        startButton.setPrefHeight(50);
        startButton.setFont(Font.font("Impact", 20));
        startButton.setOnAction(e -> startGame());

        Button instructionsButton = new Button("Instructions");
        instructionsButton.setPrefWidth(200);
        instructionsButton.setPrefHeight(50);
        instructionsButton.setFont(Font.font("Impact", 20));
        instructionsButton.setOnAction(e -> showInstructions());

        Button exitButton = new Button("Exit");
        exitButton.setPrefWidth(200);
        exitButton.setPrefHeight(50);
        exitButton.setFont(Font.font("Impact", 20));
        exitButton.setOnAction(e -> exitGame());

        menuLayout.getChildren().addAll(title, startButton, instructionsButton, exitButton);

        Image backgroundImage = new Image(getClass().getResource("/com/example/demo/images/background1.jpg").toExternalForm());
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
        MusicController.getInstance().stopMusic(); // Stop main menu music
        gameController = new GameController(primaryStage);
        try {
            gameController.launchGame();
        } catch (Exception ex) {
            System.err.println("Error launching game.");
            ex.printStackTrace();
        }
    }

    private void showInstructions() {
        PauseScreen pauseScreen = new PauseScreen(primaryStage, null, null);
        pauseScreen.showInstructions();
    }

    private void exitGame() {
        primaryStage.close();
    }
}