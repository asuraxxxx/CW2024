module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires javafx.media;
	requires javafx.swing;

    opens com.example.demo.ui.images to javafx.fxml;
    exports com.example.demo.controller;
    
    
}