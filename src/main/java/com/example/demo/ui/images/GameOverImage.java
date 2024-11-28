package com.example.demo.ui.images;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameOverImage extends ImageView {
    
    private static final String IMAGE_NAME = "/com/example/demo/images/gameover.png";

    public GameOverImage(double xPosition, double yPosition, double width, double height) {
        setImage(new Image(getClass().getResource(IMAGE_NAME).toExternalForm()));
        setFitWidth(width);
        setFitHeight(height);
        setLayoutX(xPosition);
        setLayoutY(yPosition);
    }
}