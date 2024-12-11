package com.example.demo.levels;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.planes.UserPlane;
import com.example.demo.managers.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import java.util.ArrayList;
import java.util.List;

/**
 * The Level Parent is an abstract class that represent a level in the game.
 * Manages the game state, actors, and interactions within a level.
 */
public abstract class LevelParent implements InputManager.ProjectileFiredListener {

    private static final double SCREEN_HEIGHT_ADJUSTMENT = 150;

    private final double screenHeight;
    private final double screenWidth;
    private final double enemyMaximumYPosition;

    private final Group root;
    private final TimelineManager timelineManager;
    private final UserPlane user;
    private final Scene scene;

    private final List<ActiveActorDestructible> friendlyUnits;
    private final List<ActiveActorDestructible> enemyUnits;
    private final List<ActiveActorDestructible> userProjectiles;
    private final List<ActiveActorDestructible> enemyProjectiles;

    private int currentNumberOfEnemies;
    private LevelView levelView;

    private final StringProperty levelProperty;

    protected final StatusTextManager statusManager;

    public InputManager inputHandler;

    private final ActorManager actorManager;
    private final CollisionManager collisionManager;
    private final GameStateManager gameStateManager;
    private final BackgroundManager backgroundManager;
    private final ProjectileManager projectileManager;
    private final TimerManager timerManager;
    private final EnemyManager enemyManager;
    private final PauseManager pauseManager;

    /**
     * Constructs a new LevelParent.
     *
     * @param backgroundImageName the name of the background image
     * @param screenHeight the height of the screen
     * @param screenWidth the width of the screen
     * @param playerInitialHealth the initial health of the player
     */
    public LevelParent(String backgroundImageName, double screenHeight, double screenWidth, int playerInitialHealth) {
        this.root = new Group();
        this.scene = new Scene(root, screenWidth, screenHeight);
        this.timelineManager = new TimelineManager(this::updateScene);
        this.user = new UserPlane(playerInitialHealth);
        this.friendlyUnits = new ArrayList<>();
        this.enemyUnits = new ArrayList<>();
        this.userProjectiles = new ArrayList<>();
        this.enemyProjectiles = new ArrayList<>();

        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.enemyMaximumYPosition = screenHeight - SCREEN_HEIGHT_ADJUSTMENT;
        this.levelView = instantiateLevelView();
        this.currentNumberOfEnemies = 0;
        this.levelProperty = new SimpleStringProperty();
        this.statusManager = new StatusTextManager(root, screenWidth);
        friendlyUnits.add(user);

        this.backgroundManager = new BackgroundManager(backgroundImageName, screenHeight, screenWidth);
        this.inputHandler = new InputManager(user, backgroundManager.getBackground(), this);
        this.actorManager = new ActorManager(root, friendlyUnits, enemyUnits, userProjectiles, enemyProjectiles);
        this.collisionManager = new CollisionManager();
        this.gameStateManager = new GameStateManager(this, levelView);
        this.projectileManager = new ProjectileManager(root, userProjectiles, enemyProjectiles);
        this.timerManager = new TimerManager();
        this.enemyManager = new EnemyManager(root, enemyUnits, screenWidth, enemyMaximumYPosition);
        this.pauseManager = new PauseManager(this, root);
    }

    /**
     * Initializes friendly units in the level.
     */
    protected abstract void initializeFriendlyUnits();

    /**
     * Checks if the game is over.
     */
    protected abstract void checkIfGameOver();

    /**
     * Spawns enemy units in the level.
     */
    protected abstract void spawnEnemyUnits();

    /**
     * Instantiates the level view.
     *
     * @return the level view
     */
    protected abstract LevelView instantiateLevelView();

    /**
     * Updates the status text in the level.
     */
    protected abstract void updateStatusText();

    /**
     * Initializes the scene for the level.
     *
     * @return the initialized scene
     */
    public Scene initializeScene() {
        initializeBackground();
        initializeFriendlyUnits();
        levelView.showHeartDisplay();
        pauseManager.addPauseButton(screenWidth);
        return scene;
    }

    /**
     * Starts the game.
     */
    public void startGame() {
        backgroundManager.getBackground().requestFocus();
        timelineManager.start();
        timerManager.startTimer();
    }

    /**
     * Advances to the next level.
     *
     * @param levelName the name of the next level
     */
    public void goToNextLevel(String levelName) {
        levelProperty.set(levelName);
    }

    /**
     * Gets the level property.
     *
     * @return the level property
     */
    public StringProperty levelProperty() {
        return levelProperty;
    }

