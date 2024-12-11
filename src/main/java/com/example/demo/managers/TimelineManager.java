package com.example.demo.managers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * The TimelineManager class manages the game loop timeline for updating the scene.
 */
public class TimelineManager {
    private static final int MILLISECOND_DELAY = 50;
    private final Timeline timeline;

    /**
     * Constructs a new TimelineManager.
     *
     * @param updateScene the runnable to update the scene
     */
    public TimelineManager(Runnable updateScene) {
        this.timeline = new Timeline();
        initializeTimeline(updateScene);
    }

    /**
     * Initializes the timeline with a game loop key frame managed by TimelineManager.
     *
     * @param updateScene the runnable to update the scene
     */
    private void initializeTimeline(Runnable updateScene) {
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame gameLoop = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> updateScene.run());
        timeline.getKeyFrames().add(gameLoop);
    }

    /**
     * Starts the timeline.
     */
    public void start() {
        timeline.play();
    }

    /**
     * Stops the timeline.
     */
    public void stop() {
        timeline.stop();
    }

    /**
     * Pauses the timeline.
     */
    public void pause() {
        timeline.pause();
    }

    /**
     * Resumes the timeline.
     */
    public void resume() {
        timeline.play();
    }

    /**
     * Gets the timeline.
     *
     * @return the timeline
     */
    public Timeline getTimeline() {
        return timeline;
    }
}