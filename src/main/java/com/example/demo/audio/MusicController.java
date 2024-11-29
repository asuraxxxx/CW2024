package com.example.demo.audio;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.net.URL;

public class MusicController {
    private static MusicController instance;
    private MediaPlayer mediaPlayer;
    private double volume = 0.5; // Default volume

    private MusicController() {
    }

    public static MusicController getInstance() {
        if (instance == null) {
            instance = new MusicController();
        }
        return instance;
    }

    public void playMusic(String musicFile) {
        stopMusic(); // Stop any currently playing music
        URL resource = getClass().getResource(musicFile);
        if (resource != null) {
            Media media = new Media(resource.toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
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

    public void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = null;
            System.out.println("Stopping music");
        }
    }

    public void setVolume(double volume) {
        this.volume = volume;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volume);
        }
    }

    public double getVolume() {
        return volume;
    }
}