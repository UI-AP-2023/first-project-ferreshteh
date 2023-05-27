package com.example.phase2;

import com.jfoenix.controls.JFXButton;
import controller.ArtContoroller;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
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
    private ImageView exit_btn;

    @FXML
    private Rectangle searchRectangle;

    @FXML
    private ImageView search_img;

    @FXML
    private TextField search_textField;

    @FXML
    private ImageView credit_image;

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

    @FXML
    private ImageView home_image;

    @FXML
    private AnchorPane meno_pane;

   // @FXML
   // private VBox meno_Vbox;

    @FXML
    private JFXButton credit_btn;

    @FXML
    private JFXButton home_btn;

    @FXML
    private JFXButton user_btn;

    @FXML
    private JFXButton cart_btn;

    @FXML
    private Button btn1;

    @FXML
    private AnchorPane products;

    @FXML
    private AnchorPane carPane1;

    @FXML
    private ImageView carBlack_image1;

    @FXML
    private AnchorPane Laptop_pane1;

    @FXML
    private ImageView laptop_image1;

    @FXML
    private AnchorPane pane31;

    @FXML
    private ImageView ssd_image2;

    @FXML
    private ImageView flash_image1;

    @FXML
    private AnchorPane pane51;

    @FXML
    private ImageView carWhite_image1;

    @FXML
    private ImageView off_btn;
    @FXML
    private AnchorPane pane71;

    @FXML
    private ImageView pen_image1;

    @FXML
    private ImageView flash_image2;

    @FXML
    private ImageView ssd_image11;

    @FXML
    private AnchorPane pane62;

    @FXML
    private ImageView bicycle_image2;
    @FXML
    private AnchorPane search_pane;

    double x, y = 0;
    public void translateAnimation(double duration, Node node,double width){
        TranslateTransition translateTransition=new TranslateTransition();
        translateTransition.setNode(node);
        node.setVisible(true);
        translateTransition.play();
       translateTransition.setDelay(Duration.seconds(2));
        node.setVisible(false);
        translateTransition.pause();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        search_pane.setVisible(true);
        meno_pane.setVisible(false);
        products.setVisible(true);
        //---------------------------------
        if (products.isVisible()) {
            translateAnimation(2,carPane1,800);
           // translateAnimation(2,Laptop_pane1,829);
        }
//
//            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(5), pineAple_image);
//            fadeTransition.setFromValue(1);
//            fadeTransition.setToValue(0);
//            fadeTransition.play();
//        }
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
    void searchProducts(MouseEvent event) throws Exception {
        String input=search_textField.getText();
       Article article= ArtContoroller.getInstance().search(input);
       if(article!=null){
           Alert alert=new Alert(Alert.AlertType.ERROR);
           alert.setContentText("id not fount");
           alert.show();
       }
       else {
           new Search_Article().start((Stage) search_img.getScene().getWindow());
       }
    }
    @FXML
    public void offPage(MouseEvent event){

    }
}
