package com.example.demo.actors.planes;

import com.example.demo.actors.ShieldActivation;
import com.example.demo.strategies.movement.VerticalMovementStrategy;
import com.example.demo.actors.projectiles.BossProjectile;
import com.example.demo.ui.images.ShieldImage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The BossPlane class represents a powerful boss plane in the game.
 * It extends the FighterPlane class and includes additional features
 * such as a shield and a complex movement pattern.
 */
public class BossPlane extends FighterPlane {
    private final ShieldActivation shield; // Shield activation for the BossPlane
    private final List<Integer> movePattern; // List to store the movement pattern
    private int indexOfCurrentMove; // Index to track the current move in the pattern

    /**
     * Constructor for BossPlane.
     * Initializes the plane with specific attributes and activates the shield.
     * @param shieldImage The image used for the shield.
     */
    public BossPlane(ShieldImage shieldImage) {
        super("bossplane.png", 300, 1000.0, 400, 10);
        this.setLayoutY(200); // Set a higher initial position
        this.shield = new ShieldActivation(shieldImage);
        this.movePattern = new ArrayList<>();
        initializeMovePattern();
        setMovementStrategy(new VerticalMovementStrategy(8));
        setFiringStrategy(() -> Math.random() < 0.04 ? new BossProjectile(getProjectileInitialPosition()) : null);
        shield.activateShield();
    }

    /**
     * Initializes the movement pattern for the BossPlane.
     * The pattern includes various speeds and directions.
     */
    private void initializeMovePattern() {
        for (int i = 0; i < 10; i++) {
            movePattern.add(16);  // Move down much faster
            movePattern.add(-16); // Move up much faster
            movePattern.add(8);  // Move down faster
            movePattern.add(-8); // Move up faster
            movePattern.add(8);   // Move down
            movePattern.add(-8);  // Move up
            movePattern.add(4);   // Move down smoothly
            movePattern.add(-4);  // Move up smoothly
            movePattern.add(0);   // Stay still
        }
        Collections.shuffle(movePattern);
    }

    /**
     * Updates the position of the BossPlane based on the current move pattern.
     * Ensures the plane does not move out of the allowed vertical bounds.
     */
    @Override
    public void updatePosition() {
        int move = movePattern.get(indexOfCurrentMove);
        setMovementStrategy(new VerticalMovementStrategy(move));
        super.updatePosition();
        indexOfCurrentMove = (indexOfCurrentMove + 1) % movePattern.size();
        
        // Ensure the plane doesn't get stuck at the bottom or top
        double currentPosition = getLayoutY() + getTranslateY();
        if (currentPosition > 475) {
            setTranslateY(475 - getLayoutY());
        } else if (currentPosition < 0) {
            setTranslateY(-getLayoutY());
        }
        
        // Debugging output
        System.out.println("Current Position: " + currentPosition);
    }

    /**
     * Updates the state of the BossPlane.
     * This includes updating its position and the shield status.
     */
    @Override
    public void updateActor() {
        updatePosition();
        shield.updateShield();
    }

    /**
     * Handles the damage taken by the BossPlane.
     * Damage is only taken if the shield is not active.
     */
    @Override
    public void takeDamage() {
        if (!shield.isShielded()) {
            super.takeDamage();
        }
    }

    /**
     * Calculates the initial position for the projectiles fired by the BossPlane.
     * @return The initial Y position for the projectiles.
     */
    private double getProjectileInitialPosition() {
        return getLayoutY() + getTranslateY() + 75.0;
    }
}