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

import java.net.URL;
import java.util.ResourceBundle;

public class Search_ArticleController implements Initializable {
    private Article article;
    private Customer customer;
    private String []id=new String[1];

    public String []getId() {
        return id;
    }

    public void setId(String[] id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @FXML
    private Label showName_lbl;

    @FXML
    private Label showId_lbl;

    @FXML
    private Label showPrice_lbl;

    @FXML
    private Label showExist_lbl;

    @FXML
    private Label showScore_lbl;
    @FXML
    private ImageView lastPage_image;
    @FXML
    private TableView<Comment> comments_table;
    @FXML
    private TableColumn<Comment, String> text_column;

    @FXML
    private TableColumn<Comment,String > name_column;


    @FXML
    private Button add_btn;
    @FXML
    private ImageView exit_image;

    @FXML
    private Button comment_btn;

    @FXML
    private TextField comment_text;

    ObservableList<Comment> comments= FXCollections.observableArrayList(article.getComments());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showId_lbl.setText(article.getId());
        showName_lbl.setText(article.getName());
        showExist_lbl.setText(article.getPrice());
        showPrice_lbl.setText(article.getPrice());
        showScore_lbl.setText(String.valueOf(article.getAverage()));
        name_column.setCellValueFactory(new PropertyValueFactory<Comment,String >("name"));
        text_column.setCellValueFactory(new PropertyValueFactory<Comment,String>("text"));
        comments_table.setItems(comments);
        comment_btn.setOnMouseClicked(event -> {
            String input = comment_text.getText();
            model.others.Comment comment = new Comment(customer, "waiting", ArticleShow.getInstance().getIdArticle(),input);
            SuperAdmin.getInstance().setComments(comment);
        });
    }

    @FXML
    public void lastPage(MouseEvent event) throws Exception {
        new MainPage().start((Stage) lastPage_image.getScene().getWindow());
    }
    @FXML
    public void exit(MouseEvent event){

    }
    @FXML
    public void add(MouseEvent event){
        UserController.getInstance().addCart(customer,id,1);
    }
}
