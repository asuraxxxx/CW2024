package com.example.demo.ui.images;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShieldImage extends ImageView {
    
    private static final String IMAGE_NAME = "/com/example/demo/images/shield.png";
    public static final int SHIELD_SIZE = 200; // Change this to public

    public ShieldImage(double xPosition, double yPosition) {
        this.setLayoutX(xPosition);
        this.setLayoutY(yPosition);
        Image image = new Image(getClass().getResource(IMAGE_NAME).toExternalForm());
        if (image.isError()) {
            System.out.println("Error loading shield image");
        } else {
            this.setImage(image);
        }
        this.setVisible(false);
        this.setFitHeight(SHIELD_SIZE);
        this.setFitWidth(SHIELD_SIZE);
    }

    public void showShield() {
        this.setVisible(true);
    }
    
    public void hideShield() {
        this.setVisible(false);
    }
}