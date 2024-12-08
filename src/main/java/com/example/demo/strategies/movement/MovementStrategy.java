package com.example.demo.strategies.movement;

import com.example.demo.actors.planes.FighterPlane;

/**
 * The MovementStrategy interface defines the method required for a movement strategy.
 * Any class implementing this interface must provide an implementation for updating the position of a fighter plane.
 */
public interface MovementStrategy {

    /**
     * Updates the position of the specified fighter plane.
     * @param plane The fighter plane whose position is to be updated.
     */
    void updatePosition(FighterPlane plane);
}