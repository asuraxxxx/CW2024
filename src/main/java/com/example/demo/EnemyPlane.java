package com.example.demo;

import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;

public class EnemyPlane extends FighterPlane {

    private static final String IMAGE_NAME = "enemyplane.png";
    private static final int IMAGE_HEIGHT = 150;
    private static final int HORIZONTAL_VELOCITY = -6;
    private static final double PROJECTILE_X_POSITION_OFFSET = -100.0;
    private static final double PROJECTILE_Y_POSITION_OFFSET = 50.0;
    private static final int INITIAL_HEALTH = 1;
    private static final double FIRE_RATE = .01;

    public EnemyPlane(double initialXPos, double initialYPos) {
        super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos, INITIAL_HEALTH);
    }

    @Override
    public void updatePosition() {
        moveHorizontally(HORIZONTAL_VELOCITY);
    }

    @Override
    public ActiveActorDestructible fireProjectile() {
        if (Math.random() < FIRE_RATE) {
            double projectileXPosition = getProjectileXPosition(PROJECTILE_X_POSITION_OFFSET);
            double projectileYPostion = getProjectileYPosition(PROJECTILE_Y_POSITION_OFFSET);
            return new EnemyProjectile(projectileXPosition, projectileYPostion);
        }
        return null;
    }

    @Override
    public void updateActor() {
        updatePosition();
    }

    public Bounds getCustomBounds() {
        double hitboxWidth = getFitWidth() * 0.3; // 30% of the original width
        double hitboxHeight = getFitHeight() * 0.3; // 30% of the original height
        double offsetX = (getFitWidth() - hitboxWidth) / 2;
        double offsetY = (getFitHeight() - hitboxHeight) / 2;
        return new Rectangle(getLayoutX() + offsetX, getLayoutY() + offsetY, hitboxWidth, hitboxHeight).getBoundsInParent();
    }
}
