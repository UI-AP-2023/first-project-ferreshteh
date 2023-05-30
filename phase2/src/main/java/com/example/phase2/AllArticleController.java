package com.example.phase2;

import controller.ArtContoroller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.articles.Article;
import model.user.Customer;
import model.user.SuperAdmin;

import java.net.URL;
import java.util.ResourceBundle;

public class AllArticleController implements Initializable {


    @FXML
    private TextField search_textField;

    @FXML
    private ImageView search_image;

    @FXML
    private ListView<String> list;
    public static Customer customer;

    @FXML
    private ImageView last_image;


    private final String[] toString = new String[SuperAdmin.getInstance().getArticles().size()];
    String chosen;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
            toString[i] = SuperAdmin.getInstance().getArticles().get(i).getId();
        }
        list.getItems().addAll(toString);
        search_image.setOnMouseClicked(event -> {
            String input = search_textField.getText();
            Article article = ArtContoroller.getInstance().search(input);
            if (article != null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("id not fount");
                alert.show();
            } else {
                try {
                    new Search_Article().start((Stage) search_image.getScene().getWindow());
                    Search_ArticleController.article=article;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    @FXML
    public void lastPage(MouseEvent event) throws Exception {
        new MainPage().start((Stage) last_image.getScene().getWindow());
    }
}
