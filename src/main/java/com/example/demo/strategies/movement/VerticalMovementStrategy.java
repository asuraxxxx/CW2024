package com.example.demo.strategies.movement;

import com.example.demo.actors.planes.FighterPlane;

public class VerticalMovementStrategy implements MovementStrategy {
    private final int velocity;

    public VerticalMovementStrategy(int velocity) {
        this.velocity = velocity;
    }

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