package com.example.phase2;

import controller.ArtContoroller;
import controller.SuperCon;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
   static String type;
//   public Class getType(){
//       return (type.)
//   }

    @FXML
    private TextField comment_field;

    @FXML
    private Label showName_lbl;

    @FXML
    private Label showID_lbl;

    @FXML
    private Label showPrice_lbl;

    @FXML
    private Label showExist_lbl;
    @FXML
    private ImageView comment_image;
    // ObservableList<Article> cars = FXCollections.observableArrayList(SuperCon.getInstance().filterCar());
    @FXML
    private ListView<String> list;
    private final String[] toString = new String[SuperCon.getInstance().filterCar().size()];
    String chosen;
    @FXML
    private ImageView lastPage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < SuperCon.getInstance().filterCar().size(); i++) {
            toString[i] = SuperCon.getInstance().filterCar().get(i).getId();
        }
        list.getItems().addAll(toString);
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                chosen=list.getSelectionModel().getSelectedItem();
                int check = 0;
                for(int i=0;i<SuperAdmin.getInstance().getArticles().size();i++){
                    if(SuperAdmin.getInstance().getArticles().get(i).getId().equals(chosen)){
                        check=i;
                        break;
                    }
                }
                showName_lbl.setText(SuperAdmin.getInstance().getArticles().get(check).getName());
                showExist_lbl.setText(String.valueOf(SuperAdmin.getInstance().getArticles().get(check).getExist()));
                showID_lbl.setText(SuperAdmin.getInstance().getArticles().get(check).getId());
                showPrice_lbl.setText(SuperAdmin.getInstance().getArticles().get(check).getPrice());
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
    @FXML public void lastPage(MouseEvent event) throws Exception {
        new MainPage().start((Stage) lastPage.getScene().getWindow());
    }

}
