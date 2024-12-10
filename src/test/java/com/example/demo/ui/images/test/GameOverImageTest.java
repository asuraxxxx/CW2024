package com.example.demo.ui.images.test;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.ui.images.GameOverImage;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverImageTest {

    @BeforeEach
    public void setUp() {
        // Initialize JavaFX environment
        new JFXPanel();
    }

    @Test
    public void testGameOverImageInitialization() {
        double xPosition = 100;
        double yPosition = 150;
        double width = 200;
        double height = 100;

        GameOverImage gameOverImage = new GameOverImage(xPosition, yPosition, width, height);

        // Verify the image is loaded correctly
        Image image = gameOverImage.getImage();
        assertNotNull(image);
        assertEquals("/com/example/demo/images/gameover.png", image.getUrl().substring(image.getUrl().indexOf("/com")));

        // Verify the dimensions of the image
        assertEquals(width, gameOverImage.getFitWidth());
        assertEquals(height, gameOverImage.getFitHeight());

        // Verify the position of the image
        assertEquals(xPosition, gameOverImage.getLayoutX());
        assertEquals(yPosition, gameOverImage.getLayoutY());
    }
}