package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PauseScreen {

    private final Stage stage;
    private final LevelParent currentLevel;

    public PauseScreen(Stage stage, LevelParent currentLevel) {
        this.stage = stage;
        this.currentLevel = currentLevel;
    }

    public void showPauseMenu() {
        VBox pauseMenu = new VBox(20);
        pauseMenu.setAlignment(Pos.CENTER);
        pauseMenu.setLayoutX(currentLevel.getScreenWidth() / 2 - 100);
        pauseMenu.setLayoutY(currentLevel.getScreenHeight() / 2 - 100);

        Button resumeButton = new Button("Resume Game");
        resumeButton.setPrefWidth(200);
        resumeButton.setPrefHeight(50);
        resumeButton.setOnAction(e -> resumeGame(pauseMenu));

        Button exitButton = new Button("Exit to Main Menu");
        exitButton.setPrefWidth(200);
        exitButton.setPrefHeight(50);
        exitButton.setOnAction(e -> exitToMainMenu());

        pauseMenu.getChildren().addAll(resumeButton, exitButton);
        currentLevel.getRoot().getChildren().add(pauseMenu);
    }

    private void resumeGame(VBox pauseMenu) {
        currentLevel.getRoot().getChildren().remove(pauseMenu);
        currentLevel.resumeTimeline();
    }

    private void exitToMainMenu() {
        MainMenu mainMenu = new MainMenu(stage);
        stage.setScene(mainMenu.getMainMenuScene());
    }
}
