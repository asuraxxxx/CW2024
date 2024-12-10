package com.example.demo.factories;

import com.example.demo.actors.planes.BossPlane;
import com.example.demo.actors.planes.EnemyPlane;
import com.example.demo.actors.planes.EnemyPlane2;
import com.example.demo.actors.planes.FighterPlane;
import com.example.demo.actors.planes.UserPlane;
import com.example.demo.ui.images.ShieldImage;

/**
 * The PlaneFactory class is responsible for creating instances of different types of planes.
 * It uses a factory method to instantiate the appropriate plane based on the provided type.
 */
public class PlaneFactory {

    /**
     * Creates a plane instance based on the specified type.
     *
     * @param type The type of the plane to create.
     * @param initialXPos The initial X position of the plane.
     * @param initialYPos The initial Y position of the plane.
     * @param initialHealth The initial health of the plane (used for user plane).
     * @param shieldImage The shield image (used for boss plane).
     * @return An instance of the specified plane.
     * @throws IllegalArgumentException If the plane type is unknown.
     */
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