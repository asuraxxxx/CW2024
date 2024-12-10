package com.example.demo.managers.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.managers.TimerManager;

import static org.junit.jupiter.api.Assertions.*;

public class TimerManagerTest {
    private TimerManager timerManager;

    @BeforeEach
    public void setUp() {
        timerManager = new TimerManager();
    }

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