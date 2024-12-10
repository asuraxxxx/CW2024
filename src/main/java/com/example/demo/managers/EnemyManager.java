package com.example.demo.managers;

import com.example.demo.actors.ActiveActorDestructible;
import javafx.scene.Group;

import java.util.List;

public class EnemyManager {
    private final List<ActiveActorDestructible> enemyUnits;
    private final double screenWidth;

    public EnemyManager(Group root, List<ActiveActorDestructible> enemyUnits, double screenWidth, double enemyMaximumYPosition) {
        this.enemyUnits = enemyUnits;
        this.screenWidth = screenWidth;
    }

    public void spawnEnemyUnits(int totalEnemies, double spawnProbability) {
        // Logic to spawn enemy units
    }

    public void updateEnemies() {
        // Logic to update enemy units
    }

    public void handleEnemyPenetration() {
        for (ActiveActorDestructible enemy : enemyUnits) {
            if (enemyHasPenetratedDefenses(enemy)) {
                // Logic to handle enemy penetration
            }
        }
    }

    private boolean enemyHasPenetratedDefenses(ActiveActorDestructible enemy) {
        return Math.abs(enemy.getTranslateX()) > screenWidth;
    }

    public void removeDestroyedEnemies() {
        // Logic to remove destroyed enemy units
    }
}