package com.example.demo.levels;

import com.example.demo.actors.planes.BossPlane;
import com.example.demo.factories.LevelViewFactory;
import com.example.demo.ui.images.ShieldImage;
import com.example.demo.ui.WinGameScreen;
import javafx.stage.Stage;
import com.example.demo.actors.ActiveActorDestructible;

/**
 * The LevelBoss class represents the boss level in the game.
 * It extends the LevelParent class and includes specific logic for managing the boss plane and its shield.
 */
public class LevelBoss extends LevelParent {

    private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/background2.jpg";
    private static final int PLAYER_INITIAL_HEALTH = 5;

    private final BossPlane boss;
    private final ShieldImage shieldImage;

    /**
     * Constructs a LevelBoss with specified screen dimensions.
     *
     * @param screenHeight The height of the game screen.
     * @param screenWidth The width of the game screen.
     */
    public LevelBoss(double screenHeight, double screenWidth) {
        super(BACKGROUND_IMAGE_NAME, screenHeight, screenWidth, PLAYER_INITIAL_HEALTH);

        shieldImage = new ShieldImage(0, 0);
        boss = new BossPlane(shieldImage);

        double xOffset = 30;
        double yOffset = 150;

        shieldImage.layoutXProperty().bind(
            boss.layoutXProperty()
            .add(boss.translateXProperty())
            .subtract(ShieldImage.SHIELD_SIZE / 2)
            .add(xOffset)
        );

        shieldImage.layoutYProperty().bind(
            boss.layoutYProperty()
            .add(boss.translateYProperty())
            .subtract(ShieldImage.SHIELD_SIZE / 2)
            .add(yOffset)
        );

        getTimerManager().startTimer(); // Start the timer when the level begins
    }

    /**
     * Initializes the friendly units in the level, including the user plane and shield image.
     */
    @Override
    protected void initializeFriendlyUnits() {
        getRoot().getChildren().add(getUser());
        getRoot().getChildren().add(shieldImage);
    }

    /**
     * Checks if the game is over by evaluating the state of the user and boss planes.
     * Stops the timer and transitions to the appropriate end game screen.
     */
    @Override
    protected void checkIfGameOver() {
        if (userIsDestroyed()) {
            getTimerManager().stopTimer(); // Stop the timer when the level ends
            loseGame();
        } else if (boss.isDestroyed()) {
            getTimerManager().stopTimer(); // Stop the timer when the level ends
            getTimerManager().storeLevelTime(3); // Store the time for level three
            winGame();
        }
    }

    /**
     * Spawns enemy units in the level, specifically the boss plane.
     */
    @Override
    protected void spawnEnemyUnits() {
        if (getCurrentNumberOfEnemies() == 0) {
            addEnemyUnit(boss);
        }
    }

    /**
     * Instantiates the level view for the boss level.
     *
     * @return The instantiated LevelBossView.
     */
    @Override
    protected LevelBossView instantiateLevelView() {
        return (LevelBossView) LevelViewFactory.createLevelView("LevelBossView", getRoot(), PLAYER_INITIAL_HEALTH);
    }

    /**
     * Updates the status text to display the remaining health of the boss.
     */
    @Override
    protected void updateStatusText() {
        int bossHealth = Math.max(boss.getHealth(), 0);
        statusManager.updateStatusText("Remaining boss health: " + bossHealth);
    }

    /**
     * Handles the win game scenario by stopping the timeline and displaying the win game screen.
     */
    @Override
    protected void winGame() {
        getTimelineManager().stop();
        Stage stage = (Stage) getRoot().getScene().getWindow();
        WinGameScreen winGameScreen = new WinGameScreen(stage, getTimerManager().getTotalTime());
        winGameScreen.show();
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