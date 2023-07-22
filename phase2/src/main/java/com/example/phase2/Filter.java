package com.example.phase2;

import controller.SuperCon;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.articles.Bicycle;
import model.user.SuperAdmin;

public class Filter extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Register.class.getResource("filter.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 635, 432);
        stage.setTitle("90'VISION!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {

        launch(args);
        System.out.println(SuperAdmin.getInstance().getArticles().size());
    }
}
