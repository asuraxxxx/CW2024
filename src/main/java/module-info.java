module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires javafx.media;

    opens com.example.demo.ui.images to javafx.fxml;
    exports com.example.demo.controller;
    exports com.example.demo.actors.projectiles;
    exports com.example.demo.levels;
}