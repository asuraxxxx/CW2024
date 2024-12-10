package com.example.demo.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The LeaderboardScreen class displays the leaderboard with the times of each playthrough.
 */
public class LeaderboardScreen {
    private Stage primaryStage;
    private static List<Long> leaderboardTimes = new ArrayList<>();
    private static final String LEADERBOARD_FILE = "leaderboard.txt";

    public LeaderboardScreen(Stage stage) {
        this.primaryStage = stage;
        loadLeaderboardData();
    }

    public void show() {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        Text title = new Text("Leaderboard");
        title.setFont(Font.font("Impact", 40));
        title.setStyle("-fx-fill: white;");
        
        VBox timesLayout = new VBox(10);
        timesLayout.setAlignment(Pos.CENTER);

        if (leaderboardTimes.isEmpty()) {
            Text noDataText = new Text("No data available");
            noDataText.setFont(Font.font("Times New Roman", 20));
            noDataText.setStyle("-fx-fill: white;");
            timesLayout.getChildren().add(noDataText);
        } else {
            Collections.sort(leaderboardTimes); // Sort times in ascending order
            for (int i = 0; i < leaderboardTimes.size(); i++) {
                long time = leaderboardTimes.get(i);
                long seconds = time / 1_000_000_000;
                Text timeText = new Text("Ranking " + (i + 1) + ": " + seconds + " seconds");
                timeText.setFont(Font.font("Times New Roman", 20));
                timeText.setStyle("-fx-fill: white;");
                timesLayout.getChildren().add(timeText);
            }
        }

        Button backButton = new Button("Return to Menu");
        backButton.setPrefWidth(150);
        backButton.setPrefHeight(25);
        backButton.setFont(Font.font("Impact", 15));
        backButton.setOnAction(e -> primaryStage.setScene(new MainMenu(primaryStage).getMainMenuScene()));

        Button clearButton = new Button("Clear Leaderboard");
        clearButton.setPrefWidth(150);
        clearButton.setPrefHeight(25);
        clearButton.setFont(Font.font("Impact", 15));
        clearButton.setOnAction(e -> clearLeaderboard());

        layout.getChildren().addAll(title, timesLayout, backButton, clearButton);

        // Load and set the background image
        Image backgroundImage = new Image(getClass().getResource("/com/example/demo/images/pausescreen.png").toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(800);
        backgroundImageView.setFitHeight(600);
        backgroundImageView.setPreserveRatio(false);

        // Ensure the background image covers the full screen
        backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundImageView.fitHeightProperty().bind(primaryStage.heightProperty());

        // Create a stack pane to hold the background image and layout
        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundImageView, layout);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
    }

    public static void addTime(long time) {
        leaderboardTimes.add(time);
        saveLeaderboardData();
    }

    private static void saveLeaderboardData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LEADERBOARD_FILE))) {
            for (Long time : leaderboardTimes) {
                writer.write(time.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving leaderboard data: " + e.getMessage());
        }
    }

    private static void loadLeaderboardData() {
        leaderboardTimes.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(LEADERBOARD_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                leaderboardTimes.add(Long.parseLong(line));
            }
        } catch (IOException e) {
            System.err.println("Error loading leaderboard data: " + e.getMessage());
        }
    }

    private void clearLeaderboard() {
        leaderboardTimes.clear();
        saveLeaderboardData();
        show(); // Refresh the leaderboard screen
    }
}