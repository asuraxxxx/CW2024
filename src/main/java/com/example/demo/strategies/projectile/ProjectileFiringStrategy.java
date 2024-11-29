package com.example.demo.strategies.projectile;

import com.example.demo.actors.ActiveActorDestructible;

public interface ProjectileFiringStrategy {
    ActiveActorDestructible fireProjectile();
}