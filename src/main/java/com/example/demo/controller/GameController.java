package com.example.demo.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import com.example.demo.LevelParent;
import com.example.demo.LevelTransitionScreen;
import javafx.animation.FadeTransition;
import javafx.util.Duration;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class GameController {

    private static final String LEVEL_ONE_CLASS_NAME = "com.example.demo.LevelOne";
    private final Stage stage;

    public GameController(Stage stage) {
        this.stage = stage;
    }

    public void launchGame() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException  {

            stage.show();
            goToLevel(LEVEL_ONE_CLASS_NAME);
    }

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

    private void applyFadeInTransition(Scene scene) {
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), scene.getRoot());
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);
        fadeIn.setAutoReverse(false);
        fadeIn.play();
    }

    private void goToNextLevel(String levelName) {
        try {
            goToLevel(levelName);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException e) {
            showAlert(e);
        }
    }

    private void showAlert(Exception e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setContentText("Error occurred while loading level: " + e.getMessage());
        alert.show();
    }
}