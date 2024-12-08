package com.example.demo.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import com.example.demo.levels.LevelParent;
import com.example.demo.levels.LevelTransitionScreen;

import javafx.animation.FadeTransition;
import javafx.util.Duration;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * The GameController class manages the game's flow, including launching the game,
 * transitioning between levels, and handling errors.
 */
public class GameController {

    private static final String LEVEL_ONE_CLASS_NAME = "com.example.demo.levels.LevelOne"; // Class name for the first level
    private final Stage stage; // The primary stage for the game

    /**
     * Constructor for GameController.
     * Initializes the controller with the primary stage.
     * @param stage The primary stage for the game.
     */
    public GameController(Stage stage) {
        this.stage = stage;
    }

    /**
     * Launches the game by showing the stage and starting the first level.
     * @throws ClassNotFoundException If the level class is not found.
     * @throws NoSuchMethodException If the level class does not have the expected constructor.
     * @throws SecurityException If there is a security violation.
     * @throws InstantiationException If the level class cannot be instantiated.
     * @throws IllegalAccessException If the level class or its constructor is not accessible.
     * @throws IllegalArgumentException If the arguments for the constructor are invalid.
     * @throws InvocationTargetException If the constructor throws an exception.
     */
    public void launchGame() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException  {
        stage.show();
        goToLevel(LEVEL_ONE_CLASS_NAME);
    }

    /**
     * Transitions to the specified level.
     * @param className The class name of the level to transition to.
     * @throws ClassNotFoundException If the level class is not found.
     * @throws NoSuchMethodException If the level class does not have the expected constructor.
     * @throws SecurityException If there is a security violation.
     * @throws InstantiationException If the level class cannot be instantiated.
     * @throws IllegalAccessException If the level class or its constructor is not accessible.
     * @throws IllegalArgumentException If the arguments for the constructor are invalid.
     * @throws InvocationTargetException If the constructor throws an exception.
     */
    private void goToLevel(String className) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> myClass = Class.forName(className);
        Constructor<?> constructor = myClass.getConstructor(double.class, double.class);
        LevelParent myLevel = (LevelParent) constructor.newInstance(stage.getHeight(), stage.getWidth());
        myLevel.levelProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null && !newValue.isEmpty()) {
                    LevelTransitionScreen.fadeOutCurrentScene(stage, () -> {
                        LevelTransitionScreen transitionScene = new LevelTransitionScreen(stage, "Entering the next level...",
                                stage.getWidth(), stage.getHeight());
                        transitionScene.showTransition(() -> {
                            goToNextLevel(newValue);
                        });
                    });
                }
            }
        });
        Scene scene = myLevel.initializeScene();
        stage.setScene(scene);
        myLevel.startGame();
        applyFadeInTransition(scene);
    }

    /**
     * Applies a fade-in transition to the specified scene.
     * @param scene The scene to which the fade-in transition is applied.
     */
    private void applyFadeInTransition(Scene scene) {
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), scene.getRoot());
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);
        fadeIn.setAutoReverse(false);
        fadeIn.play();
    }

    /**
     * Transitions to the next level specified by the level name.
     * @param levelName The class name of the next level.
     */
    private void goToNextLevel(String levelName) {
        try {
            goToLevel(levelName);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException e) {
            showAlert(e);
        }
    }

    /**
     * Shows an alert with the specified exception message.
     * @param e The exception that occurred.
     */
    private void showAlert(Exception e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setContentText("Error occurred while loading level: " + e.getMessage());
        alert.show();
    }
}