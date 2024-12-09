package com.example.demo.ui;

import com.example.demo.controller.GameController;
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

    private final Stage stage;
    private final Button restartLevelButton;
    private final Button returnToMainMenuButton;
    private final long totalTime;

    public WinGameScreen(Stage stage, long totalTime) {
        this.stage = stage;
        this.totalTime = totalTime;
        this.restartLevelButton = createImageButton("/com/example/demo/images/restartbutton.jpg");
        this.returnToMainMenuButton = createImageButton("/com/example/demo/images/exitbutton.jpg");
    }

    private Button createImageButton(String imagePath) {
        Image image = new Image(getClass().getResource(imagePath).toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(35);  // Adjust the size as needed
        imageView.setFitHeight(35);  // Adjust the size as needed
        Button button = new Button();
        button.setGraphic(imageView);
        return button;
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
                titleFont = Font.loadFont(this.getClass().getResource("/com/example/demo/fonts/impact.ttf").toExternalForm(), 30);
            } catch (Exception e) {
                System.err.println("Error loading font: " + e.getMessage());
            }

            Label titleLabel = new Label("You Win!");
            if (titleFont != null) {
                titleLabel.setFont(titleFont);
            }
            titleLabel.setStyle("-fx-text-fill: white;");

            long totalSeconds = totalTime / 1_000_000_000;
            Label timeLabel = new Label("Total time used: " + totalSeconds + " seconds");
            if (titleFont != null) {
                timeLabel.setFont(titleFont);
            }
            timeLabel.setStyle("-fx-text-fill: white;");

            restartLevelButton.setOnAction(event -> {
                GameController gameController = new GameController(stage);
                try {
                    gameController.launchGame();
                } catch (Exception ex) {
                    System.err.println("Error restarting game.");
                    ex.printStackTrace();
                }
                winStage.close();
            });

            returnToMainMenuButton.setOnAction(event -> {
                MainMenu mainMenu = new MainMenu(stage);
                stage.setScene(mainMenu.getMainMenuScene());
                winStage.close();
            });

            layout.getChildren().addAll(titleLabel, timeLabel, restartLevelButton, returnToMainMenuButton);
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