package com.example.demo.audio;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.net.URL;

/**
 * The MusicController class manages the playback of background music in the game.
 * It uses the singleton pattern to ensure only one instance of the controller exists.
 */
public class MusicController {
    private static MusicController instance; // Singleton instance of MusicController
    private MediaPlayer mediaPlayer; // MediaPlayer for playing music
    private double volume = 0.5; // Default volume level

    /**
     * Private constructor to prevent instantiation.
     * Use getInstance() to get the singleton instance.
     */
    private MusicController() {
    }

    /**
     * Returns the singleton instance of MusicController.
     *
     * @return The singleton instance.
     */
    public static MusicController getInstance() {
        if (instance == null) {
            instance = new MusicController();
        }
        return instance;
    }

    /**
     * Plays the specified music file.
     * Stops any currently playing music before starting the new one.
     *
     * @param musicFile The path to the music file to be played.
     */
    public void playMusic(String musicFile) {
        stopMusic(); // Stop any currently playing music
        URL resource = getClass().getResource(musicFile);
        if (resource != null) {
            Media media = new Media(resource.toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Loop the music indefinitely
            mediaPlayer.setVolume(volume);
            mediaPlayer.play();
            System.out.println("Playing music: " + musicFile + " at volume: " + volume);
            mediaPlayer.setOnError(() -> {
                System.err.println("Error occurred while playing music: " + mediaPlayer.getError());
            });
        } else {
            System.err.println("Music file not found: " + musicFile);
        }
    }

    /**
     * Stops the currently playing music.
     */
    public void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = null;
            System.out.println("Stopping music");
        }
    }

    /**
     * Sets the volume for the music playback.
     *
     * @param volume The volume level to be set (0.0 to 1.0).
     */
    public void setVolume(double volume) {
        this.volume = volume;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volume);
        }
    }

    /**
     * Gets the current volume level.
     *
     * @return The current volume level.
     */
    public double getVolume() {
        return volume;
    }
}