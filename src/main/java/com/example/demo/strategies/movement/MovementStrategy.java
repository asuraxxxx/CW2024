package com.example.demo.strategies.movement;

import com.example.demo.actors.planes.FighterPlane;

public interface MovementStrategy {
    void updatePosition(FighterPlane plane);
}