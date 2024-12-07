package com.example.demo.levels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.*;
import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.planes.FighterPlane;
import com.example.demo.actors.planes.UserPlane;
import com.example.demo.managers.ActorManager;
import com.example.demo.managers.CollisionManager;
import com.example.demo.managers.InputManager;
import com.example.demo.ui.PauseScreen;
import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public abstract class LevelParent implements InputManager.ProjectileFiredListener {

    private static final double SCREEN_HEIGHT_ADJUSTMENT = 150;
    private static final int MILLISECOND_DELAY = 50;
    
    private final double screenHeight;
    private final double screenWidth;
    private final double enemyMaximumYPosition;
    
    private boolean isPaused = false;

    private final Group root;
    private final Timeline timeline;
    private final UserPlane user;
    private final Scene scene;
    private final ImageView background;

    private final List<ActiveActorDestructible> friendlyUnits;
    private final List<ActiveActorDestructible> enemyUnits;
    private final List<ActiveActorDestructible> userProjectiles;
    private final List<ActiveActorDestructible> enemyProjectiles;

    private int currentNumberOfEnemies;
    private LevelView levelView;

    private final StringProperty levelProperty;
    
    protected final Text statusText;

    public InputManager inputHandler;

    private final ActorManager actorManager;
    private final CollisionManager collisionManager;

    public LevelParent(String backgroundImageName, double screenHeight, double screenWidth, int playerInitialHealth) {
        this.root = new Group();
        this.scene = new Scene(root, screenWidth, screenHeight);
        this.timeline = new Timeline();
        this.user = new UserPlane(playerInitialHealth);
        this.friendlyUnits = new ArrayList<>();
        this.enemyUnits = new ArrayList<>();
        this.userProjectiles = new ArrayList<>();
        this.enemyProjectiles = new ArrayList<>();

        this.background = new ImageView(new Image(getClass().getResource(backgroundImageName).toExternalForm()));
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.enemyMaximumYPosition = screenHeight - SCREEN_HEIGHT_ADJUSTMENT;
        this.levelView = instantiateLevelView();
        this.currentNumberOfEnemies = 0;
        this.levelProperty = new SimpleStringProperty();
        this.statusText = new Text();
        initializeTimeline();
        friendlyUnits.add(user);

        this.inputHandler = new InputManager(user, background, this);
        this.actorManager = new ActorManager(root, friendlyUnits, enemyUnits, userProjectiles, enemyProjectiles);
        this.collisionManager = new CollisionManager();
    }

    protected abstract void initializeFriendlyUnits();
    protected abstract void checkIfGameOver();
    protected abstract void spawnEnemyUnits();
    protected abstract LevelView instantiateLevelView();

    public Scene initializeScene() {
        initializeBackground();
        initializeFriendlyUnits();
        levelView.showHeartDisplay();
        addPauseButton();
        initializeStatusText();
        return scene;
    }

    public void startGame() {
        background.requestFocus();
        getTimeline().play();
    }

    public void pauseGame() {
        if (!isPaused) {
            getTimeline().pause();
            isPaused = true;
            showPauseScreen();
        }
    }

    public void resumeGame() {
        if (isPaused) {
            getTimeline().play();
            isPaused = false;
            background.requestFocus();
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
            generateEnemyFire();
            updateNumberOfEnemies();
            handleEnemyPenetration();
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

    private void initializeTimeline() {
        getTimeline().setCycleCount(Timeline.INDEFINITE);
        KeyFrame gameLoop = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> updateScene());
        getTimeline().getKeyFrames().add(gameLoop);
    }

    private void initializeBackground() {
        background.setFitHeight(screenHeight);
        background.setFitWidth(screenWidth);
        root.getChildren().add(background);
    }

    private void generateEnemyFire() {
        enemyUnits.forEach(enemy -> spawnEnemyProjectile(((FighterPlane) enemy).fireProjectile()));
    }

    private void spawnEnemyProjectile(ActiveActorDestructible projectile) {
        if (projectile != null) {
            root.getChildren().add(projectile);
            enemyProjectiles.add(projectile);
        }
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
        getTimeline().stop();
        // Removed: levelView.showWinImage();
    }

    protected void loseGame() {
        getTimeline().stop();
        levelView.showGameOverImage();
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

    private void initializeStatusText() {
        statusText.setLayoutY(20);
        statusText.setStyle("-fx-font-size: 20px; -fx-fill: black; -fx-font-family: 'Impact';");
        root.getChildren().add(statusText);
        centerStatusText();
        
        statusText.textProperty().addListener((observable, oldValue, newValue) -> centerStatusText());
    }

    protected void setStatusTextPosition(double x, double y) {
        statusText.setLayoutX(x);
        statusText.setLayoutY(y);
    }
    
    private void centerStatusText() {
        double centerX = (screenWidth / 2) - (statusText.getBoundsInLocal().getWidth() / 2);
        setStatusTextPosition(centerX, 20);
    }

    protected void updateStatusText() {
        // This method will be overridden in subclasses to update the status text
    }

    public Timeline getTimeline() {
        return timeline;
    }

    @Override
    public void onProjectileFired(ActiveActorDestructible projectile) {
        if (projectile != null) {
            root.getChildren().add(projectile);
            userProjectiles.add(projectile);
        }
    }
}