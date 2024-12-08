package com.example.demo.actors;

/**
 * The ActiveActorDestructible class is an abstract class that represents an active actor
 * in the game which can be destroyed. It extends the ActiveActor class and implements
 * the Destructible interface.
 */
public abstract class ActiveActorDestructible extends ActiveActor implements Destructible {
    private boolean isDestroyed; // Flag to indicate if the actor is destroyed

    /**
     * Constructor for ActiveActorDestructible.
     * Initializes the actor with specific attributes and sets the destroyed flag to false.
     * @param imageName The image file name for the actor.
     * @param imageHeight The height of the actor image.
     * @param initialXPos The initial X position of the actor.
     * @param initialYPos The initial Y position of the actor.
     */
    public ActiveActorDestructible(String imageName, int imageHeight, double initialXPos, double initialYPos) {
        super(imageName, imageHeight, initialXPos, initialYPos);
        isDestroyed = false;
    }

    /**
     * Abstract method to update the position of the actor.
     * Must be implemented by subclasses.
     */
    @Override
    public abstract void updatePosition();

    /**
     * Abstract method to update the state of the actor.
     * Must be implemented by subclasses.
     */
    public abstract void updateActor();

    /**
     * Abstract method to handle the actor taking damage.
     * Must be implemented by subclasses.
     */
    @Override
    public abstract void takeDamage();

    /**
     * Method to destroy the actor.
     * Sets the destroyed flag to true.
     */
    @Override
    public void destroy() {
        setDestroyed(true);
    }

    /**
     * Sets the destroyed flag for the actor.
     * @param isDestroyed The new value for the destroyed flag.
     */
    protected void setDestroyed(boolean isDestroyed) {
        this.isDestroyed = isDestroyed;
    }

    /**
     * Checks if the actor is destroyed.
     * @return True if the actor is destroyed, false otherwise.
     */
    public boolean isDestroyed() {
        return isDestroyed;
    }
}