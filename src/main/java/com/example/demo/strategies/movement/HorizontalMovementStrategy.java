package com.example.demo.strategies.movement;

import com.example.demo.actors.planes.FighterPlane;

public class HorizontalMovementStrategy implements MovementStrategy {
    private final int velocity;

    public HorizontalMovementStrategy(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public void updatePosition(FighterPlane plane) {
        plane.moveHorizontally(velocity);
    }
}