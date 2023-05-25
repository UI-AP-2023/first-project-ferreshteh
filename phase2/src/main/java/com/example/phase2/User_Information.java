package com.example.phase2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.user.Customer;
import view.Messages;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

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
    private TextField username_textField;
    @FXML
    private TextField phone_textField;

    @FXML
    private TextField email_textField;

    @FXML
    private TextField Password_textField;


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
        username_textField.setVisible(true);
        String input = username_textField.getText();
        username_textField.setText(input);
        userName_lbl.setText(input);
        customer.setId(input);
    }

    @FXML
    void editPhone(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("12 digits");
        alert.show();

        phone_textField.setVisible(true);
        String input = phone_textField.getText();
        phone_textField.setText(input);
        phone_lbl.setText(input);

        //--------------------------
        Pattern pattern22 = Pattern.compile("^098\\d{8}");
        Matcher matcher2 = pattern22.matcher(input);
        if (matcher2.find()) {
            customer.setPhone(input);
        }
    }

    @FXML
    void editEmail(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("capital and small latter's");
        alert.show();

        email_textField.setVisible(true);
        String input = email_textField.getText();
        email_textField.setText(input);
        email_lbl.setText(input);
        //---------------------------
        Pattern pattern = Pattern.compile("^[A-Z].*[1-9]@+.*gmail.com$");
        Matcher matcher1 = pattern.matcher(input);
        if (matcher1.find()) {
            customer.setEmail(input);
        }
    }

    @FXML
    void editPassword(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("at least 8 character contains number and latter ");
        alert.show();

        Password_textField.setVisible(true);
        String input = Password_textField.getText();
        Password_textField.setText(input);
        password_lbl.setText(input);

        //------------------------------
        Pattern pattern1 = Pattern.compile("\\S{8,}$");
        Pattern pattern2 = Pattern.compile("[A-Z]+");
        Pattern pattern3 = Pattern.compile("[a-z]+");
        Matcher matcher31 = pattern1.matcher(input);
        Matcher matcher32 = pattern2.matcher(input);
        Matcher matcher33 = pattern3.matcher(input);
        if (Stream.of(matcher31, matcher32, matcher33).allMatch(Matcher::find)) {
            customer.setPassWord(input);
        }
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
