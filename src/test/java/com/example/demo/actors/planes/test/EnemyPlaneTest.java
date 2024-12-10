package com.example.demo.actors.planes.test;

import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.actors.planes.EnemyPlane;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the EnemyPlane class.
 * This class contains unit tests for the EnemyPlane class using JUnit 5.
 */
public class EnemyPlaneTest {

    private EnemyPlane enemyPlane;

    /**
     * Sets up the test environment before each test.
     * Initializes the JavaFX environment and creates an instance of EnemyPlane for testing.
     */
    @BeforeEach
    public void setUp() {
        // Initialize JavaFX environment
        new JFXPanel();

        // Create an EnemyPlane instance for testing
        enemyPlane = new EnemyPlane(100, 200);
    }

    /**
     * Tests the updateActor method of the EnemyPlane class.
     * Verifies that the position of the enemy plane is updated correctly.
     */
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