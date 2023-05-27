package com.example.phase2;

import controller.LoginController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void check(MouseEvent event){
        strings[0]=email_textField.getText();
        strings[1]=phone_textField.getText();
        strings[2]=password_Field.getText();
        strings[3]=username_Field.getText();
        LoginController.getInstance().setUserInfoRegister(strings);
        Alert alert=new Alert(Alert.AlertType.WARNING);
        alert.setContentText("wait for admin decision");
        alert.show();

    }
}
