package com.example.demo;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class UserPlane extends FighterPlane {

    private static final String IMAGE_NAME = "userplane.png";
    private static final double Y_UPPER_BOUND = -40;
    private static final double Y_LOWER_BOUND = 600.0;
    private static final double X_LEFT_BOUND = 0.0;
    private static final double X_RIGHT_BOUND = 800.0; // Adjust as needed for your scene width
    private static final double INITIAL_X_POSITION = 5.0;
    private static final double INITIAL_Y_POSITION = 300.0;
    private static final int IMAGE_HEIGHT = 150;
    private static final int VERTICAL_VELOCITY = 8;
    private static final int HORIZONTAL_VELOCITY = 8;
    private static final int PROJECTILE_X_POSITION = 110;
    private static final int PROJECTILE_Y_POSITION_OFFSET = 20;
    private int verticalVelocityMultiplier;
    private int horizontalVelocityMultiplier;
    private int numberOfKills;
    private Rectangle hitbox;

    public UserPlane(int initialHealth) {
        super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, INITIAL_Y_POSITION, initialHealth);
        verticalVelocityMultiplier = 0;
        horizontalVelocityMultiplier = 0;
        hitbox = new Rectangle();
        hitbox.setStroke(Color.RED);
        hitbox.setFill(Color.TRANSPARENT);
        updateHitbox();
    }
    
    @Override
    public void updatePosition() {
        if (isMovingVertically()) {
            double initialTranslateY = getTranslateY();
            this.moveVertically(VERTICAL_VELOCITY * verticalVelocityMultiplier);
            double newPositionY = getLayoutY() + getTranslateY();
            if (newPositionY < Y_UPPER_BOUND || newPositionY > Y_LOWER_BOUND) {
                this.setTranslateY(initialTranslateY);
            }
        }
        if (isMovingHorizontally()) {
            double initialTranslateX = getTranslateX();
            this.moveHorizontally(HORIZONTAL_VELOCITY * horizontalVelocityMultiplier);
            double newPositionX = getLayoutX() + getTranslateX();
            if (newPositionX < X_LEFT_BOUND || newPositionX > X_RIGHT_BOUND) {
                this.setTranslateX(initialTranslateX);
            }
        }
        updateHitbox();
    }
    
    @Override
    public void updateActor() {
        updatePosition();
    }
    
    @Override
    public ActiveActorDestructible fireProjectile() {
        return new UserProjectile(PROJECTILE_X_POSITION, getProjectileYPosition(PROJECTILE_Y_POSITION_OFFSET));
    }

    private boolean isMovingVertically() {
        return verticalVelocityMultiplier != 0;
    }

    private boolean isMovingHorizontally() {
        return horizontalVelocityMultiplier != 0;
    }

    public void moveUp() {
        verticalVelocityMultiplier = -1;
    }

    public void moveDown() {
        verticalVelocityMultiplier = 1;
    }

    public void moveLeft() {
        horizontalVelocityMultiplier = -1;
    }

    public void moveRight() {
        horizontalVelocityMultiplier = 1;
    }

    public void stopVerticalMovement() {
        verticalVelocityMultiplier = 0;
    }

    public void stopHorizontalMovement() {
        horizontalVelocityMultiplier = 0;
    }

    public int getNumberOfKills() {
        return numberOfKills;
    }

    public void incrementKillCount() {
        numberOfKills++;
    }

    public Bounds getCustomBounds() {
        double hitboxWidth = getFitWidth() * 0.3; // 30% of the original width
        double hitboxHeight = getFitHeight() * 0.3; // 30% of the original height
        double offsetX = (getFitWidth() - hitboxWidth) / 2;
        double offsetY = (getFitHeight() - hitboxHeight) / 2;
        return new Rectangle(getLayoutX() + offsetX, getLayoutY() + offsetY, hitboxWidth, hitboxHeight).getBoundsInParent();
    }

    private void updateHitbox() {
        Bounds bounds = getCustomBounds();
        hitbox.setX(bounds.getMinX());
        hitbox.setY(bounds.getMinY());
        hitbox.setWidth(bounds.getWidth());
        hitbox.setHeight(bounds.getHeight());
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
}