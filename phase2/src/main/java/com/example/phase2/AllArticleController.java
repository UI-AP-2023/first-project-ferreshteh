package com.example.phase2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.user.Customer;

import java.net.URL;
import java.util.ResourceBundle;

public class AllArticleController implements Initializable {
    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> exist;

    @FXML
    private TableColumn<?, ?> type;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> price;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TextField search_textField;
    static Customer customer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
