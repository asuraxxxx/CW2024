package com.example.demo.levels;

import com.example.demo.actors.planes.BossPlane;
import com.example.demo.ui.images.ShieldImage;
import com.example.demo.ui.WinGameScreen;
import javafx.stage.Stage;

public class LevelBoss extends LevelParent {

    private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/background2.jpg";
    private static final int PLAYER_INITIAL_HEALTH = 5;
    private final BossPlane boss;
    private final ShieldImage shieldImage;
    private LevelBossView levelView;

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

    @Override
    protected void initializeFriendlyUnits() {
        getRoot().getChildren().add(getUser());
        getRoot().getChildren().add(shieldImage);
    }

    @Override
    protected void checkIfGameOver() {
        if (userIsDestroyed()) {
            loseGame();
        } else if (boss.isDestroyed()) {
            winGame();
        }
    }

    @Override
    protected void spawnEnemyUnits() {
        if (getCurrentNumberOfEnemies() == 0) {
            addEnemyUnit(boss);
        }
    }

    @Override
    protected LevelBossView instantiateLevelView() {
        levelView = new LevelBossView(getRoot(), PLAYER_INITIAL_HEALTH);
        return levelView;
    }

    @Override
    protected void updateStatusText() {
        statusText.setText("Remaining boss health: " + boss.getHealth());
    }

    @Override
    protected void winGame() {
        getTimeline().stop();
        Stage stage = (Stage) getRoot().getScene().getWindow();
        WinGameScreen winGameScreen = new WinGameScreen(stage);
        winGameScreen.show();
    }
}