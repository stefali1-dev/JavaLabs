package com.example.lab6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // .fxml loader
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));

        // scene
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}