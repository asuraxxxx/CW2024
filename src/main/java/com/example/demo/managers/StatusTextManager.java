package com.example.demo.managers;

import javafx.scene.Group;
import javafx.scene.text.Text;

/**
 * The StatusTextManager class manages the status text displayed on the screen.
 */
public class StatusTextManager {
    private final Text statusText;
    private final double screenWidth;
    private final Group root;

    /**
     * Constructs a new StatusTextManager.
     *
     * @param root the root group of the scene
     * @param screenWidth the width of the screen
     */
    public StatusTextManager(Group root, double screenWidth) {
        this.statusText = new Text();
        this.screenWidth = screenWidth;
        this.root = root;
        initializeStatusText();
    }

    /**
     * Initializes the status text properties and adds it to the root group managed by StatusTextManager.
     */
    private void initializeStatusText() {
        statusText.setLayoutY(20);
        statusText.setStyle("-fx-font-size: 20px; -fx-fill: black; -fx-font-family: 'Impact';");
        root.getChildren().add(statusText);
        centerStatusText();

        statusText.textProperty().addListener((observable, oldValue, newValue) -> centerStatusText());
    }

    /**
     * Sets the position of the status text.
     *
     * @param x the x-coordinate of the status text
     * @param y the y-coordinate of the status text
     */
    public void setStatusTextPosition(double x, double y) {
        statusText.setLayoutX(x);
        statusText.setLayoutY(y);
    }

    /**
     * Centers the status text horizontally on the screen.
     */
    private void centerStatusText() {
        double centerX = (screenWidth / 2) - (statusText.getBoundsInLocal().getWidth() / 2);
        setStatusTextPosition(centerX, 20);
    }

    /**
     * Updates the status text with new content and re-centers it.
     *
     * @param newText the new text to display
     */
    public void updateStatusText(String newText) {
        statusText.setText(newText);
        centerStatusText();
        bringToFront(); // Ensure the status text is brought to the front
    }

    /**
     * Brings the status text to the front of the root group's children.
     */
    private void bringToFront() {
        root.getChildren().remove(statusText);
        root.getChildren().add(statusText);
    }

    /**
     * Gets the status text.
     *
     * @return the status text
     */
    public Text getStatusText() {
        return statusText;
    }
}