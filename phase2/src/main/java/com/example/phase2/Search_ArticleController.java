package com.example.phase2;

import controller.UserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.articles.Article;
import model.others.Comment;
import model.user.Customer;
import model.user.SuperAdmin;
import view.ArticleShow;
import view.SuperMeno;

import java.net.URL;
import java.util.ResourceBundle;

public class Search_ArticleController implements Initializable {
    static Article article;
    static Customer customer;
    @FXML
    public Label Showscore_lbl;

    @FXML
    private Label showName_lbl;

    @FXML
    private Label showId_lbl;

    @FXML
    private Label showPrice_lbl;

    @FXML
    private Label showExist_lbl;


    @FXML
    private ImageView lastPage_image;

    @FXML
    private ListView<String> list;


    @FXML
    private Button add_btn;
    @FXML
    private ImageView exit_image;

    @FXML
    private Button comment_btn;

    @FXML
    private TextField comment_text;
    private final String[] toString = new String[SuperAdmin.getInstance().getArticles().size()];
    String chosen;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showId_lbl.setText(article.getId());
        showName_lbl.setText(article.getClass().getName());
        showExist_lbl.setText(article.getPrice());
        showPrice_lbl.setText(article.getPrice());
        Showscore_lbl.setText(String.valueOf(article.getAverage()));
        for (int i = 0; i < article.getComments().size(); i++) {
            toString[i] = article.getComments().get(i).getText();
        }
        list.getItems().addAll(toString);
    }

    @FXML
    public void lastPage(MouseEvent event) throws Exception {
        new MainPage().start((Stage) lastPage_image.getScene().getWindow());
    }

    @FXML
    public void comment(MouseEvent event) {
        if (customer == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("null customer ");
            alert.show();
        } else {
            Comment comment = new Comment(customer, "waiting", article.getId(), comment_text.getText());
            SuperAdmin.getInstance().setComments(comment);
          //  comment.setIdAr(article.getId());
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("wait for admin decision ");
            alert.show();
            SuperMeno.getInstance().adminMeno();
        }
    }
    @FXML
    public void add(MouseEvent event) throws Exception {
        String[] id = new String[1];
        id[0] = article.getId();
        UserController.getInstance().addCart(customer, id, 1);
        new Shopping().start((Stage) add_btn.getScene().getWindow());
    }
}
