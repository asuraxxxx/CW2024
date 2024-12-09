package com.example.demo.levels;

import com.example.demo.actors.planes.EnemyPlane;
import com.example.demo.managers.ActorManager;
import com.example.demo.managers.GameStateManager;
import com.example.demo.managers.StatusTextManager;

public class LevelOne extends LevelParent {

    private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/background2.jpg";
    private static final String NEXT_LEVEL = "com.example.demo.levels.LevelTwo";
    private static final int TOTAL_ENEMIES = 5;
    private static final int KILLS_TO_ADVANCE = 10;
    private static final double ENEMY_SPAWN_PROBABILITY = 0.20;
    private static final int PLAYER_INITIAL_HEALTH = 5;

    private final GameStateManager gameStateManager;
    private final ActorManager actorManager;
    private final StatusTextManager statusTextManager;

    public LevelOne(double screenHeight, double screenWidth) {
        super(BACKGROUND_IMAGE_NAME, screenHeight, screenWidth, PLAYER_INITIAL_HEALTH);
        this.gameStateManager = new GameStateManager(this, instantiateLevelView());
        this.actorManager = new ActorManager(getRoot(), getFriendlyUnits(), getEnemyUnits(), getUserProjectiles(), getEnemyProjectiles());
        this.statusTextManager = new StatusTextManager(getRoot(), screenWidth);
        getTimerManager().startTimer(); // Start the timer when the level begins
    }

    @Override
    protected void checkIfGameOver() {
        if (userIsDestroyed() || userHasReachedKillTarget()) {
            getTimerManager().stopTimer(); // Stop the timer when the level ends
            getTimerManager().storeLevelTime(1); // Store the time for level one
            gameStateManager.checkIfGameOver(userIsDestroyed(), userHasReachedKillTarget(), NEXT_LEVEL);
        }
    }

    @Override
    protected void initializeFriendlyUnits() {
        actorManager.initializeFriendlyUnits(getUser());
    }

    @Override
    protected void spawnEnemyUnits() {
        actorManager.spawnEnemyUnits(TOTAL_ENEMIES, ENEMY_SPAWN_PROBABILITY, () -> {
            double newEnemyInitialYPosition = Math.random() * getEnemyMaximumYPosition();
            return new EnemyPlane(getScreenWidth(), newEnemyInitialYPosition);
        });
    }

    @Override
    protected LevelView instantiateLevelView() {
        return new LevelView(getRoot(), PLAYER_INITIAL_HEALTH);
    }

    private boolean userHasReachedKillTarget() {
        return getUser().getNumberOfKills() >= KILLS_TO_ADVANCE;
    }

    @Override
    protected void updateStatusText() {
        int killsRemaining = Math.max(KILLS_TO_ADVANCE - getUser().getNumberOfKills(), 0);
        statusTextManager.updateStatusText("Remaining enemies to advance to the next level: " + killsRemaining);
    }
}