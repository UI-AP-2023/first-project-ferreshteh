package controller;

import model.articles.Article;
import model.articles.Bicycle;
import model.articles.Meal;
import model.articles.NoteBook;
import model.others.Factor;
import model.user.Customer;
import model.user.SuperAdmin;

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

    public void shopping(String history, Customer customer, String[] id) {
        Article article;
        String idFactor = "";
        double price = 0;
        for (int i = 0; i < LoginController.getInstance().getAllCostumers().size(); i++) {
            if (LoginController.getInstance().getAllCostumers().get(i).getId().equals(customer.getId())) {
                customer = LoginController.getInstance().getAllCostumers().get(i);
                LoginController.getInstance().getAllCostumers().remove(LoginController.getInstance().getAllCostumers().get(i));
            }
        }
        Factor factor = new Factor("123", "123", 120);
        for (int j = 0; j < id.length; j = j + 2) {
            for (int i = 0; i < customer.getCart().size(); i++) {
                if (customer.getCart().get(i).getId().equals(id[j])) {
                    article = customer.getCart().get(i);
                    customer.getCart().remove(article);
                    customer.lowerCredit(Double.parseDouble(article.getPrice()) * Integer.parseInt(id[j + 1]));
                    price += Double.parseDouble(article.getPrice()) * Integer.parseInt(id[j + 1]);
                    idFactor = String.valueOf(article.getNumber()) + idFactor;
                    factor.setArticles(article);
                    for (int z = 0; z < SuperAdmin.getInstance().getArticles().size(); z++) {
                        if (SuperAdmin.getInstance().getArticles().get(z).getId().equals(id[j])) {
                            SuperAdmin.getInstance().getArticles().get(z).setExist(Integer.parseInt(id[j + 1]));
                        }
                    }
                }
            }
        }
        factor.setIdFactor(idFactor);
        factor.setCash(price);
        factor.setHistory(history);
        LoginController.getInstance().getAllCostumers().add(customer);
    }

    public void filterPrice(String function) {
        String[] strings = function.split("-");
        ArrayList<Article> newArt = new ArrayList<>();
        for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
            double articlePri = Double.parseDouble(SuperAdmin.getInstance().getArticles().get(i).getPrice());
            if (articlePri <= Double.parseDouble(strings[1]) && articlePri >= Double.parseDouble(strings[0])) {
                newArt.add(SuperAdmin.getInstance().getArticles().get(i));
            }
        }
        SuperAdmin.getInstance().setArticles(newArt);
    }

    public void filterTypeOfBicycle(String type) {
        ArrayList<Article> newArt = new ArrayList<>();
        for (Article article : SuperAdmin.getInstance().getArticles()) {
            if (article instanceof Bicycle) {
                if (article.getType().equals(type)) {
                    newArt.add(article);
                }
            }
        }
        SuperAdmin.getInstance().setArticles(newArt);
    }

    public void filterExist(String bool) {
        ArrayList<Article> newArt = new ArrayList<>();
        for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
            if (SuperAdmin.getInstance().getArticles().get(i).getExist() != 0) {
                newArt.add(SuperAdmin.getInstance().getArticles().get(i));
            }
        }
        SuperAdmin.getInstance().setArticles(newArt);
    }

    public void filterExpiration(String ex) {
        ArrayList<Article> newArt = new ArrayList<>();
        for (Article article : SuperAdmin.getInstance().getArticles()) {
            if (article instanceof Meal) {
                if (((Meal) article).getExpiration().equalsIgnoreCase(ex)) {
                    newArt.add(article);
                }
            }

        }
        SuperAdmin.getInstance().setArticles(newArt);
    }

    public void filterNoteNumber(int number) {
        ArrayList<Article> newArt = new ArrayList<>();
        for (Article article : SuperAdmin.getInstance().getArticles()) {
            if (article instanceof NoteBook) {
                if (((NoteBook) article).getNumPaper() == number) {
                    newArt.add(article);
                }
            }
        }


        SuperAdmin.getInstance().setArticles(newArt);
    }

    public Article search(String id) {
        for (Article article : SuperAdmin.getInstance().getArticles()) {
            if (article.getId().equals(id)) {
                return article;
            }
        }
        return null;
    }
}
