package com.example.phase2;


import com.jfoenix.controls.JFXButton;
import controller.SuperCon;
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
import model.articles.Bicycle;
import model.user.SuperAdmin;

import java.io.IOException;
import java.util.Objects;

public class MainPage extends Application {
    double x, y = 0;
 public   static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainPage.fxml")));
        //stage.initStyle(StageStyle.UNDECORATED);
        scene=root.getScene();
        //-----------------------------
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        //--------------------------
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
        stage.setScene(new Scene(root, 800, 650));
        //----------------------

        //----------------------
        //----------------------
        stage.show();
        //-----------------------------
    }

    public static void main(String[] args) {
        SuperCon.getInstance().productManagement("add pen penName 10 5 blue vcxs");
        SuperCon.getInstance().productManagement("add computer co1 23 4 mkj 500 10 20 30");
        //SuperCon.getInstance().productManagement("add meal chips 2000 6 2023-4-1 2023-4-2");
        Bicycle bicycle = new Bicycle("1", "1", "1", 10, 5, "Vehicle", "1", "hybrid");
        bicycle.setId("id1");
        SuperAdmin.getInstance().addArticle(bicycle);
        SuperCon.getInstance().productManagement("add flash flash1 4100 0 12 10 23 700 usb1");
        SuperCon.getInstance().productManagement("add noteBook note1 54 4 typePaper 100 iran");
        SuperCon.getInstance().productManagement("add noteBook note2 100 7 pelastik 200 eragh");
        SuperCon.getInstance().productManagement("add machine bvw 700 4 mnb 10.2 true");
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
//---------------------------------
// color of  grey meno:  #A9A9A9
// color of ceremi :  #FFDAB9