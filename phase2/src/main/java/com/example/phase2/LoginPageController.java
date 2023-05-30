package com.example.phase2;

import controller.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.user.Customer;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {
    static Customer customer;
    @FXML
    private ImageView image;

    @FXML
    private Label username_lbl;

    @FXML
    private Label password_lbl;

    @FXML
    private Button login_btn;

    @FXML
    private TextField username_textField;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button register_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        login_btn.setOnMouseClicked(event -> {
//           customer= LoginController.getInstance().setUserInfoEnter(username_textField.getText());
//            if(customer==null){
//                Alert alert=new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("wrong password");
//                alert.show();
//            }
//            else {
//                User_InformationController.customer=customer;
//                ShoppingController.customer=customer;
//                Search_ArticleController.customer=customer;
//                OffController.customer=customer;
//                MainPageController.customer=customer;
//                FilterController.customer=customer;
//                FactorsController.customer=customer;
//                CreditController.customer=customer;
//                CommentController.customer=customer;
//                AllArticleController.customer=customer;
//                try {
//                    new MainPage().start((Stage) login_btn.getScene().getWindow());
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
    }

    //---------------------------
    @FXML
    void enterMainPage(MouseEvent event) throws Exception {
        customer = LoginController.getInstance().setUserInfoEnter(username_textField.getText());
        if (customer == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("wrong password");
            alert.show();
        } else {
            User_InformationController.customer = customer;
            ShoppingController.customer = customer;
            Search_ArticleController.customer = customer;
            OffController.customer = customer;
            MainPageController.customer = customer;
            FilterController.customer = customer;
            FactorsController.customer = customer;
            CreditController.customer = customer;
            CommentController.customer = customer;
            AllArticleController.customer = customer;

            new MainPage().start((Stage) login_btn.getScene().getWindow());
        }
    }
    @FXML
    public void enterRegister(MouseEvent event) throws Exception {
        new Register().start((Stage) register_btn.getScene().getWindow());
    }
}
