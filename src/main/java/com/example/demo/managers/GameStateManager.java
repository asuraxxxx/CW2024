package com.example.demo.managers;

import com.example.demo.levels.LevelParent;
import com.example.demo.levels.LevelView;

/**
 * The GameStateManager class manages the game state, including win and lose conditions.
 */
public class GameStateManager {

    private final LevelParent levelParent;
    private final LevelView levelView;

    /**
     * Constructs a new GameStateManager.
     *
     * @param levelParent the parent level
     * @param levelView the view of the level
     */
    public GameStateManager(LevelParent levelParent, LevelView levelView) {
        this.levelParent = levelParent;
        this.levelView = levelView;
    }

    /**
     * Handles the game win condition managed by GameStateManager.
     */
    public void winGame() {
        levelParent.getTimelineManager().stop();
        // Removed: levelView.showWinImage();
    }

    /**
     * Handles the game lose condition managed by GameStateManager.
     */
    public void loseGame() {
        levelParent.getTimelineManager().stop();
        levelView.showGameOverImage();
    }

    /**
     * Checks if the game is over based on the user's state and progresses to the next level if conditions are met.
     *
     * @param userIsDestroyed whether the user's plane is destroyed
     * @param userHasReachedKillTarget whether the user has reached the kill target
     * @param nextLevel the name of the next level
     */
    public void checkIfGameOver(boolean userIsDestroyed, boolean userHasReachedKillTarget, String nextLevel) {
        if (userIsDestroyed) {
            loseGame();
        } else if (userHasReachedKillTarget) {
            levelParent.goToNextLevel(nextLevel);
        }
    }
}