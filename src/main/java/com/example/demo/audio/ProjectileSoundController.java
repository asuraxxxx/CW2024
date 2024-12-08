package com.example.demo.audio;

import javafx.scene.media.AudioClip;

import java.net.URL;

/**
 * The ProjectileSoundController class manages the playback of sound effects for projectiles.
 * It includes a method to play a specified sound file.
 */
public class ProjectileSoundController {

    /**
     * Plays the specified sound file.
     * @param soundFile The path to the sound file to be played.
     */
    public static void playSound(String soundFile) {
        try {
            URL soundURL = ProjectileSoundController.class.getResource(soundFile);
            if (soundURL == null) {
                System.err.println("Fail to load sound");
            } else {
                AudioClip sound = new AudioClip(soundURL.toExternalForm());
                sound.play();
            }
        } catch (Exception e) {
            System.err.println("Fail to load sound: " + e.getMessage());
        }
    }
}