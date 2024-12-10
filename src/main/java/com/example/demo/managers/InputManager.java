package com.example.demo.managers;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.ImageView;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.planes.UserPlane;

/**
 * The InputManager class manages user input for controlling the user plane and firing projectiles.
 */
public class InputManager {

    private final UserPlane user;
    private final ImageView background;
    private final ProjectileFiredListener projectileFiredListener;

    /**
     * Constructs a new InputManager.
     *
     * @param user the user plane
     * @param background the background image view
     * @param projectileFiredListener the listener for projectile firing events
     */
    public InputManager(UserPlane user, ImageView background, ProjectileFiredListener projectileFiredListener) {
        this.user = user;
        this.background = background;
        this.projectileFiredListener = projectileFiredListener;
        initializeKeyHandlers();
    }

    /**
     * Initializes key handlers for user input managed by InputManager.
     */
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

    /**
     * Interface for listening to projectile firing events.
     */
    public interface ProjectileFiredListener {
        void onProjectileFired(ActiveActorDestructible projectile);
    }
}