package com.example.phase2;

import controller.LoginController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.user.Customer;
import model.user.SuperAdmin;
import view.First;
import view.SuperMeno;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private ImageView image;

    @FXML
    private Label email_lbl;

    @FXML
    private Label phone_lbl;

    @FXML
    private Label password_lbl;

    @FXML
    private TextField email_textField;

    @FXML
    private TextField phone_textField;
    @FXML
    private Label username_lbl;

    @FXML
    private PasswordField username_Field;

    @FXML
    private PasswordField password_Field;
    String[]strings=new String[4];
   public static Customer customer;
    @FXML
    private Button login_btn;
    @FXML
    private static Button new_btn;
    @FXML
    private Button register_btn;
 public static   int check=0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void enterLogin(MouseEvent event) throws Exception {
        new Login().start((Stage) login_btn.getScene().getWindow());
    }
    @FXML
    public void check(MouseEvent event) throws Exception {
        strings[0]=email_textField.getText();
        strings[1]=phone_textField.getText();
        strings[2]=password_Field.getText();
        strings[3]=username_Field.getText();
        LoginController.getInstance().setUserInfoRegister(strings);
        Alert alert=new Alert(Alert.AlertType.WARNING);
        alert.setContentText("wait for admin decision");
        alert.show();
        SuperMeno.getInstance().adminMeno();
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
        new MainPage().start((Stage) register_btn.getScene().getWindow());
    }
//    public static void mainPage() throws Exception {
//        if ( check ==1){
//            new MainPage().start((Stage) new_btn.getScene().getWindow());
//        }
//        else {
//            System.out.println("check="+check);
//        }
//    }
}
