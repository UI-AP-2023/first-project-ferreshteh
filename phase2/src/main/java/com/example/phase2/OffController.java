package com.example.phase2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.user.Customer;

import java.net.URL;
import java.util.ResourceBundle;

public class OffController implements Initializable {
    @FXML
    private Rectangle rectangle;

    @FXML
    private Label off_lbl;

    @FXML
    private TableView<?> table;

    @FXML
    private ImageView lastPage_btn;
    static Customer customer;
    private Off off;

    public Off getOff() {
        return off;
    }

    public void setOff(Off off) {
        this.off = off;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void lastPage(MouseEvent event) throws Exception {
        new MainPage().start((Stage) lastPage_btn.getScene().getWindow());
    }
}
