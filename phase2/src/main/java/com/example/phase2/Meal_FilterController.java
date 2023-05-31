package com.example.phase2;

import controller.SuperCon;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.user.Customer;
import model.user.SuperAdmin;

import java.net.URL;
import java.util.ResourceBundle;

public class Meal_FilterController implements Initializable {
    @FXML
    private Label comment_lbl;

    @FXML
    private TextField comment_text;

    //    @FXML
//    private TableColumn<?, ?> exist;
    static Customer customer;

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
    private final String[] toString = new String[SuperCon.getInstance().filterVehicle().size()];
    String chosen;
    @FXML
    private ImageView lastPage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < SuperCon.getInstance().filterVehicle().size(); i++) {
            toString[i] = SuperCon.getInstance().filterVehicle().get(i).getId();
        }
        list.getItems().addAll(toString);
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                chosen=list.getSelectionModel().getSelectedItem();
                int check = 0;
                for(int i = 0; i< SuperAdmin.getInstance().getArticles().size(); i++){
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
    }
    @FXML public void lastPage(MouseEvent event) throws Exception {
        new MainPage().start((Stage) lastPage.getScene().getWindow());
    }
}
