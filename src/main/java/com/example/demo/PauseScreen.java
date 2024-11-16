package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        Stage pauseStage = new Stage();
        pauseStage.initModality(Modality.APPLICATION_MODAL);
        pauseStage.setTitle("Game Pause");

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        // Resume button with image
        Image resumeImage = new Image(getClass().getResource("/com/example/demo/images/resumebutton.jpg").toExternalForm());
        ImageView resumeImageView = new ImageView(resumeImage);
        resumeImageView.setFitWidth(50);
        resumeImageView.setFitHeight(50);

        Button resumeButton = new Button();
        resumeButton.setGraphic(resumeImageView);
        resumeButton.setOnAction(event -> {
            if (resume != null) {
                resume.run();
            }
            pauseStage.close();
        });

        // Settings button with image
        Image settingsImage = new Image(getClass().getResource("/com/example/demo/images/settingbutton.jpg").toExternalForm());
        ImageView settingsImageView = new ImageView(settingsImage);
        settingsImageView.setFitWidth(50);
        settingsImageView.setFitHeight(50);

        Button settingsButton = new Button();
        settingsButton.setGraphic(settingsImageView);
        settingsButton.setOnAction(event -> {
            if (settings != null) {
                settings.run();
            }
        });

        // Return to Main Menu button with image
        Image mainMenuImage = new Image(getClass().getResource("/com/example/demo/images/exitbutton.jpg").toExternalForm());
        ImageView mainMenuImageView = new ImageView(mainMenuImage);
        mainMenuImageView.setFitWidth(50);
        mainMenuImageView.setFitHeight(50);

        Button mainMenuButton = new Button();
        mainMenuButton.setGraphic(mainMenuImageView);
        mainMenuButton.setOnAction(event -> {
            MainMenu mainMenu = new MainMenu(stage);
            stage.setScene(mainMenu.getMainMenuScene());
            pauseStage.close();
        });

        layout.getChildren().addAll(resumeButton, settingsButton, mainMenuButton);

        Scene pauseScene = new Scene(layout, 400, 250);
        pauseStage.setScene(pauseScene);
        // Show the pause box until it is closed
        pauseStage.showAndWait();
    }
}
