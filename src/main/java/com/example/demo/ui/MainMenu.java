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

/**
 * The MainMenu class creates the main menu interface for the game,
 * including buttons to start the game, view instructions, and exit.
 */
public class MainMenu {
    // Primary stage for the application
    private Stage primaryStage;
    
    // Controller for managing game logic
    private GameController gameController;
    
    // Path to the main menu background music file
    private static final String MENU_MUSIC = "/com/example/demo/audios/MainMenuMusic.mp3";

    /**
     * Constructor for MainMenu.
     * 
     * @param stage The primary stage of the application.
     */
    public MainMenu(Stage stage) {
        this.primaryStage = stage;
        // Start playing the background music for the main menu
        MusicController.getInstance().playMusic(MENU_MUSIC);
    }

    /**
     * Creates and returns the main menu scene.
     * 
     * @return The main menu scene.
     */
    public Scene getMainMenuScene() {
        // Create a vertical box layout for the menu items
        VBox menuLayout = new VBox(30);
        menuLayout.setAlignment(Pos.CENTER);

        // Create and style the title text
        Text title = new Text("Sky Invaders");
        title.setFont(Font.font("Impact", 60));
        title.setStyle("-fx-fill: black;");

        // Create and style the start game button
        Button startButton = new Button("Start Game");
        startButton.setPrefWidth(200);
        startButton.setPrefHeight(50);
        startButton.setFont(Font.font("Impact", 20));
        startButton.setOnAction(e -> startGame());

        // Create and style the instructions button
        Button instructionsButton = new Button("Instructions");
        instructionsButton.setPrefWidth(200);
        instructionsButton.setPrefHeight(50);
        instructionsButton.setFont(Font.font("Impact", 20));
        instructionsButton.setOnAction(e -> showInstructions());

        // Create and style the leaderboard button
        Button leaderboardButton = new Button("Leaderboard");
        leaderboardButton.setPrefWidth(200);
        leaderboardButton.setPrefHeight(50);
        leaderboardButton.setFont(Font.font("Impact", 20));
        leaderboardButton.setOnAction(e -> showLeaderboard());

        // Create and style the exit button
        Button exitButton = new Button("Exit");
        exitButton.setPrefWidth(200);
        exitButton.setPrefHeight(50);
        exitButton.setFont(Font.font("Impact", 20));
        exitButton.setOnAction(e -> exitGame());

        // Add all buttons to the menu layout
        menuLayout.getChildren().addAll(title, startButton, instructionsButton, leaderboardButton, exitButton);

        // Load and set the background image
        Image backgroundImage = new Image(getClass().getResource("/com/example/demo/images/background1.jpg").toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1300);
        backgroundImageView.setFitHeight(750);
        backgroundImageView.setPreserveRatio(false);

        // Create a stack pane to hold the background image and menu layout
        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundImageView, menuLayout);

        // Create and return the scene
        Scene scene = new Scene(root, 1300, 750);
        return scene;
    }

    /**
     * Starts the game by stopping the menu music and launching the game controller.
     */
    private void startGame() {
        // Stop the main menu music
        MusicController.getInstance().stopMusic();
        
        // Initialize and launch the game controller
        gameController = new GameController(primaryStage);
        try {
            gameController.launchGame();
        } catch (Exception ex) {
            System.err.println("Error launching game.");
            ex.printStackTrace();
        }
    }

    /**
     * Displays the instructions screen.
     */
    private void showInstructions() {
        PauseScreen pauseScreen = new PauseScreen(primaryStage, null, null);
        pauseScreen.showInstructions();
    }

    /**
     * Displays the leaderboard screen.
     */
    private void showLeaderboard() {
        LeaderboardScreen leaderboardScreen = new LeaderboardScreen(primaryStage);
        leaderboardScreen.show();
    }

    /**
     * Exits the game by closing the primary stage.
     */
    private void exitGame() {
        primaryStage.close();
    }
}