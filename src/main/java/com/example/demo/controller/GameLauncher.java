package com.example.demo.controller;

import javafx.application.Application;
import javafx.stage.Stage;

import com.example.demo.audio.MusicController;
import com.example.demo.factories.LevelFactory;
import com.example.demo.levels.LevelParent;
import com.example.demo.ui.MainMenu;

/**
 * The GameLauncher class is the entry point for the game application.
 * It extends the Application class and sets up the main menu and initial stage properties.
 */
public class GameLauncher extends Application {

    private static final int SCREEN_WIDTH = 1300; // Width of the game window
    private static final int SCREEN_HEIGHT = 750; // Height of the game window
    private static final String TITLE = "Sky Battle"; // Title of the game window

    private LevelParent currentLevel;

    /**
     * The start method is called when the application is launched.
     * It sets up the stage properties and initializes the main menu.
     * @param stage The primary stage for the application.
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle(TITLE);
        stage.setResizable(false);
        stage.setHeight(SCREEN_HEIGHT);
        stage.setWidth(SCREEN_WIDTH);

        // Initialize and display the main menu
        MainMenu mainMenu = new MainMenu(stage);
        stage.setScene(mainMenu.getMainMenuScene());
        stage.show();
    }

    /**
     * Starts a level using the LevelFactory.
     * @param levelName The name of the level to start.
     * @param screenHeight The height of the game window.
     * @param screenWidth The width of the game window.
     * @param stage The primary stage for the application.
     */
    public void startLevel(String levelName, double screenHeight, double screenWidth, Stage stage) {
        currentLevel = LevelFactory.createLevel(levelName, screenHeight, screenWidth);
        stage.setScene(currentLevel.initializeScene());
        stage.show();
        currentLevel.startGame();
    }

    /**
     * The main method is the entry point of the application.
     * It initializes the MusicController and launches the application.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        // Initialize the MusicController
        MusicController.getInstance();
        launch();
    }
}