package com.example.demo.levels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.*;
import java.util.stream.Collectors;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.planes.FighterPlane;
import com.example.demo.actors.planes.UserPlane;
import com.example.demo.ui.PauseScreen;

import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * The LevelParent class is an abstract class that provides the common functionality
 * for all game levels, including managing the game loop, user input, and game state.
 */
public abstract class LevelParent {

    // Constants for screen adjustments and timing
    private static final double SCREEN_HEIGHT_ADJUSTMENT = 150;
    private static final int MILLISECOND_DELAY = 50;
    
    // Screen dimensions and enemy position limit
    private final double screenHeight;
    private final double screenWidth;
    private final double enemyMaximumYPosition;
    
    // Game state variables
    private boolean isPaused = false;

    // JavaFX components
    private final Group root;
    private final Timeline timeline;
    private final UserPlane user;
    private final Scene scene;
    private final ImageView background;

    // Lists to manage game actors
    private final List<ActiveActorDestructible> friendlyUnits;
    private final List<ActiveActorDestructible> enemyUnits;
    private final List<ActiveActorDestructible> userProjectiles;
    private final List<ActiveActorDestructible> enemyProjectiles;

    // Current number of enemies and level view
    private int currentNumberOfEnemies;
    private LevelView levelView;

    // Property to manage level transitions
    private final StringProperty levelProperty;
    
    // Status text for displaying game information
    protected final Text statusText; // Changed to protected

    /**
     * Constructor for LevelParent.
     * 
     * @param backgroundImageName The path to the background image.
     * @param screenHeight The height of the game screen.
     * @param screenWidth The width of the game screen.
     * @param playerInitialHealth The initial health of the player.
     */
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
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void initializeFriendlyUnits();
    protected abstract void checkIfGameOver();
    protected abstract void spawnEnemyUnits();
    protected abstract LevelView instantiateLevelView();

    /**
     * Initializes the scene with background, friendly units, heart display, and status text.
     * 
     * @return The initialized scene.
     */
    public Scene initializeScene() {
        initializeBackground();
        initializeFriendlyUnits();
        levelView.showHeartDisplay();
        addPauseButton();
        initializeStatusText();
        return scene;
    }

    /**
     * Starts the game by playing the timeline.
     */
    public void startGame() {
        background.requestFocus();
        getTimeline().play();
    }

    /**
     * Pauses the game and shows the pause screen.
     */
    public void pauseGame() {
        if (!isPaused) {
            getTimeline().pause();
            isPaused = true;
            showPauseScreen();
        }
    }

    /**
     * Resumes the game from a paused state.
     */
    public void resumeGame() {
        if (isPaused) {
            getTimeline().play();
            isPaused = false;
            background.requestFocus();  // Ensure focus is set back to the background
        }
    }

    /**
     * Shows the pause screen.
     */
    private void showPauseScreen() {
        PauseScreen pauseScreen = new PauseScreen((Stage) scene.getWindow(), this::resumeGame, this::showSettings);
        pauseScreen.show();
    }

    /**
     * Shows the settings screen (to be implemented).
     */
    private void showSettings() {
        // Implement settings logic here
    }

    /**
     * Transitions to the next level.
     * 
     * @param levelName The name of the next level.
     */
    public void goToNextLevel(String levelName) {
        levelProperty.set(levelName);
    }

    /**
     * Returns the level property for managing level transitions.
     * 
     * @return The level property.
     */
    public StringProperty levelProperty() {
        return levelProperty;
    }

    /**
     * Updates the scene by spawning enemies, updating actors, handling collisions, and checking game state.
     */
    private void updateScene() {
        if (!isPaused) {
            spawnEnemyUnits();
            updateActors();
            generateEnemyFire();
            updateNumberOfEnemies();
            handleEnemyPenetration();
            handleUserProjectileCollisions();
            handleEnemyProjectileCollisions();
            handlePlaneCollisions();
            removeAllDestroyedActors();
            updateKillCount();
            updateLevelView();
            checkIfGameOver();
            updateStatusText();
        }
    }

