package com.example.phase2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Register extends Application {
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
    private PasswordField password_Field;

    public void login_btn(ActionEvent event) {

    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 603, 562);
        stage.setTitle("90'VISION!");
        stage.setScene(scene);
    }
}