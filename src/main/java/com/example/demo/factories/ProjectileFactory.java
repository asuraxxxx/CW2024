package com.example.demo.factories;

import com.example.demo.actors.projectiles.BossProjectile;
import com.example.demo.actors.projectiles.EnemyProjectile;
import com.example.demo.actors.projectiles.Projectile;
import com.example.demo.actors.projectiles.UserProjectile;

public class ProjectileFactory {

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