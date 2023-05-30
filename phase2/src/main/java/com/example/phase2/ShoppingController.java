package com.example.phase2;

import com.jfoenix.controls.JFXButton;
import controller.UserController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.articles.Article;
import model.user.Customer;
import model.user.SuperAdmin;

import java.net.URL;
import java.util.ResourceBundle;

public class ShoppingController implements Initializable {

    @FXML
    private ListView<String> list;

    @FXML
    private AnchorPane ArticleShow;
    static Customer customer;

    @FXML
    private JFXButton delete_btn;
    private final String[] toString = new String[customer.getCart().size()];
    String chosen;
    @FXML
    private Label show_lbl;
    @FXML
    private ImageView last_btn;
    @FXML
    private Label name_lbl;
    @FXML
    private JFXButton buy_btn;

    @FXML
    private Label price_lbl;

    @FXML
    private Label id_lbl;

    @FXML
    private Label exist_lbl;

    @FXML
    private Label name2_lbl;

    @FXML
    private Label price2_lbl;

    @FXML
    private Label id2_lbl;

    @FXML
    private Label exist2_lbl;
    Article article;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list.setVisible(true);
        ArticleShow.setVisible(true);
        for (int i = 0; i < customer.getCart().size(); i++) {
            toString[i] = customer.getCart().get(i).toString();
        }
        list.getItems().addAll(toString);
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                chosen = list.getSelectionModel().getSelectedItem();
                for (int i = 0; i < customer.getCart().size(); i++) {
                    if (customer.getCart().get(i).toString().equals(chosen)) {
                        article = customer.getCart().get(i);
                    }
                }
                name2_lbl.setText(article.getName());
                price2_lbl.setText(article.getPrice());
                exist2_lbl.setText(String.valueOf(article.getExist()));
                id2_lbl.setText(article.getId());
            }
        });
//        list.setOnMouseClicked(event -> {
//            if (list.isVisible()) {
//                ArticleShow.setVisible(true);
//                list.setVisible(false);
//            } else {
//                ArticleShow.setVisible(false);
//                list.setVisible(true);
//            }
//        });
        delete_btn.setOnMouseClicked(event -> {
            customer.getCart().remove(article);
        });
        buy_btn.setOnMouseClicked(event -> {
           if( UserController.getInstance().shoppingCart(customer)){
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
               alert.setContentText("successful shopping");
               alert.show();
           }
            else  {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("not enough money");
                alert.show();
            }
        });
    }
    @FXML
    public void lastPage(MouseEvent event) throws Exception {
        new MainPage().start((Stage) last_btn.getScene().getWindow());
    }
}
