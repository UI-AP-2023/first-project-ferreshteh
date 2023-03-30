package controller;

import model.articles.Article;
import model.user.Customer;
import model.user.SuperAdmin;
import controller.LoginController;
import view.Login;

import java.util.ArrayList;

public class SuperCon {
    String adminName;
    private static SuperCon instance;
    private  SuperCon(String info) {
        adminName=info;    }

    public static SuperCon getInstance() {
        if (instance == null) {
            instance = new SuperCon("Admin");
        }
        return instance;
    }


}
