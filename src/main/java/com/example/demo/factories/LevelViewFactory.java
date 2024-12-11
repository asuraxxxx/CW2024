package com.example.demo.factories;

import com.example.demo.levels.LevelBossView;
import com.example.demo.levels.LevelView;

import javafx.scene.Group;

/**
 * The LevelViewFactory class is responsible for creating instances of different level views.
 * It uses a factory method to instantiate the appropriate level view based on the provided level type.
 */
public class LevelViewFactory {

    /**
     * Creates a level view instance based on the specified level type.
     *
     * @param levelType The type of the level view to create.
     * @param root The root group for the level view.
     * @param playerInitialHealth The initial health of the player.
     * @return An instance of the specified level view.
     * @throws IllegalArgumentException If the level view type is unknown.
     */
    public static LevelView createLevelView(String levelType, Group root, int playerInitialHealth) {
        switch (levelType) {
            case "LevelOneView":
            case "LevelTwoView":
                return new LevelView(root, playerInitialHealth);
            case "LevelBossView":
                return new LevelBossView(root, playerInitialHealth);
            default:
                throw new IllegalArgumentException("Unknown level view type: " + levelType);
        }
    }
}