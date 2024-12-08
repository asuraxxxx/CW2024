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

/**
 * The WinGameScreen class creates a screen that is displayed when the player wins the game.
 * It includes buttons to restart the level or return to the main menu.
 */
public class WinGameScreen {

    // The primary stage of the application
    private final Stage stage;
    
    // Buttons for restarting the level and returning to the main menu
    private final Button restartLevelButton;
    private final Button returnToMainMenuButton;

    /**
     * Constructor for WinGameScreen.
     * 
     * @param stage The primary stage of the application.
     */
    public WinGameScreen(Stage stage) {
        this.stage = stage;
        // Initialize buttons with images
        this.restartLevelButton = createImageButton("/com/example/demo/images/restartbutton.jpg");
        this.returnToMainMenuButton = createImageButton("/com/example/demo/images/exitbutton.jpg");
    }

    /**
     * Creates a button with an image.
     * 
     * @param imagePath The path to the image file.
     * @return A Button with the specified image.
     */
    private Button createImageButton(String imagePath) {
        Image image = new Image(getClass().getResource(imagePath).toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);  // Adjust the size as needed
        imageView.setFitHeight(50);  // Adjust the size as needed
        Button button = new Button();
        button.setGraphic(imageView);
        return button;
    }

    /**
     * Displays the win game screen.
     */
    public void show() {
        Platform.runLater(() -> {
            Stage winStage = new Stage();
            winStage.initModality(Modality.APPLICATION_MODAL);
            winStage.initStyle(StageStyle.TRANSPARENT);

            // Set up the root layout with a background image
            BorderPane rootLayout = new BorderPane();
            BackgroundImage backgroundImage = new BackgroundImage(
                new Image(this.getClass().getResource("/com/example/demo/images/pausescreen.png").toExternalForm()),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false)
            );
            rootLayout.setBackground(new Background(backgroundImage));

            // Create a vertical box layout for the buttons and title
            VBox layout = new VBox(20);
            layout.setAlignment(Pos.CENTER);

            // Load and set the font for the title
            Font titleFont = null;
            try {
                titleFont = Font.loadFont(this.getClass().getResource("/com/example/demo/fonts/impact.ttf").toExternalForm(), 40);
            } catch (Exception e) {
                System.err.println("Error loading font: " + e.getMessage());
            }

            // Create and style the title label
            Label titleLabel = new Label("You Win!");
            if (titleFont != null) {
                titleLabel.setFont(titleFont);
            }
            titleLabel.setStyle("-fx-text-fill: white;");

            // Set actions for the buttons
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

            // Add the title and buttons to the layout
            layout.getChildren().addAll(titleLabel, restartLevelButton, returnToMainMenuButton);
            rootLayout.setCenter(layout);

            // Create and display the scene
            Scene winScene = new Scene(rootLayout, 500, 350);
            winScene.setFill(null);
            winStage.setScene(winScene);
            winStage.showAndWait();
        });
    }

    /**
     * Returns the restart level button.
     * 
     * @return The restart level button.
     */
    public Button getRestartLevelButton() {
        return restartLevelButton;
    }

    /**
     * Returns the return to main menu button.
     * 
     * @return The return to main menu button.
     */
    public Button getReturnToMainMenuButton() {
        return returnToMainMenuButton;
    }
}