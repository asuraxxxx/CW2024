package com.example.demo.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.text.Font;

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
        pauseStage.initStyle(StageStyle.TRANSPARENT);

        BorderPane rootLayout = new BorderPane();
        BackgroundImage backgroundImage = new BackgroundImage(
            new Image(this.getClass().getResource("/com/example/demo/images/pausescreen.png").toExternalForm()),
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            new BackgroundSize(1.0, 1.0, true, true, false, false)
        );
        rootLayout.setBackground(new Background(backgroundImage));

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        Font titleFont = null;
        try {
            titleFont = Font.loadFont(this.getClass().getResource("/com/example/demo/fonts/impact.ttf").toExternalForm(), 40);
        } catch (Exception e) {
            System.err.println("Error loading font: " + e.getMessage());
        }

        Label titleLabel = new Label("Game Paused!");
        if (titleFont != null) {
            titleLabel.setFont(titleFont);
        }
        titleLabel.setStyle("-fx-text-fill: white;");

        Image resumeImage = new Image(getClass().getResource("/com/example/demo/images/resumebutton.jpg").toExternalForm());
        ImageView resumeImageView = new ImageView(resumeImage);
        resumeImageView.setFitWidth(30);
        resumeImageView.setFitHeight(30);

        Button resumeButton = new Button();
        resumeButton.setGraphic(resumeImageView);
        resumeButton.setOnAction(event -> {
            if (resume != null) {
                resume.run();
            }
            pauseStage.close();
        });

        Image settingsImage = new Image(getClass().getResource("/com/example/demo/images/settingbutton.jpg").toExternalForm());
        ImageView settingsImageView = new ImageView(settingsImage);
        settingsImageView.setFitWidth(30);
        settingsImageView.setFitHeight(30);

        Button settingsButton = new Button();
        settingsButton.setGraphic(settingsImageView);
        settingsButton.setOnAction(event -> {
            if (settings != null) {
                settings.run();
                showSettings();
            }
        });

        Image mainMenuImage = new Image(getClass().getResource("/com/example/demo/images/exitbutton.jpg").toExternalForm());
        ImageView mainMenuImageView = new ImageView(mainMenuImage);
        mainMenuImageView.setFitWidth(30);
        mainMenuImageView.setFitHeight(30);

        Button mainMenuButton = new Button();
        mainMenuButton.setGraphic(mainMenuImageView);
        mainMenuButton.setOnAction(event -> {
            MainMenu mainMenu = new MainMenu(stage);
            stage.setScene(mainMenu.getMainMenuScene());
            pauseStage.close();
        });

        layout.getChildren().addAll(titleLabel, resumeButton, settingsButton, mainMenuButton);
        rootLayout.setCenter(layout);

        Scene pauseScene = new Scene(rootLayout, 500, 350);
        pauseScene.setFill(null);
        pauseStage.setScene(pauseScene);
        pauseStage.showAndWait();
    }
    public void showSettings() {
        Stage settingsStage = new Stage();
        settingsStage.initModality(Modality.APPLICATION_MODAL);
        settingsStage.initStyle(StageStyle.TRANSPARENT);

        BorderPane rootLayout = new BorderPane();
        BackgroundImage backgroundImage = new BackgroundImage(
            new Image(this.getClass().getResource("/com/example/demo/images/pausescreen.png").toExternalForm()),
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            new BackgroundSize(1.0, 1.0, true, true, false, false)
        );
        rootLayout.setBackground(new Background(backgroundImage));

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.TOP_CENTER);

        Font buttonFont = null;
        try {
            buttonFont = Font.loadFont(this.getClass().getResource("/com/example/demo/fonts/impact.ttf").toExternalForm(), 20);
        } catch (Exception e) {
            System.err.println("Error loading font: " + e.getMessage());
        }

        Label settingsLabel = new Label("Settings");
        if (buttonFont != null) {
            settingsLabel.setFont(buttonFont);
        }
        settingsLabel.setStyle("-fx-text-fill: white;");
        layout.getChildren().add(settingsLabel);

        Button instructionButton = new Button("Instructions");
        if (buttonFont != null) {
            instructionButton.setFont(buttonFont);
        }
        instructionButton.setOnAction(event -> showInstructions());
        layout.getChildren().add(instructionButton);

        Button closeButton = new Button("Close");
        if (buttonFont != null) {
            closeButton.setFont(buttonFont);
        }
        closeButton.setOnAction(event -> settingsStage.close());
        layout.getChildren().add(closeButton);

        rootLayout.setCenter(layout);

        Scene settingsScene = new Scene(rootLayout, 400, 300);
        settingsScene.setFill(null);
        settingsStage.setScene(settingsScene);
        settingsStage.showAndWait();
    }

    public void showInstructions() {
        Stage instructionsStage = new Stage();
        instructionsStage.initModality(Modality.APPLICATION_MODAL);
        instructionsStage.initStyle(StageStyle.TRANSPARENT);

        BorderPane rootLayout = new BorderPane();
        BackgroundImage backgroundImage = new BackgroundImage(
            new Image(this.getClass().getResource("/com/example/demo/images/pausescreen.png").toExternalForm()),
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            new BackgroundSize(1.0, 1.0, true, true, false, false)
        );
        rootLayout.setBackground(new Background(backgroundImage));

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.TOP_CENTER);

        Font buttonFont = null;
        try {
            buttonFont = Font.loadFont(this.getClass().getResource("/com/example/demo/fonts/impact.ttf").toExternalForm(), 20);
        } catch (Exception e) {
            System.err.println("Error loading font: " + e.getMessage());
        }

        Label instructionsLabel = new Label("How to Play");
        if (buttonFont != null) {
            instructionsLabel.setFont(buttonFont);
        }
        instructionsLabel.setStyle("-fx-text-fill: white;");
        layout.getChildren().add(instructionsLabel);

        Label step1 = new Label("1. Use arrow keys to move.");
        step1.setStyle("-fx-text-fill: white;");
        Label step2 = new Label("2. Press space key to shoot.");
        step2.setStyle("-fx-text-fill: white;");
        Label step3 = new Label("3. Avoid enemies and their projectiles to stay alive.");
        step3.setStyle("-fx-text-fill: white;");
        Label step4 = new Label("4. Complete all three levels to win.");
        step4.setStyle("-fx-text-fill: white;");
        layout.getChildren().addAll(step1, step2, step3, step4);

        Button closeButton = new Button("Close");
        if (buttonFont != null) {
            closeButton.setFont(buttonFont);
        }
        closeButton.setOnAction(event -> instructionsStage.close());
        layout.getChildren().add(closeButton);

        rootLayout.setCenter(layout);

        Scene instructionsScene = new Scene(rootLayout, 400, 300);
        instructionsScene.setFill(null);
        instructionsStage.setScene(instructionsScene);
        instructionsStage.showAndWait();
    }
}