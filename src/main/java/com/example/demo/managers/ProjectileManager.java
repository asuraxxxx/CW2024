package com.example.demo.managers;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.planes.FighterPlane;

import javafx.scene.Group;
import java.util.List;

/**
 * The ProjectileManager class manages the projectiles fired by both user and enemy units in the game.
 */
public class ProjectileManager {
    private final Group root;
    private final List<ActiveActorDestructible> userProjectiles;
    private final List<ActiveActorDestructible> enemyProjectiles;

    /**
     * Constructs a new ProjectileManager.
     *
     * @param root the root group of the scene
     * @param userProjectiles the list of user projectiles
     * @param enemyProjectiles the list of enemy projectiles
     */
    public ProjectileManager(Group root, List<ActiveActorDestructible> userProjectiles, List<ActiveActorDestructible> enemyProjectiles) {
        this.root = root;
        this.userProjectiles = userProjectiles;
        this.enemyProjectiles = enemyProjectiles;
    }

    /**
     * Generates enemy fire by spawning projectiles for each enemy unit managed by ProjectileManager.
     *
     * @param enemyUnits the list of enemy units
     */
    public void generateEnemyFire(List<ActiveActorDestructible> enemyUnits) {
        enemyUnits.forEach(enemy -> spawnEnemyProjectile(((FighterPlane) enemy).fireProjectile()));
    }

    /**
     * Spawns a projectile for an enemy unit and adds it to the scene.
     *
     * @param projectile the projectile to spawn
     */
    public void spawnEnemyProjectile(ActiveActorDestructible projectile) {
        if (projectile != null) {
            root.getChildren().add(projectile);
            enemyProjectiles.add(projectile);
        }
    }

    /**
     * Handles the event when a user projectile is fired and adds it to the scene.
     *
     * @param projectile the projectile fired by the user
     */
    public void onProjectileFired(ActiveActorDestructible projectile) {
        if (projectile != null) {
            root.getChildren().add(projectile);
            userProjectiles.add(projectile);
        }
    }
}