package com.example.demo.ui.images.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;
import javafx.scene.layout.HBox;
import com.example.demo.ui.images.HeartDisplay;

/**
 * Test class for the HeartDisplay class.
 * This class contains unit tests for the HeartDisplay class using JUnit 5.
 */
public class HeartDisplayTest {

    private HeartDisplay heartDisplay;

    /**
     * Sets up the test environment before each test.
     * Initializes the JavaFX environment and creates an instance of HeartDisplay for testing.
     */
    @BeforeEach
    public void setUp() {
        // Initialize JavaFX environment
        new JFXPanel();
        heartDisplay = new HeartDisplay(100, 200, 5);
    }

    /**
     * Tests the initialization of the HeartDisplay.
     * Verifies that the container is positioned correctly and contains the correct number of hearts.
     */
    @Test
    public void testConstructorInitialization() {
        HBox container = heartDisplay.getContainer();
        assertEquals(100, container.getLayoutX());
        assertEquals(200, container.getLayoutY());
        assertEquals(5, container.getChildren().size());
    }

    /**
     * Tests the removeHeart method.
     * Verifies that a heart is removed from the container.
     */
    @Test
    public void testRemoveHeart() {
        heartDisplay.removeHeart();
        assertEquals(4, heartDisplay.getContainer().getChildren().size());
    }

    /**
     * Tests the removeHeart method when the container is empty.
     * Verifies that no hearts are removed when the container is already empty.
     */
    @Test
    public void testRemoveHeartWhenEmpty() {
        for (int i = 0; i < 5; i++) {
            heartDisplay.removeHeart();
        }
        heartDisplay.removeHeart(); // Attempt to remove when empty
        assertEquals(0, heartDisplay.getContainer().getChildren().size());
    }

    /**
     * Tests the getContainer method.
     * Verifies that the container is not null.
     */
    @Test
    public void testGetContainer() {
        HBox container = heartDisplay.getContainer();
        assertNotNull(container);
    }
}