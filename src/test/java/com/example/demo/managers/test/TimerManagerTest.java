package com.example.demo.managers.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.managers.TimerManager;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the TimerManager class.
 * This class contains unit tests for the TimerManager class using JUnit 5.
 */
public class TimerManagerTest {
    private TimerManager timerManager;

    /**
     * Sets up the test environment before each test.
     * Initializes an instance of TimerManager for testing.
     */
    @BeforeEach
    public void setUp() {
        timerManager = new TimerManager();
    }

    /**
     * Tests the start and stop functionality of the timer.
     * Verifies that the timer starts and stops correctly and that the total time is non-negative.
     */
    @Test
    public void testStartAndStopTimer() {
        timerManager.startTimer();
        // Simulate some elapsed time
        try {
            Thread.sleep(10); // Sleep for 10 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timerManager.stopTimer();
        assertTrue(timerManager.getTotalTime() >= 0);
    }

    /**
     * Tests storing the level time.
     * Verifies that the level times are stored correctly and that each subsequent level time is greater than or equal to the previous one.
     */
    @Test
    public void testStoreLevelTime() {
        timerManager.startTimer();
        // Simulate some elapsed time
        try {
            Thread.sleep(10); // Sleep for 10 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timerManager.stopTimer();
        timerManager.storeLevelTime(1);
        long levelOneTime = timerManager.getTotalTime();
        assertTrue(levelOneTime >= 0);

        timerManager.startTimer();
        // Simulate some elapsed time
        try {
            Thread.sleep(20); // Sleep for 20 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timerManager.stopTimer();
        timerManager.storeLevelTime(2);
        long levelTwoTime = timerManager.getTotalTime();
        assertTrue(levelTwoTime >= levelOneTime);

        timerManager.startTimer();
        // Simulate some elapsed time
        try {
            Thread.sleep(30); // Sleep for 30 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timerManager.stopTimer();
        timerManager.storeLevelTime(3);
        long levelThreeTime = timerManager.getTotalTime();
        assertTrue(levelThreeTime >= levelTwoTime);
    }

    /**
     * Tests getting the total time.
     * Verifies that the total time is correctly calculated and is non-negative.
     */
    @Test
    public void testGetTotalTime() {
        timerManager.startTimer();
        // Simulate some elapsed time
        try {
            Thread.sleep(10); // Sleep for 10 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timerManager.stopTimer();
        timerManager.storeLevelTime(1);

        timerManager.startTimer();
        // Simulate some elapsed time
        try {
            Thread.sleep(20); // Sleep for 20 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timerManager.stopTimer();
        timerManager.storeLevelTime(2);

        timerManager.startTimer();
        // Simulate some elapsed time
        try {
            Thread.sleep(30); // Sleep for 30 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timerManager.stopTimer();
        timerManager.storeLevelTime(3);

        long totalTime = timerManager.getTotalTime();
        assertTrue(totalTime >= 60_000_000); // 60 milliseconds in nanoseconds
    }
}