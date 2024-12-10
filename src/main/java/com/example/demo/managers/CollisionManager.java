package com.example.demo.managers;

import com.example.demo.actors.ActiveActorDestructible;
import java.util.List;

/**
 * The CollisionManager class handles collisions between actors in the game.
 */
public class CollisionManager {

    /**
     * Handles collisions between two lists of actors managed by CollisionManager.
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
}