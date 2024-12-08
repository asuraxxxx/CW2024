package com.example.demo.levels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.*;
import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.planes.UserPlane;
import com.example.demo.managers.*;
import com.example.demo.ui.PauseScreen;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class LevelParent implements InputManager.ProjectileFiredListener {

    private static final double SCREEN_HEIGHT_ADJUSTMENT = 150;

    private final double screenHeight;
    private final double screenWidth;
    private final double enemyMaximumYPosition;

    private boolean isPaused = false;

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
    }

    protected abstract void initializeFriendlyUnits();
    protected abstract void checkIfGameOver();
    protected abstract void spawnEnemyUnits();
    protected abstract LevelView instantiateLevelView();
    protected abstract void updateStatusText(); // Abstract method for subclasses to implement

    public Scene initializeScene() {
        initializeBackground();
        initializeFriendlyUnits();
        levelView.showHeartDisplay();
        addPauseButton();
        return scene;
    }

    public void startGame() {
        backgroundManager.getBackground().requestFocus();
        timelineManager.start();
    }

    public void pauseGame() {
        if (!isPaused) {
            timelineManager.pause();
            isPaused = true;
            showPauseScreen();
        }
    }

    public void resumeGame() {
        if (isPaused) {
            timelineManager.resume();
            isPaused = false;
            backgroundManager.getBackground().requestFocus();
        }
    }

    private void showPauseScreen() {
        PauseScreen pauseScreen = new PauseScreen((Stage) scene.getWindow(), this::resumeGame, this::showSettings);
        pauseScreen.show();
    }

    private void showSettings() {
        // Implement settings logic here
    }

    public void goToNextLevel(String levelName) {
        levelProperty.set(levelName);
    }

    public StringProperty levelProperty() {
        return levelProperty;
    }

    private void updateScene() {
        if (!isPaused) {
            spawnEnemyUnits();
            actorManager.updateActors();
            projectileManager.generateEnemyFire(enemyUnits);
            updateNumberOfEnemies();
            handleEnemyPenetration();
            collisionManager.handleCollisions(userProjectiles, enemyUnits);
            collisionManager.handleCollisions(enemyProjectiles, friendlyUnits);
            collisionManager.handleCollisions(friendlyUnits, enemyUnits);
            actorManager.removeAllDestroyedActors();
            updateKillCount();
            updateLevelView();
            checkIfGameOver();
            updateStatusText(); // Call the abstract method
        }
    }

    private void initializeBackground() {
        backgroundManager.addToRoot(root);
    }

    private void handleEnemyPenetration() {
        for (ActiveActorDestructible enemy : enemyUnits) {
            if (enemyHasPenetratedDefenses(enemy)) {
                user.takeDamage();
                enemy.destroy();
            }
        }
    }

    private void updateLevelView() {
        levelView.removeHearts(user.getHealth());
    }

    private void updateKillCount() {
        for (int i = 0; i < currentNumberOfEnemies - enemyUnits.size(); i++) {
            user.incrementKillCount();
        }
    }

    private boolean enemyHasPenetratedDefenses(ActiveActorDestructible enemy) {
        return Math.abs(enemy.getTranslateX()) > screenWidth;
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

    private void updateNumberOfEnemies() {
        currentNumberOfEnemies = enemyUnits.size();
    }

    public void removePauseMenu(VBox pauseMenu) {
        root.getChildren().remove(pauseMenu);
    }

    public void addPauseMenu(VBox pauseMenu) {
        root.getChildren().add(pauseMenu);
    }

    private void addPauseButton() {
        Image pauseImage = new Image(getClass().getResource("/com/example/demo/images/pausescreenbutton.png").toExternalForm());
        ImageView pauseImageView = new ImageView(pauseImage);
        pauseImageView.setFitWidth(50);
        pauseImageView.setFitHeight(50);

        Button pauseButton = new Button();
        pauseButton.setGraphic(pauseImageView);
        pauseButton.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        pauseButton.setLayoutX(screenWidth - 100);
        pauseButton.setLayoutY(20);
        pauseButton.setOnAction(e -> pauseGame());
        root.getChildren().add(pauseButton);
    }

    protected void setStatusTextPosition(double x, double y) {
        statusManager.setStatusTextPosition(x, y);
    }

    protected void updateStatusText(String newText) {
        statusManager.updateStatusText(newText);
    }

    @Override
    public void onProjectileFired(ActiveActorDestructible projectile) {
        projectileManager.onProjectileFired(projectile);
    }

    public TimelineManager getTimelineManager() {
        return timelineManager;
    }
}