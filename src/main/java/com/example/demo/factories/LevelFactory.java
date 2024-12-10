package com.example.demo.factories;

import com.example.demo.levels.LevelBoss;
import com.example.demo.levels.LevelOne;
import com.example.demo.levels.LevelParent;
import com.example.demo.levels.LevelTwo;

/**
 * The LevelFactory class is responsible for creating instances of different game levels.
 * It uses a factory method to instantiate the appropriate level based on the provided level name.
 */
public class LevelFactory {

    /**
     * Creates a level instance based on the specified level name.
     *
     * @param levelName The name of the level to create.
     * @param screenHeight The height of the game window.
     * @param screenWidth The width of the game window.
     * @return An instance of the specified level.
     * @throws IllegalArgumentException If the level name is unknown.
     */
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