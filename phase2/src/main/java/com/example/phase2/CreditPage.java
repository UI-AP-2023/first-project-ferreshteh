package com.example.phase2;

import controller.UserController;
import javafx.application.Application;
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CreditPage extends Application {

    @FXML
    private Label account_lbl;

    @FXML
    private TextField accountNumber_textField;

    @FXML
    private TextField cvv_textField;

    @FXML
    private TextField year_textField;

    @FXML
    private TextField month_textField;

    @FXML
    private TextField passWord_textField;

    @FXML
    private Label cvv_lbl;

    @FXML
    private Label expiration_lbl;

    @FXML
    private Label password_lbl;

    @FXML
    private Button peyment_btn;

    @FXML
    private Button refuse_btn;
    @FXML
    private Label amount_lbl;

    @FXML
    private TextField amount_textField1;

    String[] string;
    Customer customer;
    double credit;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("creditPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 603, 562);
        stage.setTitle("90'VISION!");
        stage.setScene(scene);
    }
    @FXML
    public void check(MouseEvent event){
        Pattern pattern = Pattern.compile("^6037\\d{4}$");
        Matcher matcher1 = pattern.matcher(string[0]);
        Pattern pattern22 = Pattern.compile("^0\\d{3,}");
        Matcher matcher2 = pattern22.matcher(string[1]);
        Pattern pattern1 = Pattern.compile("\\S{8,}$");
        Pattern pattern2 = Pattern.compile("[A-Z]+");
        Pattern pattern3 = Pattern.compile("[a-z]+");
        Matcher matcher31 = pattern1.matcher(string[2]);
        Matcher matcher32 = pattern2.matcher(string[2]);
        Matcher matcher33 = pattern3.matcher(string[2]);
        if (Stream.of(matcher1, matcher31, matcher32, matcher33, matcher2).allMatch(Matcher::find)) {
            Messages.getInstance().printWait();
           UserController.getInstance(). upperCredit(customer, credit, string[2]);
        }
        else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("unsuccessful");
            alert.setContentText("check again");
            alert.show();
        }
    }
}
