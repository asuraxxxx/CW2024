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
    private final PauseManager pauseManager; // Add PauseManager instance

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
        this.pauseManager = new PauseManager(this, root); // Initialize PauseManager
    }

    protected abstract void initializeFriendlyUnits();
    protected abstract void checkIfGameOver();
    protected abstract void spawnEnemyUnits();
    protected abstract LevelView instantiateLevelView();
    protected abstract void updateStatusText();

    public Scene initializeScene() {
        initializeBackground();
        initializeFriendlyUnits();
        levelView.showHeartDisplay();
        pauseManager.addPauseButton(screenWidth); // Use PauseManager to add pause button
        return scene;
    }

    public void startGame() {
        backgroundManager.getBackground().requestFocus();
        timelineManager.start();
        timerManager.startTimer();
    }

    public void goToNextLevel(String levelName) {
        levelProperty.set(levelName);
    }

    public StringProperty levelProperty() {
        return levelProperty;
    }

    private void updateScene() {
        if (!pauseManager.isPaused()) { // Check pause state from PauseManager
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

    private void initializeBackground() {
        backgroundManager.addToRoot(root);
    }

    private void updateLevelView() {
        levelView.removeHearts(user.getHealth());
    }

    private void updateKillCount() {
        for (int i = 0; i < currentNumberOfEnemies - enemyUnits.size(); i++) {
            user.incrementKillCount();
        }
    }

    protected void winGame() {
        gameStateManager.winGame();
    }

    protected void loseGame() {
        gameStateManager.loseGame();
    }

    protected UserPlane getUser() {
        return user;
    }

    protected Group getRoot() {
        return root;
    }

    protected int getCurrentNumberOfEnemies() {
        return enemyUnits.size();
    }

    protected void addEnemyUnit(ActiveActorDestructible enemy) {
        enemyUnits.add(enemy);
        root.getChildren().add(enemy);
    }

    protected double getEnemyMaximumYPosition() {
        return enemyMaximumYPosition;
    }

    protected double getScreenWidth() {
        return screenWidth;
    }

    protected double getScreenHeight() {
        return screenHeight;
    }

    protected boolean userIsDestroyed() {
        return user.isDestroyed();
    }

    protected List<ActiveActorDestructible> getFriendlyUnits() {
        return friendlyUnits;
    }

    protected List<ActiveActorDestructible> getEnemyUnits() {
        return enemyUnits;
    }

    protected List<ActiveActorDestructible> getUserProjectiles() {
        return userProjectiles;
    }

    protected List<ActiveActorDestructible> getEnemyProjectiles() {
        return enemyProjectiles;
    }

    private void updateNumberOfEnemies() {
        currentNumberOfEnemies = enemyUnits.size();
    }

    public TimelineManager getTimelineManager() {
        return timelineManager;
    }

    public TimerManager getTimerManager() {
        return timerManager;
    }

    public EnemyManager getEnemyManager() {
        return enemyManager;
    }

    public BackgroundManager getBackgroundManager() {
        return backgroundManager;
    }

    public Scene getScene() {
        return scene;
    }

    public ProjectileManager getProjectileManager() {
        return projectileManager;
    }
}