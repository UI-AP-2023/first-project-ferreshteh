package com.example.phase2;

import controller.ArtContoroller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.articles.Article;
import model.articles.Machine;
import model.others.Comment;
import model.user.Customer;
import model.user.SuperAdmin;
import view.ArticleShow;

import java.net.URL;
import java.util.ResourceBundle;

public class FilterController implements Initializable {

    //    @FXML
//    private TableView<?> table;
    @FXML
    private Label comment_lbl;

    @FXML
    private TextField comment_text;

    //    @FXML
//    private TableColumn<?, ?> exist;
  static   Customer customer;

//    @FXML
//    private TableColumn<?, ?> type;
//
//    @FXML
//    private TableColumn<?, ?> id;
//
//    @FXML
//    private TableColumn<?, ?> price;
//
//    @FXML
//    private TableColumn<?, ?> name;

    @FXML
    private TextField search_textField;

    @FXML
    private ImageView search_image;

    @FXML
    private TextField comment_field;

    @FXML
    private Label show_lbl;
    @FXML
    private ImageView comment_image;
    // ObservableList<Article> cars = FXCollections.observableArrayList(SuperCon.getInstance().filterCar());
    @FXML
    private ListView<String> list;
    private final String[] toString = new String[SuperAdmin.getInstance().getArticles().size()];
    String chosen;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
            toString[i] = SuperAdmin.getInstance().getArticles().get(i).getName();
        }
        list.getItems().addAll(toString);
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                chosen=list.getSelectionModel().getSelectedItem();
                int check;
                for(int i=0;i<SuperAdmin.getInstance().getArticles().size();i++){
                    if(SuperAdmin.getInstance().getArticles().get(i).getId().equals(chosen)){
                        check=i;
                        break;
                    }
                }
                show_lbl.setText(chosen);
            }
        });

        for (int i = 0; i <toString.length; i++) {

                System.out.println();

        }

//        System.out.println(SuperAdmin.getInstance().getArticles().size());
//        comment_image.setOnMouseClicked(event -> {
//            String input = comment_field.getText();
//            model.others.Comment comment = new Comment(customer, "waiting", ArticleShow.getInstance().getIdArticle(), input);
//            SuperAdmin.getInstance().setComments(comment);
//        });
//        search_image.setOnMouseClicked(event -> {
//            String input = search_textField.getText();
//            Article article = ArtContoroller.getInstance().search(input);
//            if (article != null) {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("id not fount");
//                alert.show();
//            } else {
//                try {
//                    new Search_Article().start((Stage) search_img.getScene().getWindow());
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
    }

}
