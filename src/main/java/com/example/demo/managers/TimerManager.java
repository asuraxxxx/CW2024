package com.example.demo.managers;

public class TimerManager {
    private long startTime;
    private long elapsedTime;
    private long levelOneTime;
    private long levelTwoTime;
    private long levelThreeTime;

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        elapsedTime = System.nanoTime() - startTime;
    }

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

    public long getTotalTime() {
        return levelOneTime + levelTwoTime + levelThreeTime;
    }
}