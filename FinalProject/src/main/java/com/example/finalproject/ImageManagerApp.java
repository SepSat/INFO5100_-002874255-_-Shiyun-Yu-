package com.example.finalproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ImageManagerApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Initialize and set your primary scene
        primaryStage.setTitle("Image Manager");
        primaryStage.setScene(new Scene(new HomeController(), 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