    /**
     * Updates the scene.
     */
    private void updateScene() {
        if (!pauseManager.isPaused()) {
            spawnEnemyUnits();
            actorManager.updateActors();
            projectileManager.generateEnemyFire(enemyUnits);
            updateNumberOfEnemies();
            enemyManager.handleEnemyPenetration();
            collisionManager.handleCollisions(userProjectiles, enemyUnits);
            collisionManager.handleCollisions(enemyProjectiles, friendlyUnits);
            collisionManager.handleCollisions(friendlyUnits, enemyUnits);
            actorManager.removeAllDestroyedActors();
            updateKillCount();
            updateLevelView();
            checkIfGameOver();
            updateStatusText();
        }
    }

    /**
     * Initializes the background.
     */
    private void initializeBackground() {
        backgroundManager.addToRoot(root);
    }

    /**
     * Updates the level view.
     */
    private void updateLevelView() {
        levelView.removeHearts(user.getHealth());
    }

    /**
     * Updates the kill count.
     */
    private void updateKillCount() {
        for (int i = 0; i < currentNumberOfEnemies - enemyUnits.size(); i++) {
            user.incrementKillCount();
        }
    }

    /**
     * Handles winning the game.
     */
    protected void winGame() {
        gameStateManager.winGame();
    }

    /**
     * Handles losing the game.
     */
    protected void loseGame() {
        gameStateManager.loseGame();
    }

    /**
     * Gets the user plane.
     *
     * @return the user plane
     */
    protected UserPlane getUser() {
        return user;
    }

    /**
     * Gets the root group.
     *
     * @return the root group
     */
    protected Group getRoot() {
        return root;
    }

    /**
     * Gets the current number of enemies.
     *
     * @return the current number of enemies
     */
    protected int getCurrentNumberOfEnemies() {
        return enemyUnits.size();
    }

    /**
     * Adds an enemy unit to the level.
     *
     * @param enemy the enemy unit to add
     */
    protected void addEnemyUnit(ActiveActorDestructible enemy) {
        enemyUnits.add(enemy);
        root.getChildren().add(enemy);
    }

    /**
     * Gets the maximum Y position for enemies.
     *
     * @return the maximum Y position for enemies
     */
    protected double getEnemyMaximumYPosition() {
        return enemyMaximumYPosition;
    }

    /**
     * Gets the screen width.
     *
     * @return the screen width
     */
    protected double getScreenWidth() {
        return screenWidth;
    }

    /**
     * Gets the screen height.
     *
     * @return the screen height
     */
    protected double getScreenHeight() {
        return screenHeight;
    }

    /**
     * Checks if the user plane is destroyed.
     *
     * @return true if the user plane is destroyed, false otherwise
     */
    protected boolean userIsDestroyed() {
        return user.isDestroyed();
    }

    /**
     * Gets the list of friendly units.
     *
     * @return the list of friendly units
     */
    protected List<ActiveActorDestructible> getFriendlyUnits() {
        return friendlyUnits;
    }

    /**
     * Gets the list of enemy units.
     *
     * @return the list of enemy units
     */
    protected List<ActiveActorDestructible> getEnemyUnits() {
        return enemyUnits;
    }

    /**
     * Gets the list of user projectiles.
     *
     * @return the list of user projectiles
     */
    protected List<ActiveActorDestructible> getUserProjectiles() {
        return userProjectiles;
    }

    /**
     * Gets the list of enemy projectiles.
     *
     * @return the list of enemy projectiles
     */
    protected List<ActiveActorDestructible> getEnemyProjectiles() {
        return enemyProjectiles;
    }

    /**
     * Updates the number of enemies.
     */
    private void updateNumberOfEnemies() {
        currentNumberOfEnemies = enemyUnits.size();
    }

    /**
     * Gets the timeline manager.
     *
     * @return the timeline manager
     */
    public TimelineManager getTimelineManager() {
        return timelineManager;
    }

    /**
     * Gets the timer manager.
     *
     * @return the timer manager
     */
    public TimerManager getTimerManager() {
        return timerManager;
    }

    /**
     * Gets the enemy manager.
     *
     * @return the enemy manager
     */
    public EnemyManager getEnemyManager() {
        return enemyManager;
    }

    /**
     * Gets the background manager.
     *
     * @return the background manager
     */
    public BackgroundManager getBackgroundManager() {
        return backgroundManager;
    }

    /**
     * Gets the scene.
     *
     * @return the scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Gets the projectile manager.
     *
     * @return the projectile manager
     */
    public ProjectileManager getProjectileManager() {
        return projectileManager;
    }
}