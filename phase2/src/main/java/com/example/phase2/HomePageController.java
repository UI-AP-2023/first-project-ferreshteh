package com.example.phase2;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {
    @FXML
    private JFXButton superAdmin;

    @FXML
    private JFXButton customer_btn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        customer_btn.setOnMouseClicked(event -> {
//            try {
//                new Login().start((Stage) customer_btn.getScene().getWindow());
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        });

    }
    @FXML
    public void loginPage(MouseEvent event) throws Exception {
        new Login().start((Stage) customer_btn.getScene().getWindow());
    }
}
