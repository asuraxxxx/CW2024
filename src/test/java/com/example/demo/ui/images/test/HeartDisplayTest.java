package com.example.demo.ui.images.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;
import javafx.scene.layout.HBox;
import com.example.demo.ui.images.HeartDisplay;

public class HeartDisplayTest {

    private HeartDisplay heartDisplay;

    @BeforeEach
    public void setUp() {
        // Initialize JavaFX environment
        new JFXPanel();
        heartDisplay = new HeartDisplay(100, 200, 5);
    }

    @Test
    public void testConstructorInitialization() {
        HBox container = heartDisplay.getContainer();
        assertEquals(100, container.getLayoutX());
        assertEquals(200, container.getLayoutY());
        assertEquals(5, container.getChildren().size());
    }

    @Test
    public void testRemoveHeart() {
        heartDisplay.removeHeart();
        assertEquals(4, heartDisplay.getContainer().getChildren().size());
    }

    @Test
    public void testRemoveHeartWhenEmpty() {
        for (int i = 0; i < 5; i++) {
            heartDisplay.removeHeart();
        }
        heartDisplay.removeHeart(); // Attempt to remove when empty
        assertEquals(0, heartDisplay.getContainer().getChildren().size());
    }

    @Test
    public void testGetContainer() {
        HBox container = heartDisplay.getContainer();
        assertNotNull(container);
    }
}