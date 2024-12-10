package com.example.demo.managers;

/**
 * The TimerManager class manages the timing for different levels in the game.
 */
public class TimerManager {
    private long startTime;
    private long elapsedTime;
    private long levelOneTime;
    private long levelTwoTime;
    private long levelThreeTime;

    /**
     * Starts the timer managed by TimerManager.
     */
    public void startTimer() {
        startTime = System.nanoTime();
    }

    /**
     * Stops the timer managed by TimerManager and calculates the elapsed time.
     */
    public void stopTimer() {
        elapsedTime = System.nanoTime() - startTime;
    }

    /**
     * Stores the elapsed time for a specific level.
     *
     * @param level the level number (1, 2, or 3)
     */
    public void storeLevelTime(int level) {
        switch (level) {
            case 1:
                levelOneTime = elapsedTime;
                break;
            case 2:
                levelTwoTime = elapsedTime;
                break;
            case 3:
                levelThreeTime = elapsedTime;
                break;
        }
    }

    /**
     * Gets the total time elapsed across all levels.
     *
     * @return the total time elapsed
     */
    public long getTotalTime() {
        return levelOneTime + levelTwoTime + levelThreeTime;
    }
}