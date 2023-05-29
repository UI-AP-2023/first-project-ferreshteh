package com.example.phase2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Search_Article extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Register.class.getResource("searchPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 603, 562);
        stage.setTitle("90'VISION!");
        stage.setScene(scene);
        stage.show();
    }
}
