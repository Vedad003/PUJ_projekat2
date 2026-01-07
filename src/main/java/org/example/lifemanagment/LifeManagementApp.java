package org.example.lifemanagment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LifeManagementApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/example/lifemanagment/Login.fxml")
        );
        stage.setScene(new Scene(loader.load(), 400, 300));
        stage.setTitle("Life Management System");
        stage.show();
    }

}
