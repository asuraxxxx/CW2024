package com.example.demo.managers;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.ImageView;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.planes.UserPlane;

public class InputManager {

    private final UserPlane user;
    private final ImageView background;
    private final ProjectileFiredListener projectileFiredListener;

    public InputManager(UserPlane user, ImageView background, ProjectileFiredListener projectileFiredListener) {
        this.user = user;
        this.background = background;
        this.projectileFiredListener = projectileFiredListener;
        initializeKeyHandlers();
    }

    private void initializeKeyHandlers() {
        background.setFocusTraversable(true);
        background.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                KeyCode kc = e.getCode();
                if (kc == KeyCode.UP) user.moveUp();
                if (kc == KeyCode.DOWN) user.moveDown();
                if (kc == KeyCode.LEFT) user.moveLeft();
                if (kc == KeyCode.RIGHT) user.moveRight();
                if (kc == KeyCode.SPACE) {
                    projectileFiredListener.onProjectileFired(user.fireProjectile());
                }
            }
        });
        background.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                KeyCode kc = e.getCode();
                if (kc == KeyCode.UP || kc == KeyCode.DOWN) user.stopVerticalMovement();
                if (kc == KeyCode.LEFT || kc == KeyCode.RIGHT) user.stopHorizontalMovement();
            }
        });
    }

    public interface ProjectileFiredListener {
        void onProjectileFired(ActiveActorDestructible projectile);
    }
}