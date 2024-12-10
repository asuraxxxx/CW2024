package com.example.demo.actors.planes;

import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyPlaneTest {

    private EnemyPlane enemyPlane;

    @BeforeEach
    public void setUp() {
        // Initialize JavaFX environment
        new JFXPanel();

        // Create an EnemyPlane instance for testing
        enemyPlane = new EnemyPlane(100, 200);
    }

    @Test
    public void testUpdateActor() {
        // Initial position
        double initialX = enemyPlane.getLayoutX() + enemyPlane.getTranslateX();
        double initialY = enemyPlane.getLayoutY() + enemyPlane.getTranslateY();

        // Call the updateActor method
        enemyPlane.updateActor();

        // Updated position
        double updatedX = enemyPlane.getLayoutX() + enemyPlane.getTranslateX();
        double updatedY = enemyPlane.getLayoutY() + enemyPlane.getTranslateY();

        // Verify that the position has been updated
        assertNotEquals(initialX, updatedX);
        assertEquals(initialY, updatedY); // Assuming only horizontal movement
    }
}