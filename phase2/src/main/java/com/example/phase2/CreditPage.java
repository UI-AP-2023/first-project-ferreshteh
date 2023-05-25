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

import java.util.InputMismatchException;
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
    Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("creditPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 603, 562);
        stage.setTitle("90'VISION!");
        stage.setScene(scene);
        this.stage=stage;
    }

    @FXML
    public void check(MouseEvent event) {
        if (UserController.getInstance().checkRegexCredit(customer, string, credit)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText(String.valueOf(customer.getCredit()));
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("try again");
            alert.show();
        }
    }

    @FXML
    public void getAmount(MouseEvent event) throws Exception {
        try {
            credit = Double.parseDouble(amount_textField1.getText());
        }
        catch (InputMismatchException exception){
            new CreditPage().start((stage));
        }
        finally {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.show();
        }

    }
}