    /**
     * Initializes the game timeline with a game loop.
     */
    private void initializeTimeline() {
        getTimeline().setCycleCount(Timeline.INDEFINITE);
        KeyFrame gameLoop = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> updateScene());
        getTimeline().getKeyFrames().add(gameLoop);
    }

    /**
     * Initializes the background image and sets up key event handlers for user input.
     */
    private void initializeBackground() {
        background.setFocusTraversable(true);
        background.setFitHeight(screenHeight);
        background.setFitWidth(screenWidth);
        background.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                KeyCode kc = e.getCode();
                if (kc == KeyCode.UP) user.moveUp();
                if (kc == KeyCode.DOWN) user.moveDown();
                if (kc == KeyCode.LEFT) user.moveLeft();
                if (kc == KeyCode.RIGHT) user.moveRight();
                if (kc == KeyCode.SPACE) fireProjectile();
            }
        });
        background.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                KeyCode kc = e.getCode();
                if (kc == KeyCode.UP || kc == KeyCode.DOWN) user.stopVerticalMovement();
                if (kc == KeyCode.LEFT || kc == KeyCode.RIGHT) user.stopHorizontalMovement();
            }
        });
        root.getChildren().add(background);
    }

    /**
     * Fires a projectile from the user's plane and adds it to the scene and the list of user projectiles.
     */
    private void fireProjectile() {
        ActiveActorDestructible projectile = user.fireProjectile();
        root.getChildren().add(projectile);
        userProjectiles.add(projectile);
    }

    /**
     * Generates enemy fire by spawning projectiles from each enemy unit.
     */
    private void generateEnemyFire() {
        enemyUnits.forEach(enemy -> spawnEnemyProjectile(((FighterPlane) enemy).fireProjectile()));
    }

    /**
     * Spawns an enemy projectile and adds it to the scene and the list of enemy projectiles.
     * 
     * @param projectile The projectile to be spawned.
     */
    private void spawnEnemyProjectile(ActiveActorDestructible projectile) {
        if (projectile != null) {
            root.getChildren().add(projectile);
            enemyProjectiles.add(projectile);
        }
    }

    /**
     * Updates the state of all actors (friendly units, enemy units, and projectiles).
     */
    private void updateActors() {
        friendlyUnits.forEach(plane -> plane.updateActor());
        enemyUnits.forEach(enemy -> enemy.updateActor());
        userProjectiles.forEach(projectile -> projectile.updateActor());
        enemyProjectiles.forEach(projectile -> projectile.updateActor());
    }

    /**
     * Removes all destroyed actors from the scene and their respective lists.
     */
    private void removeAllDestroyedActors() {
        removeDestroyedActors(friendlyUnits);
        removeDestroyedActors(enemyUnits);
        removeDestroyedActors(userProjectiles);
        removeDestroyedActors(enemyProjectiles);
    }

    /**
     * Removes destroyed actors from a given list and the scene.
     * 
     * @param actors The list of actors to check for destruction.
     */
    private void removeDestroyedActors(List<ActiveActorDestructible> actors) {
        List<ActiveActorDestructible> destroyedActors = actors.stream()
            .filter(ActiveActorDestructible::isDestroyed)
            .collect(Collectors.toList());
        root.getChildren().removeAll(destroyedActors);
        actors.removeAll(destroyedActors);
    }

    /**
     * Handles collisions between friendly units and enemy units.
     */
    private void handlePlaneCollisions() {
        handleCollisions(friendlyUnits, enemyUnits);
    }

    /**
     * Handles collisions between user projectiles and enemy units.
     */
    private void handleUserProjectileCollisions() {
        handleCollisions(userProjectiles, enemyUnits);
    }

    /**
     * Handles collisions between enemy projectiles and friendly units.
     */
    private void handleEnemyProjectileCollisions() {
        handleCollisions(enemyProjectiles, friendlyUnits);
    }

    /**
     * Handles collisions between two lists of actors.
     * 
     * @param actors1 The first list of actors.
     * @param actors2 The second list of actors.
     */
    private void handleCollisions(List<ActiveActorDestructible> actors1, List<ActiveActorDestructible> actors2) {
        for (ActiveActorDestructible actor : actors2) {
            for (ActiveActorDestructible otherActor : actors1) {
                if (actor.getBoundsInParent().intersects(otherActor.getBoundsInParent())) {
                    actor.takeDamage();
                    otherActor.takeDamage();
                }
            }
        }
    }

    /**
     * Handles enemy penetration by checking if any enemy has passed the user's defenses.
     */
    private void handleEnemyPenetration() {
        for (ActiveActorDestructible enemy : enemyUnits) {
            if (enemyHasPenetratedDefenses(enemy)) {
                user.takeDamage();
                enemy.destroy();
            }
        }
    }

    /**
     * Updates the level view to reflect the user's remaining health.
     */
    private void updateLevelView() {
        levelView.removeHearts(user.getHealth());
    }

    /**
     * Updates the user's kill count based on the number of enemies destroyed.
     */
    private void updateKillCount() {
        for (int i = 0; i < currentNumberOfEnemies - enemyUnits.size(); i++) {
            user.incrementKillCount();
        }
    }

    /**
     * Checks if an enemy has penetrated the user's defenses.
     * 
     * @param enemy The enemy to check.
     * @return True if the enemy has penetrated the defenses, false otherwise.
     */
    private boolean enemyHasPenetratedDefenses(ActiveActorDestructible enemy) {
        return Math.abs(enemy.getTranslateX()) > screenWidth;
    }

    /**
     * Stops the game timeline and handles the win game scenario.
     */
    protected void winGame() {
        getTimeline().stop();
        // Removed: levelView.showWinImage();
    }

    /**
     * Stops the game timeline and shows the game over image.
     */
    protected void loseGame() {
        getTimeline().stop();
        levelView.showGameOverImage();
    }

    /**
     * Returns the user's plane.
     * 
     * @return The user's plane.
     */
    protected UserPlane getUser() {
        return user;
    }

    /**
     * Returns the root group of the scene.
     * 
     * @return The root group.
     */
    protected Group getRoot() {
        return root;
    }

    /**
     * Returns the current number of enemies.
     * 
     * @return The current number of enemies.
     */
    protected int getCurrentNumberOfEnemies() {
        return enemyUnits.size();
    }

    /**
     * Adds an enemy unit to the scene and the list of enemy units.
     * 
     * @param enemy The enemy unit to add.
     */
    protected void addEnemyUnit(ActiveActorDestructible enemy) {
        enemyUnits.add(enemy);
        root.getChildren().add(enemy);
    }

    /**
     * Returns the maximum Y position for enemy units.
     * 
     * @return The maximum Y position for enemy units.
     */
    protected double getEnemyMaximumYPosition() {
        return enemyMaximumYPosition;
    }

    /**
     * Returns the width of the screen.
     * 
     * @return The width of the screen.
     */
    protected double getScreenWidth() {
        return screenWidth;
    }

    /**
     * Returns the height of the screen.
     * 
     * @return The height of the screen.
     */
    protected double getScreenHeight() {
        return screenHeight;
    }

    /**
     * Checks if the user's plane is destroyed.
     * 
     * @return True if the user's plane is destroyed, false otherwise.
     */
    protected boolean userIsDestroyed() {
        return user.isDestroyed();
    }

    /**
     * Updates the current number of enemies.
     */
    private void updateNumberOfEnemies() {
        currentNumberOfEnemies = enemyUnits.size();
    }

    /**
     * Removes the pause menu from the scene.
     * 
     * @param pauseMenu The pause menu to remove.
     */
    public void removePauseMenu(VBox pauseMenu) {
        root.getChildren().remove(pauseMenu);
    }

    /**
     * Adds the pause menu to the scene.
     * 
     * @param pauseMenu The pause menu to add.
     */
    public void addPauseMenu(VBox pauseMenu) {
        root.getChildren().add(pauseMenu);
    }

    /**
     * Adds a pause button to the scene.
     */
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

    /**
     * Initializes the status text and adds it to the scene.
     */
    private void initializeStatusText() {
        statusText.setLayoutY(20); // Default vertical position
        statusText.setStyle("-fx-font-size: 20px; -fx-fill: black; -fx-font-family: 'Impact';");
        root.getChildren().add(statusText);
        centerStatusText();
        
        // Add a listener to update the position whenever the text changes
        statusText.textProperty().addListener((observable, oldValue, newValue) -> centerStatusText());
    }

    /**
     * Sets the position of the status text.
     * 
     * @param x The X position.
     * @param y The Y position.
     */
    protected void setStatusTextPosition(double x, double y) {
        statusText.setLayoutX(x);
        statusText.setLayoutY(y);
    }

    /**
     * Centers the status text horizontally within the scene.
     */
    private void centerStatusText() {
        double centerX = (screenWidth / 2) - (statusText.getBoundsInLocal().getWidth() / 2);
        setStatusTextPosition(centerX, 20);
    }

    /**
     * Updates the status text. This method will be overridden in subclasses.
     */
    protected void updateStatusText() {
        // This method will be overridden in subclasses to update the status text
    }

    /**
     * Returns the game timeline.
     * 
     * @return The game timeline.
     */
    public Timeline getTimeline() {
        return timeline;
    }
}
