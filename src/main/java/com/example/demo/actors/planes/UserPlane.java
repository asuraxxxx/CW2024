package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.projectiles.UserProjectile;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class UserPlane extends FighterPlane {
    private int verticalVelocityMultiplier;
    private int horizontalVelocityMultiplier;
    private int numberOfKills;
    private Rectangle hitbox;

    public UserPlane(int initialHealth) {
        super("userplane.png", 150, 5.0, 300.0, initialHealth);
        verticalVelocityMultiplier = 0;
        horizontalVelocityMultiplier = 0;
        hitbox = new Rectangle();
        hitbox.setStroke(Color.RED);
        hitbox.setFill(Color.TRANSPARENT);
        updateHitbox();
    }

    @Override
    public void updatePosition() {
        if (verticalVelocityMultiplier != 0) {
            double initialTranslateY = getTranslateY();
            moveVertically(8 * verticalVelocityMultiplier);
            double newPositionY = getLayoutY() + getTranslateY();
            if (newPositionY < -40 || newPositionY > 600.0) {
                setTranslateY(initialTranslateY);
            }
        }
        if (horizontalVelocityMultiplier != 0) {
            double initialTranslateX = getTranslateX();
            moveHorizontally(8 * horizontalVelocityMultiplier);
            double newPositionX = getLayoutX() + getTranslateX();
            if (newPositionX < 0.0 || newPositionX > 800.0) {
                setTranslateX(initialTranslateX);
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
        return new UserProjectile(110, getProjectileYPosition(20));
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
        double hitboxWidth = getFitWidth() * 0.3;
        double hitboxHeight = getFitHeight() * 0.3;
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