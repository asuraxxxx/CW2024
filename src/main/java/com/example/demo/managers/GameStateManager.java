package com.example.demo.managers;

import com.example.demo.levels.LevelParent;
import com.example.demo.levels.LevelView;

public class GameStateManager {

    private final LevelParent levelParent;
    private final LevelView levelView;

    public GameStateManager(LevelParent levelParent, LevelView levelView) {
        this.levelParent = levelParent;
        this.levelView = levelView;
    }

    public void winGame() {
        levelParent.getTimelineManager().stop();
        // Removed: levelView.showWinImage();
    }

    public void loseGame() {
        levelParent.getTimelineManager().stop();
        levelView.showGameOverImage();
    }
}