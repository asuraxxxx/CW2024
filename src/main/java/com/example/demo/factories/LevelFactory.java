package com.example.demo.factories;

import com.example.demo.levels.LevelBoss;
import com.example.demo.levels.LevelOne;
import com.example.demo.levels.LevelParent;
import com.example.demo.levels.LevelTwo;

public class LevelFactory {

    public static LevelParent createLevel(String levelName, double screenHeight, double screenWidth) {
        switch (levelName) {
            case "LevelOne":
                return new LevelOne(screenHeight, screenWidth);
            case "LevelTwo":
                return new LevelTwo(screenHeight, screenWidth);
            case "LevelBoss":
                return new LevelBoss(screenHeight, screenWidth);
            default:
                throw new IllegalArgumentException("Unknown level: " + levelName);
        }
    }
}