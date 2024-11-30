package com.example.demo.levels;

import com.example.demo.actors.planes.BossPlane;
import com.example.demo.ui.images.ShieldImage;
import com.example.demo.ui.WinGameScreen;
import javafx.stage.Stage;

/**
 * The LevelBoss class represents the boss level in the game.
 * It extends LevelParent and manages the boss plane and its shield.
 */
public class LevelBoss extends LevelParent {

    // Path to the background image for the boss level
    private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/background2.jpg";
    
    // Initial health of the player
    private static final int PLAYER_INITIAL_HEALTH = 5;
    
    // Boss plane and its shield image
    private final BossPlane boss;
    private final ShieldImage shieldImage;
    
    // View for the boss level
    private LevelBossView levelView;

    /**
     * Constructor for LevelBoss.
     * 
     * @param screenHeight The height of the game screen.
     * @param screenWidth The width of the game screen.
     */
    public LevelBoss(double screenHeight, double screenWidth) {
        super(BACKGROUND_IMAGE_NAME, screenHeight, screenWidth, PLAYER_INITIAL_HEALTH);

        // Initialize the shield image at (0,0)
        shieldImage = new ShieldImage(0, 0);
        boss = new BossPlane(shieldImage);

        // Adjust the position of the shield image
        double xOffset = 30;  // Adjusted value to move the shield more to the left
        double yOffset = 150; // Keep this value as needed

        // Match the shield's X position with the boss plane's X position
        shieldImage.layoutXProperty().bind(
            boss.layoutXProperty()
            .add(boss.translateXProperty())
            .subtract(ShieldImage.SHIELD_SIZE / 2)
            .add(xOffset)
        );

        // Match the shield's Y position with the boss plane's Y position
        shieldImage.layoutYProperty().bind(
            boss.layoutYProperty()
            .add(boss.translateYProperty())
            .subtract(ShieldImage.SHIELD_SIZE / 2)
            .add(yOffset)
        );
    }

    /**
     * Initializes friendly units in the game, including the user and the shield image.
     */
    @Override
    protected void initializeFriendlyUnits() {
        getRoot().getChildren().add(getUser());
        getRoot().getChildren().add(shieldImage);
    }

    /**
     * Checks if the game is over by verifying if the user or the boss is destroyed.
     */
    @Override
    protected void checkIfGameOver() {
        if (userIsDestroyed()) {
            loseGame();
        } else if (boss.isDestroyed()) {
            winGame();
        }
    }

    /**
     * Spawns enemy units, specifically the boss plane, if no enemies are present.
     */
    @Override
    protected void spawnEnemyUnits() {
        if (getCurrentNumberOfEnemies() == 0) {
            addEnemyUnit(boss);
        }
    }

    /**
     * Instantiates the view for the boss level.
     * 
     * @return The LevelBossView instance.
     */
    @Override
    protected LevelBossView instantiateLevelView() {
        levelView = new LevelBossView(getRoot(), PLAYER_INITIAL_HEALTH);
        return levelView;
    }

    /**
     * Updates the status text to show the remaining health of the boss.
     */
    @Override
    protected void updateStatusText() {
        statusText.setText("Remaining boss health: " + boss.getHealth());
    }

    /**
     * Handles the actions to be taken when the player wins the game.
     */
    @Override
    protected void winGame() {
        getTimeline().stop();
        Stage stage = (Stage) getRoot().getScene().getWindow();
        WinGameScreen winGameScreen = new WinGameScreen(stage);
        winGameScreen.show();
    }
}