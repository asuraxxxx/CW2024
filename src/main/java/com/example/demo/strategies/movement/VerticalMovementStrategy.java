package com.example.demo.strategies.movement;

import com.example.demo.actors.planes.FighterPlane;

/**
 * The VerticalMovementStrategy class implements the MovementStrategy interface.
 * It defines a strategy for moving a fighter plane vertically.
 */
public class VerticalMovementStrategy implements MovementStrategy {
    private final int velocity; // The velocity at which the plane moves vertically

    /**
     * Constructor for VerticalMovementStrategy.
     * Initializes the strategy with a specific velocity.
     * @param velocity The vertical velocity for the plane.
     */
    public VerticalMovementStrategy(int velocity) {
        this.velocity = velocity;
    }

    /**
     * Updates the position of the plane by moving it vertically.
     * Ensures the plane does not move out of the allowed vertical bounds.
     * @param plane The fighter plane whose position is to be updated.
     */
    @Override
    public void updatePosition(FighterPlane plane) {
        double initialTranslateY = plane.getTranslateY();
        plane.moveVertically(velocity);
        double currentPosition = plane.getLayoutY() + plane.getTranslateY();
        if (currentPosition < 0 || currentPosition > 475) {
            plane.setTranslateY(initialTranslateY);
        }
    }
}