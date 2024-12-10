package com.example.demo.managers.test;

import javafx.scene.Group;
import javafx.scene.text.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.managers.StatusTextManager;

import static org.junit.jupiter.api.Assertions.*;

public class StatusTextManagerTest {
    private StatusTextManager statusTextManager;
    private Group root;
    private double screenWidth;

    @BeforeEach
    public void setUp() {
        root = new Group();
        screenWidth = 800; // Example screen width
        statusTextManager = new StatusTextManager(root, screenWidth);
    }

    @Test
    public void testInitializeStatusText() {
        Text statusText = statusTextManager.getStatusText();
        assertNotNull(statusText);
        assertEquals(20, statusText.getLayoutY());
        assertTrue(root.getChildren().contains(statusText));
    }

    @Test
    public void testSetStatusTextPosition() {
        statusTextManager.setStatusTextPosition(100, 50);
        Text statusText = statusTextManager.getStatusText();
        assertEquals(100, statusText.getLayoutX());
        assertEquals(50, statusText.getLayoutY());
    }

    @Test
    public void testCenterStatusText() {
        statusTextManager.updateStatusText("Test");
        Text statusText = statusTextManager.getStatusText();
        double expectedX = (screenWidth / 2) - (statusText.getBoundsInLocal().getWidth() / 2);
        assertEquals(expectedX, statusText.getLayoutX());
    }

    @Test
    public void testUpdateStatusText() {
        statusTextManager.updateStatusText("New Status");
        Text statusText = statusTextManager.getStatusText();
        assertEquals("New Status", statusText.getText());
    }

    @Test
    public void testBringToFront() {
        statusTextManager.updateStatusText("Bring to Front Test");
        Text statusText = statusTextManager.getStatusText();
        assertEquals(statusText, root.getChildren().get(root.getChildren().size() - 1));
    }
}