package com.example.demo.actors;

/**
 * The Destructible interface defines the methods required for an object to be destructible.
 * Any class implementing this interface must provide implementations for taking damage and being destroyed.
 */
public interface Destructible {

    /**
     * Handles the object taking damage.
     * Implementations should define how the object responds to damage.
     */
    void takeDamage();

    /**
     * Handles the destruction of the object.
     * Implementations should define what happens when the object is destroyed.
     */
    void destroy();
}