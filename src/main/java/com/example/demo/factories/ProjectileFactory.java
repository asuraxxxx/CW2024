package com.example.demo.factories;

import com.example.demo.actors.projectiles.BossProjectile;
import com.example.demo.actors.projectiles.EnemyProjectile;
import com.example.demo.actors.projectiles.Projectile;
import com.example.demo.actors.projectiles.UserProjectile;

/**
 * The ProjectileFactory class is responsible for creating instances of different types of projectiles.
 * It uses a factory method to instantiate the appropriate projectile based on the provided type.
 */
public class ProjectileFactory {

    /**
     * Creates a projectile instance based on the specified type.
     *
     * @param type The type of the projectile to create.
     * @param initialXPos The initial X position of the projectile.
     * @param initialYPos The initial Y position of the projectile.
     * @return An instance of the specified projectile.
     * @throws IllegalArgumentException If the projectile type is unknown.
     */
    public static Projectile createProjectile(String type, double initialXPos, double initialYPos) {
        switch (type.toLowerCase()) {
            case "bossprojectile":
                return new BossProjectile(initialYPos);
            case "enemyprojectile":
                return new EnemyProjectile(initialXPos, initialYPos);
            case "userprojectile":
                return new UserProjectile(initialXPos, initialYPos);
            default:
                throw new IllegalArgumentException("Unknown projectile type: " + type);
        }
    }
}