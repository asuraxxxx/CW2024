package com.example.demo.managers;

import javafx.scene.Group;
import javafx.scene.text.Text;

public class StatusTextManager {
    private final Text statusText;
    private final double screenWidth;
    private final Group root;

    public StatusTextManager(Group root, double screenWidth) {
        this.statusText = new Text();
        this.screenWidth = screenWidth;
        this.root = root;
        initializeStatusText();
    }

    private void initializeStatusText() {
        statusText.setLayoutY(20);
        statusText.setStyle("-fx-font-size: 20px; -fx-fill: black; -fx-font-family: 'Impact';");
        root.getChildren().add(statusText);
        centerStatusText();

        statusText.textProperty().addListener((observable, oldValue, newValue) -> centerStatusText());
    }

    public void setStatusTextPosition(double x, double y) {
        statusText.setLayoutX(x);
        statusText.setLayoutY(y);
    }

    private void centerStatusText() {
        double centerX = (screenWidth / 2) - (statusText.getBoundsInLocal().getWidth() / 2);
        setStatusTextPosition(centerX, 20);
    }

    public void updateStatusText(String newText) {
        statusText.setText(newText);
        centerStatusText();
        bringToFront(); // Ensure the status text is brought to the front
    }

    private void bringToFront() {
        root.getChildren().remove(statusText);
        root.getChildren().add(statusText);
    }

    public Text getStatusText() {
        return statusText;
    }
}