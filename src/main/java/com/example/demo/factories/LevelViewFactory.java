package com.example.demo.factories;

import com.example.demo.levels.LevelBossView;
import com.example.demo.levels.LevelView;

import javafx.scene.Group;

public class LevelViewFactory {

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