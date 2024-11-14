package com.example.demo.controller;

import javafx.application.Application;
import javafx.stage.Stage;
import com.example.demo.MainMenu;

public class GameLauncher extends Application {

    private static final int SCREEN_WIDTH = 1300;
    private static final int SCREEN_HEIGHT = 750;
    private static final String TITLE = "Sky Battle";

    @Override
    public void start(Stage stage) {
        stage.setTitle(TITLE);
        stage.setResizable(false);
        stage.setHeight(SCREEN_HEIGHT);
        stage.setWidth(SCREEN_WIDTH);

        // Initialize and display the main menu
        MainMenu mainMenu = new MainMenu(stage);
        stage.setScene(mainMenu.getMainMenuScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
