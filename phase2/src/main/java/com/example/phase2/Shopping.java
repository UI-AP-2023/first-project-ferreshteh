package com.example.phase2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Shopping extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Register.class.getResource("shopping.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 635, 432);
        stage.setTitle("90'VISION!");
        stage.setScene(scene);
        stage.show();
    }
}
