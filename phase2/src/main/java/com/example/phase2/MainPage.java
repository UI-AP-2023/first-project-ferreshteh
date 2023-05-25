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
import javafx.util.Duration;

import java.io.IOException;

public class MainPage extends Application {
    @FXML
    private AnchorPane products;
    @FXML
    private AnchorPane meno_pane;
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
    @FXML
    private ImageView meno_btn;

    double x, y = 0;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 603, 562);
        stage.setTitle("90'VISION!");
        stage.setScene(scene);
        //-----------------------
        meno_pane.setVisible(false);
        products.setVisible(true);
        //------------------------
        scene.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        //--------------------------
        scene.setOnMouseDragged(event -> {
            stage.setX((event.getScreenX() - x));
            stage.setY(event.getScreenY() - y);
        });
        //----------------------
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(.5), products);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition transition = new TranslateTransition(Duration.seconds(.5), meno_pane);
        transition.setByX(-600);
        transition.play();
        //----------------------
        //----------------------
        stage.show();
        //-----------------------------
    }

    @FXML
    void last_page(MouseEvent event) throws Exception {
        new User_Information().start((Stage) user_btn.getScene().getWindow());
    }

    @FXML
    void menoShow(MouseEvent event) {
        meno_pane.setVisible(true);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(.5), products);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(0.15);
        fadeTransition.play();

        TranslateTransition transition = new TranslateTransition(Duration.seconds(.5), meno_pane);
        transition.setByX(+600);
        transition.play();
    }

    @FXML
    void paneProduct(MouseEvent event) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(.5), products);
        fadeTransition.setFromValue(0.15);
        fadeTransition.setToValue(0);
        fadeTransition.play();
        fadeTransition.setOnFinished(event1 -> products.setVisible(false));

        TranslateTransition transition = new TranslateTransition(Duration.seconds(.5), meno_pane);
        transition.setByX(-600);
        transition.play();
    }
    @FXML
    void showIformation(MouseEvent event) throws Exception {
        new User_Information().start((Stage) user_btn.getScene().getWindow());
    }
    @FXML
    void showRegisterPage(MouseEvent event) throws Exception {
        new User_Information().start((Stage) home_btn.getScene().getWindow());
    }
    @FXML
    void addCredit(MouseEvent event) throws Exception {
        new User_Information().start((Stage) credit_btn.getScene().getWindow());
    }
}
