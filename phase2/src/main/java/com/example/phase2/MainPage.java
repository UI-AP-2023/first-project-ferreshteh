package com.example.phase2;


import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class MainPage extends Application {
    double x,y=0;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainPage.fxml")));
        stage.initStyle(StageStyle.UNDECORATED);

        //------------------------
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        //--------------------------
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
        stage.setScene(new Scene(root,800,600));
        //----------------------

        //----------------------
        //----------------------
        stage.show();
        //-----------------------------
    }
public static void main(String[]args){
        launch(args);
    }


}


//    @FXML
//    void last_page(MouseEvent event) throws Exception {
//        new User_Information().start((Stage) user_btn.getScene().getWindow());
//    }
//
//    @FXML
//    void menoShow(MouseEvent event) {
//
//    }
//
//    @FXML
//    void paneProduct(MouseEvent event) {
//
//    }