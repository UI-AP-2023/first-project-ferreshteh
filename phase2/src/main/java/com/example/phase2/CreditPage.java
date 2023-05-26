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

    String[] string=new String[3];
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
        stage.show();
    }

    @FXML
    public void check(MouseEvent event) {
        if (UserController.getInstance().checkRegexCredit(customer, string, credit)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText(String.valueOf(customer.getCredit()));
            System.out.println(string);
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
            String input=amount_textField1.getText();
            credit = Double.parseDouble(input);
        }
        catch (InputMismatchException exception){
            new CreditPage().start((stage));
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("amount");
            alert.show();
            System.out.println(credit);
        }
//        finally {
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.show();
//        }

    }
    //------------------------------
    @FXML
    public void getAccount(MouseEvent event) throws Exception {
        try {
            string[0]=accountNumber_textField.getText();
        }
        catch (InputMismatchException exception){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.show();
            new CreditPage().start((stage));
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("account Number");
            alert.show();
        }
//        finally {
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.show();
//        }

    }//------------------------
    @FXML
    public void getCvv(MouseEvent event) throws Exception {
        try {
            string[1]=cvv_textField.getText();
        }
        catch (InputMismatchException exception){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.show();
            new CreditPage().start((stage));
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("cvv Number");
            alert.show();
        }
//        finally {
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.show();
//        }

    }
    //---------------------------------------------------
    @FXML
    public void getExpirationMonth(MouseEvent event) throws Exception {
        try {
            String mounth=(month_textField.getText());
        }
        catch (InputMismatchException exception){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.show();
            new CreditPage().start((stage));
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("expiration Month Number");
            alert.show();
        }
//        finally {
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.show();
//        }

    }//-----------------------------------------------
    @FXML
    public void getExpirationYear(MouseEvent event) throws Exception {
        try {
            String year=year_textField.getText();

        }
        catch (InputMismatchException exception){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.show();
            new CreditPage().start((stage));
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("expiration year Number");
            alert.show();
        }
//        finally {
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.show();
//        }

    }
    //---------------------------------------
    @FXML
    public void getPassword(MouseEvent event) throws Exception {
            string[2]=passWord_textField.getText();
    }
}