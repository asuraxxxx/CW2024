package com.example.demo.ui;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.geometry.Pos;

public class WinGameScreen {

    private final Button restartLevelButton;
    private final Button returnToMainMenuButton;

    public WinGameScreen(Stage stage) {
        this.restartLevelButton = new Button("Restart Level");
        this.returnToMainMenuButton = new Button("Return to Main Menu");
    }

    public void show() {
        Platform.runLater(() -> {
            Stage winStage = new Stage();
            winStage.initModality(Modality.APPLICATION_MODAL);
            winStage.initStyle(StageStyle.TRANSPARENT);

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

            Label titleLabel = new Label("You Win!");
            if (titleFont != null) {
                titleLabel.setFont(titleFont);
            }
            titleLabel.setStyle("-fx-text-fill: white;");

            layout.getChildren().addAll(titleLabel, restartLevelButton, returnToMainMenuButton);
            rootLayout.setCenter(layout);

            Scene winScene = new Scene(rootLayout, 500, 350);
            winScene.setFill(null);
            winStage.setScene(winScene);
            winStage.showAndWait();
        });
    }

    public Button getRestartLevelButton() {
        return restartLevelButton;
    }

    public Button getReturnToMainMenuButton() {
        return returnToMainMenuButton;
    }
}