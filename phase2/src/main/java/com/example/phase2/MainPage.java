package com.example.phase2;


import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainPage extends Application {
    @FXML
    private ImageView laptop_image;

    @FXML
    private ImageView flash_image;

    @FXML
    private ImageView ssd_image;

    @FXML
    private ImageView pen_image;

    @FXML
    private ImageView bicycle_image;

    @FXML
    private Button btn1;
    @FXML
    private JFXButton credit_btn;

    @FXML
    private JFXButton home_btn;

    @FXML
    private JFXButton user_btn;

    @FXML
    private JFXButton cart_btn;


    @FXML
    private ImageView pineAple_image;

    @FXML
    private ImageView carWhite_image;

    @FXML
    private ImageView carBlack_image;

    @FXML
    private ImageView apple_image;

    @FXML
    private ImageView credit_image;

    @FXML
    private ImageView home_image;

    @FXML
    private ImageView user_image;

    @FXML
    private ImageView cart_image;

    @FXML
    private ImageView factors_image;

    @FXML
    private ImageView comment_image;
    double x,y=0;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 603, 562);
        stage.setTitle("90'VISION!");
        stage.setScene(scene);
        //------------------------
        scene.setOnMousePressed(event ->{
            x=event.getSceneX();
            y=event.getSceneY();
        });
        //--------------------------
        scene.setOnMouseDragged(event ->{
            stage.setX((event.getScreenX()-x));
            stage.setY(event.getScreenY()-y);
        });
        stage.show();
    }


}
