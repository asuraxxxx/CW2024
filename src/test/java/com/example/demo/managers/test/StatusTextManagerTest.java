package com.example.demo.managers.test;

import javafx.scene.Group;
import javafx.scene.text.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.managers.StatusTextManager;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the StatusTextManager class.
 * This class contains unit tests for the StatusTextManager class using JUnit 5.
 */
public class StatusTextManagerTest {
    private StatusTextManager statusTextManager;
    private Group root;
    private double screenWidth;

    /**
     * Sets up the test environment before each test.
     * Initializes the root group and screen width, and creates an instance of StatusTextManager for testing.
     */
    @BeforeEach
    public void setUp() {
        root = new Group();
        screenWidth = 800; // Example screen width
        statusTextManager = new StatusTextManager(root, screenWidth);
    }

    /**
     * Tests the initialization of the status text.
     * Verifies that the status text is not null, is positioned correctly, and is added to the root group.
     */
    @Test
    public void testInitializeStatusText() {
        Text statusText = statusTextManager.getStatusText();
        assertNotNull(statusText);
        assertEquals(20, statusText.getLayoutY());
        assertTrue(root.getChildren().contains(statusText));
    }

    /**
     * Tests setting the position of the status text.
     * Verifies that the status text is positioned at the specified coordinates.
     */
    @Test
    public void testSetStatusTextPosition() {
        statusTextManager.setStatusTextPosition(100, 50);
        Text statusText = statusTextManager.getStatusText();
        assertEquals(100, statusText.getLayoutX());
        assertEquals(50, statusText.getLayoutY());
    }

    /**
     * Tests centering the status text.
     * Verifies that the status text is centered horizontally on the screen.
     */
    @Test
    public void testCenterStatusText() {
        statusTextManager.updateStatusText("Test");
        Text statusText = statusTextManager.getStatusText();
        double expectedX = (screenWidth / 2) - (statusText.getBoundsInLocal().getWidth() / 2);
        assertEquals(expectedX, statusText.getLayoutX());
    }

    /**
     * Tests updating the status text.
     * Verifies that the status text is updated with the new text.
     */
    @Test
    public void testUpdateStatusText() {
        statusTextManager.updateStatusText("New Status");
        Text statusText = statusTextManager.getStatusText();
        assertEquals("New Status", statusText.getText());
    }

    /**
     * Tests bringing the status text to the front.
     * Verifies that the status text is the last child in the root group, indicating it is in the front.
     */
    @Test
    public void testBringToFront() {
        statusTextManager.updateStatusText("Bring to Front Test");
        Text statusText = statusTextManager.getStatusText();
        assertEquals(statusText, root.getChildren().get(root.getChildren().size() - 1));
    }
}