package com.example.phase2;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Login extends Application {


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
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 603, 562);
        stage.setTitle("90'VISION!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
