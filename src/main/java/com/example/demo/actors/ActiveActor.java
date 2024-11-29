package com.example.demo.actors;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class ActiveActor extends ImageView {
    private static final String IMAGE_LOCATION = "/com/example/demo/images/";

    public ActiveActor(String imageName, int imageHeight, double initialXPos, double initialYPos) {
        this.setImage(new Image(getClass().getResource(IMAGE_LOCATION + imageName).toExternalForm()));
        this.setLayoutX(initialXPos);
        this.setLayoutY(initialYPos);
        this.setFitHeight(imageHeight);
        this.setPreserveRatio(true);
    }

    public abstract void updatePosition();

    public void moveHorizontally(double horizontalMove) {
        this.setTranslateX(getTranslateX() + horizontalMove);
    }

    public void moveVertically(double verticalMove) {
        this.setTranslateY(getTranslateY() + verticalMove);
    }
}