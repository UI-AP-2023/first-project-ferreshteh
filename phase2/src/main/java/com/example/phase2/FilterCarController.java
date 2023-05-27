package com.example.phase2;

import controller.SuperCon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import model.articles.Article;
import model.articles.Bicycle;
import model.articles.Machine;
import model.others.Comment;
import model.user.SuperAdmin;

import java.net.URL;
import java.util.ResourceBundle;

public class FilterCarController implements Initializable {
    @FXML
    private TableView<Article> table;

    @FXML
    private TableColumn<Article, Integer> exist;

    @FXML
    private TableColumn<Article, Float> type;

    @FXML
    private TableColumn<Article, String> id;

    @FXML
    private TableColumn<Article, String> price;

    @FXML
    private TableColumn<Article, String> name;

    @FXML
    private TextField search_textField;


    @FXML
    private ImageView search_image;
    ObservableList<Article>cars= FXCollections.observableArrayList(SuperCon.getInstance().filterCar());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        name.setCellValueFactory(new PropertyValueFactory<Article,String >("name"));
        price.setCellValueFactory(new PropertyValueFactory<Article,String>("price"));
        exist.setCellValueFactory(new PropertyValueFactory<Article,Integer>("exist"));
        id.setCellValueFactory(new PropertyValueFactory<Article,String>("id"));
        type.setCellValueFactory(new PropertyValueFactory<Article,Float>("average"));
        table.setItems(cars);

for(int i=0;i<cars.size();i++){
    if(cars.get(i) instanceof Machine){
        System.out.println(cars.get(i).getName());
    }
}

        System.out.println(SuperAdmin.getInstance().getArticles().size());
    }
}
