package com.example.demo.levels;

import com.example.demo.actors.planes.BossPlane;
import com.example.demo.ui.images.ShieldImage;
import com.example.demo.ui.WinGameScreen;
import javafx.stage.Stage;
import com.example.demo.actors.ActiveActorDestructible;

public class LevelBoss extends LevelParent {

    private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/background2.jpg";
    private static final int PLAYER_INITIAL_HEALTH = 5;

    private final BossPlane boss;
    private final ShieldImage shieldImage;
    private LevelBossView levelView;

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

    @Override
    protected void initializeFriendlyUnits() {
        getRoot().getChildren().add(getUser());
        getRoot().getChildren().add(shieldImage);
    }

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
        int bossHealth = Math.max(boss.getHealth(), 0);
        statusManager.updateStatusText("Remaining boss health: " + bossHealth);
    }

    @Override
    protected void winGame() {
        getTimelineManager().stop();
        Stage stage = (Stage) getRoot().getScene().getWindow();
        WinGameScreen winGameScreen = new WinGameScreen(stage, getTimerManager().getTotalTime());
        winGameScreen.show();
    }

    @Override
    public void onProjectileFired(ActiveActorDestructible projectile) {
        getProjectileManager().onProjectileFired(projectile);
    }
}