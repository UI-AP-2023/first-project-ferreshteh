package com.example.phase2;

import com.jfoenix.controls.JFXButton;
import controller.ArtContoroller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.others.Score;
import model.user.Customer;
import model.user.SuperAdmin;

import java.net.URL;
import java.util.ResourceBundle;

public class FactorsController implements Initializable {
    @FXML
    private ListView<String> list;

    @FXML
    private AnchorPane score_pane;

    @FXML
    private ImageView score_image;

    @FXML
    private TextField id_textField;

    @FXML
    private TextField score_textField;
    @FXML
    private JFXButton save_btn;

    @FXML
    private Label show_lbl;
    @FXML
    private ImageView firstScore_pane;
    static Customer customer;
    private final String[] toString = new String[customer.getFactors().size()];
    String chosen;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        score_pane.setVisible(false);
        firstScore_pane.setOnMouseClicked(event -> {
        score_pane.setVisible(true);
        firstScore_pane.setVisible(false);
    //----------------------------------------------------------------
        });
        for (int i = 0; i < customer.getFactors().size(); i++) {
            toString[i] = customer.getFactors().get(i).getIdFactor();
        }
        list.getItems().addAll(toString);
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                chosen=list.getSelectionModel().getSelectedItem();
                int check = 0;
                for(int i=0;i<customer.getFactors().size();i++){
                    if(customer.getFactors().get(i).getIdFactor().equals(chosen)){
                        check=i;
                        break;
                    }
                }
                show_lbl.setText(customer.getFactors().get(check).printArticles());
            }
        });
        //---------------------------------------------------------------------
        save_btn.setOnMouseClicked(event -> {
            String function="";
            function=id_textField.getText();
            ArtContoroller.getInstance().score(customer,function);
        });
    }
}
