package com.example.demo.strategies.movement;

import com.example.demo.actors.planes.FighterPlane;

/**
 * The HorizontalMovementStrategy class implements the MovementStrategy interface.
 * It defines a strategy for moving a fighter plane horizontally.
 */
public class HorizontalMovementStrategy implements MovementStrategy {
    private final int velocity; // The velocity at which the plane moves horizontally

    /**
     * Constructor for HorizontalMovementStrategy.
     * Initializes the strategy with a specific velocity.
     * @param velocity The horizontal velocity for the plane.
     */
    public HorizontalMovementStrategy(int velocity) {
        this.velocity = velocity;
    }

    /**
     * Updates the position of the plane by moving it horizontally.
     * @param plane The fighter plane whose position is to be updated.
     */
    @Override
    public void updatePosition(FighterPlane plane) {
        plane.moveHorizontally(velocity);
    }
}