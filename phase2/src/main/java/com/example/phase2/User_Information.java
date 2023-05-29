package com.example.phase2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class User_Information extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Register.class.getResource("user'Information.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 754, 573);
        stage.setTitle("90'VISION!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[]args){
        launch(args);
    }
}
