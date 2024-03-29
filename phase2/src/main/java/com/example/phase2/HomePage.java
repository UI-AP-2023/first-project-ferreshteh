package com.example.phase2;

import controller.LoginController;
import controller.SuperCon;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.articles.Bicycle;
import model.others.OffProduct;
import model.user.Customer;
import model.user.SuperAdmin;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;

public class HomePage extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Register.class.getResource("homePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 603, 562);
        stage.setTitle("90'VISION!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) throws ParseException {
        Customer customer = new Customer("Ali678Alii1234", "user", "09132345678", "Alii123@gmail.com", "Alii1234");
        customer.setId("id1");
        LoginController.getInstance().getAllCostumers().add(customer);
        customer.setCredit(20000);
        ShoppingController.customer=customer;
        //-----------------------------------------
        SuperCon.getInstance().productManagement("add pen penName 10 5 blue vcxs");
        SuperCon.getInstance().productManagement("add computer co1 23 4 mkj 500 10 20 30");
        //SuperCon.getInstance().productManagement("add meal chips 2000 6 22/10/1381 19/12/1381");
        Bicycle bicycle = new Bicycle("1", "1", "1", 10, 5, "Vehicle", "1", "hybrid");
        bicycle.setId("id1");
        SuperAdmin.getInstance().addArticle(bicycle);
        SuperCon.getInstance().productManagement("add flash flash1 4100 7 12 10 23 700 usb1");
        SuperCon.getInstance().productManagement("add noteBook note1 54 4 typePaper 100 iran");
        SuperCon.getInstance().productManagement("add noteBook note2 100 7 pelastik 200 eragh");
        SuperCon.getInstance().productManagement("add machine bvw 700 4 mnb 10.2 true");
        //-----------------------------------------

        launch(args);
    }
}
