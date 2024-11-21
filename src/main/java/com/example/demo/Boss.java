package com.example.demo;

import java.util.*;

public class Boss extends FighterPlane {

    private static final String IMAGE_NAME = "bossplane.png";
    private static final double INITIAL_X_POSITION = 1000.0;
    private static final double INITIAL_Y_POSITION = 400;
    private static final double PROJECTILE_Y_POSITION_OFFSET = 75.0;
    private static final double BOSS_FIRE_RATE = .04;
    private static final double BOSS_SHIELD_PROBABILITY = .002;
    private static final int IMAGE_HEIGHT = 300;
    private static final int VERTICAL_VELOCITY = 8;
    private static final int HEALTH = 10;
    private static final int MOVE_FREQUENCY_PER_CYCLE = 5;
    private static final int ZERO = 0;
    private static final int MAX_FRAMES_WITH_SAME_MOVE = 10;
    private static final int Y_POSITION_UPPER_BOUND = -100;
    private static final int Y_POSITION_LOWER_BOUND = 475;
    private static final int SHIELD_DURATION_FRAMES = 300; // 5 seconds at 60 FPS
    private static final int SHIELD_COOLDOWN_FRAMES = 600; // 10 seconds cooldown
    private final List<Integer> movePattern;
    private boolean isShielded;
    private int consecutiveMovesInSameDirection;
    private int indexOfCurrentMove;
    private int framesWithShieldActivated;
    private int framesSinceLastShield;
    private final ShieldImage shieldImage;

    public Boss(ShieldImage shieldImage) {
        super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, INITIAL_Y_POSITION, HEALTH);
        this.shieldImage = shieldImage;
        movePattern = new ArrayList<>();
        consecutiveMovesInSameDirection = 0;
        indexOfCurrentMove = 0;
        framesWithShieldActivated = 0;
        framesSinceLastShield = SHIELD_COOLDOWN_FRAMES; // Start with cooldown complete
        isShielded = false;
        initializeMovePattern();
    }

    @Override
    public void updatePosition() {
        double initialTranslateY = getTranslateY();
        moveVertically(getNextMove());
        double currentPosition = getLayoutY() + getTranslateY();
        if (currentPosition < Y_POSITION_UPPER_BOUND || currentPosition > Y_POSITION_LOWER_BOUND) {
            setTranslateY(initialTranslateY);
        }
    }
    
    @Override
    public void updateActor() {
        updatePosition();
        updateShield();
    }

    @Override
    public ActiveActorDestructible fireProjectile() {
        return bossFiresInCurrentFrame() ? new BossProjectile(getProjectileInitialPosition()) : null;
    }
    
    @Override
    public void takeDamage() {
        if (!shieldImage.isVisible()) {
            super.takeDamage();
        }
    }

    private void initializeMovePattern() {
        for (int i = 0; i < MOVE_FREQUENCY_PER_CYCLE; i++) {
            movePattern.add(VERTICAL_VELOCITY);
            movePattern.add(-VERTICAL_VELOCITY);
            movePattern.add(ZERO);
        }
        Collections.shuffle(movePattern);
    }

    private void updateShield() {
        if (isShielded) {
            framesWithShieldActivated++;
            System.out.println("Shield is active. Frames with shield: " + framesWithShieldActivated);
            if (shieldExhausted()) {
                deactivateShield();
            }
        } else {
            framesSinceLastShield++;
            if (shieldShouldBeActivated()) {
                activateShield();
            }
        }
    }

    private int getNextMove() {
        int currentMove = movePattern.get(indexOfCurrentMove);
        consecutiveMovesInSameDirection++;
        if (consecutiveMovesInSameDirection == MAX_FRAMES_WITH_SAME_MOVE) {
            Collections.shuffle(movePattern);
            consecutiveMovesInSameDirection = 0;
            indexOfCurrentMove++;
        }
        if (indexOfCurrentMove == movePattern.size()) {
            indexOfCurrentMove = 0;
        }
        return currentMove;
    }

    private boolean bossFiresInCurrentFrame() {
        return Math.random() < BOSS_FIRE_RATE;
    }

    private double getProjectileInitialPosition() {
        return getLayoutY() + getTranslateY() + PROJECTILE_Y_POSITION_OFFSET;
    }

    private boolean shieldShouldBeActivated() {
        return framesSinceLastShield >= SHIELD_COOLDOWN_FRAMES && Math.random() < BOSS_SHIELD_PROBABILITY;
    }

    private boolean shieldExhausted() {
        return framesWithShieldActivated >= SHIELD_DURATION_FRAMES;
    }

    private void activateShield() {
        isShielded = true;
        framesWithShieldActivated = 0;
        shieldImage.showShield(); // Show the shield image
        System.out.println("Shield activated");
    }

    private void deactivateShield() {
        isShielded = false;
        framesSinceLastShield = 0;
        shieldImage.hideShield(); // Hide the shield image
        System.out.println("Shield deactivated");
    }
}