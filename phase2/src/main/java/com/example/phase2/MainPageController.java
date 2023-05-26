package com.example.phase2;

import com.jfoenix.controls.JFXButton;
import controller.ArtContoroller;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.articles.Article;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private Rectangle searchRectangle;

    @FXML
    private ImageView search_img;

    @FXML
    private TextField search_textField;

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
    public void initialize(URL url, ResourceBundle resourceBundle) {
        meno_pane.setVisible(false);
        //---------------------------------
//        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(.5), meno_pane);
//        fadeTransition.setFromValue(1);
//        fadeTransition.setToValue(0);
//        fadeTransition.play();
//
//        TranslateTransition transition = new TranslateTransition(Duration.seconds(.5), products);
//        transition.setByX(-600);
//        transition.play();

        //-----------------------------------
        meno_btn.setOnMouseClicked(event -> {
            if (!meno_pane.isVisible()) {
                meno_pane.setVisible(true);

                FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(.5), meno_pane);
                fadeTransition1.setFromValue(0);
                fadeTransition1.setToValue(1);
                fadeTransition1.play();

                TranslateTransition transition1 = new TranslateTransition(Duration.seconds(.5), products);
                transition1.setByX(+600);
                transition1.play();
                meno_pane.setVisible(true);
            }
            else {
                meno_pane.setVisible(false);
                FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(.5), meno_pane);
                fadeTransition1.setFromValue(.5);
                fadeTransition1.setToValue(0);
                fadeTransition1.play();

                TranslateTransition transition1 = new TranslateTransition(Duration.seconds(.5), products);
                transition1.setByX(-600);
                transition1.play();

            }
        });
        //-------------------------------------
        meno_pane.setOnMouseClicked(event -> {
            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(.5), meno_pane);
            fadeTransition1.setFromValue(0.15);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                meno_pane.setVisible(false);
            });

            TranslateTransition transition1 = new TranslateTransition(Duration.seconds(.5), products);
            transition1.setByX(-600);
            transition1.play();
        });
        //---------------------------------------

    }

    @FXML
    void showInformation(MouseEvent event) throws Exception {
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

    @FXML
    void last_page(MouseEvent event) throws Exception {
        new User_Information().start((Stage) user_btn.getScene().getWindow());
    }
    @FXML
    void searchProducts(MouseEvent event){
        String input=search_textField.getText();
       Article article= ArtContoroller.getInstance().search(input);
       if(article!=null){

       }
       else {

       }
    }
}
