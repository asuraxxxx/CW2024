package com.example.demo.managers;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.planes.UserPlane;
import javafx.scene.Group;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * The ActorManager class manages the actors in the game, including friendly units, enemy units, and projectiles.
 */
public class ActorManager {

    private final Group root;
    private final List<ActiveActorDestructible> friendlyUnits;
    private final List<ActiveActorDestructible> enemyUnits;
    private final List<ActiveActorDestructible> userProjectiles;
    private final List<ActiveActorDestructible> enemyProjectiles;

    /**
     * Constructs a new ActorManager.
     *
     * @param root the root group of the scene
     * @param friendlyUnits the list of friendly units
     * @param enemyUnits the list of enemy units
     * @param userProjectiles the list of user projectiles
     * @param enemyProjectiles the list of enemy projectiles
     */
    public ActorManager(Group root, List<ActiveActorDestructible> friendlyUnits, List<ActiveActorDestructible> enemyUnits,
                        List<ActiveActorDestructible> userProjectiles, List<ActiveActorDestructible> enemyProjectiles) {
        this.root = root;
        this.friendlyUnits = friendlyUnits;
        this.enemyUnits = enemyUnits;
        this.userProjectiles = userProjectiles;
        this.enemyProjectiles = enemyProjectiles;
    }

    /**
     * Updates all actors in the game managed by ActorManager.
     */
    public void updateActors() {
        friendlyUnits.forEach(plane -> plane.updateActor());
        enemyUnits.forEach(enemy -> enemy.updateActor());
        userProjectiles.forEach(projectile -> projectile.updateActor());
        enemyProjectiles.forEach(projectile -> projectile.updateActor());
    }

    /**
     * Removes all destroyed actors from the game managed by ActorManager.
     */
    public void removeAllDestroyedActors() {
        removeDestroyedActors(friendlyUnits);
        removeDestroyedActors(enemyUnits);
        removeDestroyedActors(userProjectiles);
        removeDestroyedActors(enemyProjectiles);
    }

    /**
     * Removes destroyed actors from a given list of actors managed by ActorManager.
     *
     * @param actors the list of actors to check
     */
    private void removeDestroyedActors(List<ActiveActorDestructible> actors) {
        List<ActiveActorDestructible> destroyedActors = actors.stream()
            .filter(ActiveActorDestructible::isDestroyed)
            .collect(Collectors.toList());
        root.getChildren().removeAll(destroyedActors);
        actors.removeAll(destroyedActors);
    }

    /**
     * Handles collisions between two lists of actors managed by ActorManager.
     *
     * @param actors1 the first list of actors
     * @param actors2 the second list of actors
     */
    public void handleCollisions(List<ActiveActorDestructible> actors1, List<ActiveActorDestructible> actors2) {
        for (ActiveActorDestructible actor : actors2) {
            for (ActiveActorDestructible otherActor : actors1) {
                if (actor.getBoundsInParent().intersects(otherActor.getBoundsInParent())) {
                    actor.takeDamage();
                    otherActor.takeDamage();
                }
            }
        }
    }

    /**
     * Initializes friendly units in the game managed by ActorManager.
     *
     * @param user the user plane to add
     */
    public void initializeFriendlyUnits(UserPlane user) {
        root.getChildren().add(user);
    }

    /**
     * Spawns enemy units in the game managed by ActorManager.
     *
     * @param totalEnemies the total number of enemies to spawn
     * @param spawnProbability the probability of spawning each enemy
     * @param enemySupplier the supplier to create new enemy units
     */
    public void spawnEnemyUnits(int totalEnemies, double spawnProbability, Supplier<ActiveActorDestructible> enemySupplier) {
        for (int i = 0; i < totalEnemies - enemyUnits.size(); i++) {
            if (Math.random() < spawnProbability) {
                ActiveActorDestructible newEnemy = enemySupplier.get();
                enemyUnits.add(newEnemy);
                root.getChildren().add(newEnemy);
            }
        }
    }
}