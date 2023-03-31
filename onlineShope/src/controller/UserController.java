package controller;

import model.articles.Article;
import model.user.Customer;

import java.util.ArrayList;

public class UserController {
    private static UserController instance;
    private UserController(String info) {
        super();
    }

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController("admin") {

            };
        }
        return instance;
    }

    ArrayList<Article> articles = new ArrayList<>();

    public void shopping(Customer customer, String[] id) {
        for (int j = 0; j < id.length; j++) {
            for (int i = 0; i < customer.getCart().size(); i++) {
                if (customer.getCart().get(i).getId().equals(id[j])) {
                    articles.add(customer.getCart().get(i));

                }
            }
        }
    customer.setCart(articles);}

}
