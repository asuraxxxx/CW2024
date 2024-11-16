package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class PauseScreen {

    private final Stage stage;
    private final Runnable resume;
    private final Runnable settings;

    public PauseScreen(Stage stage, Runnable resumeAction, Runnable settingsAction) {
        this.stage = stage;
        this.resume = resumeAction;
        this.settings = settingsAction;
    }

    public void show() {
        // Title Label
        Label titleLabel = new Label("Game Paused");
        titleLabel.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-text-fill: #000000;");
        titleLabel.setAlignment(Pos.CENTER);

        Stage pauseStage = new Stage();
        pauseStage.initModality(Modality.APPLICATION_MODAL);
        pauseStage.setTitle("Game Pause");

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        // Resume button
        Button resumeButton = new Button("Resume");
        resumeButton.setPrefWidth(200);
        resumeButton.setOnAction(event -> {
            if (resume != null) {
                resume.run();
            }
            pauseStage.close();
        });

        // Settings button
        Button settingsButton = new Button("Settings");
        settingsButton.setPrefWidth(200);
        settingsButton.setOnAction(event -> {
            if (settings != null) {
                settings.run();
            }
        });

        // Return to Main Menu button
        Button mainMenuButton = new Button("Return to Main Menu");
        mainMenuButton.setPrefWidth(200);
        mainMenuButton.setOnAction(event -> {
            MainMenu mainMenu = new MainMenu(stage);
            stage.setScene(mainMenu.getMainMenuScene());
            pauseStage.close();
        });

        layout.getChildren().addAll(titleLabel, resumeButton, settingsButton, mainMenuButton);

        Scene pauseScene = new Scene(layout, 400, 250);
        pauseStage.setScene(pauseScene);
        // Show the pause box until it is closed
        pauseStage.showAndWait();
    }
}
