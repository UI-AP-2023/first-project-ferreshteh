package com.example.phase2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.user.Customer;

import java.io.IOException;

public class User_Information extends Application {
    Customer customer;
    @FXML
    private Button editUser_btn;

    @FXML
    private Button editPhone_btn;

    @FXML
    private Button editEmail_btn;

    @FXML
    private Button editPassword_btn;
    @FXML
    private Label phone_lbl;
    @FXML
    private Label password_lbl;

    @FXML
    private Label userName_lbl;

    @FXML
    private Label email_lbl;
    @FXML
    private Button showUserName_btn;

    @FXML
    private Button showPhone_btn;

    @FXML
    private Button showEmail_btn;

    @FXML
    private Button showPassword_btn;


    @FXML
    void showUserName(MouseEvent event) {
        userName_lbl.setText("hghv");
    }
    @FXML
    void showEmail(MouseEvent event) {
email_lbl.setText(customer.getEmail());
    }

    @FXML
    void showPassword(MouseEvent event) {
password_lbl.setText(customer.getPassWord());
    }

    @FXML
    void showPhone(MouseEvent event) {
phone_lbl.setText(customer.getPhone());
    }
    @FXML
    void editUserName(MouseEvent event) {
       userName_lbl.setText(userName_lbl.getText());
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("user'Information.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 754, 573);
        stage.setTitle("90'VISION!");
        stage.setScene(scene);
        stage.show();
    }
}
