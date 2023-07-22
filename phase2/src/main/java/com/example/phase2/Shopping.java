package com.example.phase2;

import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.others.OffProduct;
import model.user.Customer;

import java.time.LocalDate;

public class Shopping extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Register.class.getResource("shopping.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 710, 560);
        stage.setTitle("90'VISION!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        Customer customer = new Customer("Ali678Alii1234", "user", "09132345678", "Alii123@gmail.com", "Alii1234");
        customer.setId("id1");
        LoginController.getInstance().getAllCostumers().add(customer);
        customer.setCredit(20000);
        ShoppingController.customer=customer;
        LocalDate date = LocalDate.now();
        OffProduct offProduct=new OffProduct(50,date,1);
        ShoppingController.customer.getList_Offs().add(offProduct);
        launch(args);}
}
