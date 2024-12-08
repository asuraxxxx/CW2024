package com.example.demo.levels;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.planes.EnemyPlane2;

/**
 * The LevelTwo class represents the second level in the game.
 * It extends LevelParent and manages the spawning of enemy planes and game progression.
 */
public class LevelTwo extends LevelParent {

    // Path to the background image for the second level
    private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/background2.jpg";
    
    // Class name of the next level
    private static final String NEXT_LEVEL = "com.example.demo.levels.LevelBoss";
    
    // Total number of enemies to spawn
    private static final int TOTAL_ENEMIES = 8;
    
    // Number of kills required to advance to the next level
    private static final int KILLS_TO_ADVANCE = 15;
    
    // Probability of spawning an enemy
    private static final double ENEMY_SPAWN_PROBABILITY = 0.20;
    
    // Initial health of the player
    private static final int PLAYER_INITIAL_HEALTH = 5;

    /**
     * Constructor for LevelTwo.
     * 
     * @param screenHeight The height of the game screen.
     * @param screenWidth The width of the game screen.
     */
    public LevelTwo(double screenHeight, double screenWidth) {
        super(BACKGROUND_IMAGE_NAME, screenHeight, screenWidth, PLAYER_INITIAL_HEALTH);
    }

    /**
     * Checks if the game is over by verifying if the user is destroyed or has reached the kill target.
     */
    @Override
    protected void checkIfGameOver() {
        if (userIsDestroyed()) {
            loseGame();
        } else if (userHasReachedKillTarget()) {
            goToNextLevel(NEXT_LEVEL);
        }
    }

    /**
     * Initializes friendly units in the game, specifically the user.
     */
    @Override
    protected void initializeFriendlyUnits() {
        getRoot().getChildren().add(getUser());
    }

    /**
     * Spawns enemy units based on the current number of enemies and spawn probability.
     */
    @Override
    protected void spawnEnemyUnits() {
        int currentNumberOfEnemies = getCurrentNumberOfEnemies();
        for (int i = 0; i < TOTAL_ENEMIES - currentNumberOfEnemies; i++) {
            if (Math.random() < ENEMY_SPAWN_PROBABILITY) {
                double newEnemyInitialYPosition = 25 + Math.random() * getEnemyMaximumYPosition();
                ActiveActorDestructible newEnemy = new EnemyPlane2(getScreenWidth(), newEnemyInitialYPosition);
                addEnemyUnit(newEnemy);
            }
        }
    }

    /**
     * Instantiates the view for the second level.
     * 
     * @return The LevelView instance.
     */
    @Override
    protected LevelView instantiateLevelView() {
        return new LevelView(getRoot(), PLAYER_INITIAL_HEALTH);
    }

    /**
     * Checks if the user has reached the required number of kills to advance to the next level.
     * 
     * @return True if the user has reached the kill target, false otherwise.
     */
    private boolean userHasReachedKillTarget() {
        return getUser().getNumberOfKills() >= KILLS_TO_ADVANCE;
    }

    /**
     * Updates the status text to show the remaining enemies needed to advance to the next level.
     */
    @Override
    protected void updateStatusText() {
        int killsRemaining = KILLS_TO_ADVANCE - getUser().getNumberOfKills();
        updateStatusText("Remaining enemies to advance the next level: " + killsRemaining);
    }
}