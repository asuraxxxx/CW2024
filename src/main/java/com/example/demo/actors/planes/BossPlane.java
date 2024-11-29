package com.example.demo.actors.planes;

import com.example.demo.actors.ShieldActivation;
import com.example.demo.strategies.movement.VerticalMovementStrategy;
import com.example.demo.actors.projectiles.BossProjectile;
import com.example.demo.ui.images.ShieldImage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BossPlane extends FighterPlane {
    private final ShieldActivation shield;
    private final List<Integer> movePattern;
    private int indexOfCurrentMove;

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

    @Override
    public void updateActor() {
        updatePosition();
        shield.updateShield();
    }

    @Override
    public void takeDamage() {
        if (!shield.isShielded()) {
            super.takeDamage();
        }
    }

    private double getProjectileInitialPosition() {
        return getLayoutY() + getTranslateY() + 75.0;
    }
}