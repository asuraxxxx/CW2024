package com.example.demo.levels;

import com.example.demo.actors.planes.EnemyPlane2;
import com.example.demo.factories.LevelViewFactory;
import com.example.demo.managers.ActorManager;
import com.example.demo.managers.GameStateManager;
import com.example.demo.managers.StatusTextManager;
import com.example.demo.actors.ActiveActorDestructible;

/**
 * The LevelTwo class represents the second level in the game.
 * It extends the LevelParent class and includes specific logic for managing the level's enemies and game state.
 */
public class LevelTwo extends LevelParent {

    private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/background2.jpg";
    private static final String NEXT_LEVEL = "com.example.demo.levels.LevelBoss";
    private static final int TOTAL_ENEMIES = 8;
    private static final int KILLS_TO_ADVANCE = 15;
    private static final double ENEMY_SPAWN_PROBABILITY = 0.20;
    private static final int PLAYER_INITIAL_HEALTH = 5;

    private final GameStateManager gameStateManager;
    private final ActorManager actorManager;
    private final StatusTextManager statusTextManager;

    /**
     * Constructs a LevelTwo with specified screen dimensions.
     *
     * @param screenHeight The height of the game screen.
     * @param screenWidth The width of the game screen.
     */
    public LevelTwo(double screenHeight, double screenWidth) {
        super(BACKGROUND_IMAGE_NAME, screenHeight, screenWidth, PLAYER_INITIAL_HEALTH);
        this.gameStateManager = new GameStateManager(this, instantiateLevelView());
        this.actorManager = new ActorManager(getRoot(), getFriendlyUnits(), getEnemyUnits(), getUserProjectiles(), getEnemyProjectiles());
        this.statusTextManager = new StatusTextManager(getRoot(), screenWidth);
        getTimerManager().startTimer(); // Start the timer when the level begins
    }

    /**
     * Checks if the game is over by evaluating the state of the user and the kill target.
     * Stops the timer and transitions to the appropriate end game screen.
     */
    @Override
    protected void checkIfGameOver() {
        if (userIsDestroyed() || userHasReachedKillTarget()) {
            getTimerManager().stopTimer(); // Stop the timer when the level ends
            getTimerManager().storeLevelTime(2); // Store the time for level two
            gameStateManager.checkIfGameOver(userIsDestroyed(), userHasReachedKillTarget(), NEXT_LEVEL);
        }
    }

    /**
     * Initializes the friendly units in the level, including the user plane.
     */
    @Override
    protected void initializeFriendlyUnits() {
        actorManager.initializeFriendlyUnits(getUser());
    }

    /**
     * Spawns enemy units in the level based on the spawn probability.
     */
    @Override
    protected void spawnEnemyUnits() {
        actorManager.spawnEnemyUnits(TOTAL_ENEMIES, ENEMY_SPAWN_PROBABILITY, () -> {
            double newEnemyInitialYPosition = 25 + Math.random() * getEnemyMaximumYPosition();
            return new EnemyPlane2(getScreenWidth(), newEnemyInitialYPosition);
        });
    }

    /**
     * Instantiates the level view for the second level.
     *
     * @return The instantiated LevelView.
     */
    @Override
    protected LevelView instantiateLevelView() {
        return LevelViewFactory.createLevelView("LevelTwoView", getRoot(), PLAYER_INITIAL_HEALTH);
    }

    /**
     * Checks if the user has reached the kill target to advance to the next level.
     *
     * @return True if the user has reached the kill target, false otherwise.
     */
    private boolean userHasReachedKillTarget() {
        return getUser().getNumberOfKills() >= KILLS_TO_ADVANCE;
    }

    /**
     * Updates the status text to display the remaining enemies needed to advance to the next level.
     */
    @Override
    protected void updateStatusText() {
        int killsRemaining = Math.max(KILLS_TO_ADVANCE - getUser().getNumberOfKills(), 0);
        statusTextManager.updateStatusText("Remaining enemies to advance to the next level: " + killsRemaining);
    }

    /**
     * Handles the event when a projectile is fired.
     *
     * @param projectile The fired projectile.
     */
    @Override
    public void onProjectileFired(ActiveActorDestructible projectile) {
        getProjectileManager().onProjectileFired(projectile);
    }
}