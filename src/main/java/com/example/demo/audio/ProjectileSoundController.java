package com.example.demo.audio;

import javafx.scene.media.AudioClip;

import java.net.URL;

public class ProjectileSoundController {
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