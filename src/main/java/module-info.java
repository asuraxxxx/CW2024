module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires javafx.media;
	requires javafx.swing;


    opens com.example.demo.ui.images to javafx.fxml;
    exports com.example.demo.controller;
    exports com.example.demo.actors;
    exports com.example.demo.audio;
    exports com.example.demo.factories;
    exports com.example.demo.levels;
    exports com.example.demo.managers;
    exports com.example.demo.ui;
    exports com.example.demo.strategies.movement;
    exports com.example.demo.strategies.projectile;
    
}