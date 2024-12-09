package com.example.demo.actors.planes;

import com.example.demo.ui.images.ShieldImage;

public class PlaneFactory {

    public static FighterPlane createPlane(String type, double initialXPos, double initialYPos, int initialHealth, ShieldImage shieldImage) {
        switch (type.toLowerCase()) {
            case "enemyplane":
                return new EnemyPlane(initialXPos, initialYPos);
            case "enemyplane2":
                return new EnemyPlane2(initialXPos, initialYPos);
            case "userplane":
                return new UserPlane(initialHealth);
            case "bossplane":
                return new BossPlane(shieldImage);
            default:
                throw new IllegalArgumentException("Unknown plane type: " + type);
        }
    }
}