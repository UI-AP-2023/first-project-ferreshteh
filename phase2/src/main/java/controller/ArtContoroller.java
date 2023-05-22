package controller;

import model.articles.*;
import model.others.Score;
import model.user.Customer;
import model.user.SuperAdmin;
import view.Messages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ArtContoroller {
    private static ArtContoroller instance;

    private ArtContoroller(String info) {
        super();
    }

    public static ArtContoroller getInstance() {
        if (instance == null) {
            instance = new ArtContoroller("admin") {

            };
        }
        return instance;
    }

   // ArrayList<Article> articles = new ArrayList<>();
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

    public void generalFilter(String type) {
        Article article;
        ArrayList<Article> newArraylist = new ArrayList<>();
        int check = 0;
        if (Type.DIGITAL.name().equalsIgnoreCase(type)) {
            check++;
        } else if (Type.MEAL.name().equalsIgnoreCase(type)) {
            check++;
        } else if (Type.VEHICLE.name().equalsIgnoreCase(type)) {
            check++;
        } else if (Type.STATIONARY.name().equalsIgnoreCase(type)) {
            check++;
        } else {
            Messages.getInstance().printError();
        }
        if (check == 1) {
            for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
                article = SuperAdmin.getInstance().getArticles().get(i);
                if (article.getType().equalsIgnoreCase(type)) {
                    newArraylist.add(article);
                }
            }
            SuperAdmin.getInstance().setArticles(newArraylist);
        }
    }
    public void unFiltering(){

        SuperAdmin.getInstance().setArticles(SuperAdmin.getInstance().getSpareArt());
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
                LocalDate date = LocalDate.parse(ex, formatter);
                if (((Meal) article).getExpiration()==date) {
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

    public Article search(String name) {
        for (Article article : SuperAdmin.getInstance().getArticles()) {
            if (article.getId().equals(name)) {
                return article;
            }
        }
        return null;
    }
    public void score(Customer customer, String function) {
        Article article;
        Score score = null;
        int check = 0;
        String[] strings = function.split("\\s+");
        //20 to id
        for (int i = 0; i < customer.getFactors().size(); i++) {
            for (int j = 0; j < customer.getFactors().get(i).getArticles().size(); j++) {
                if (customer.getFactors().get(i).getArticles().get(j).getId().equals(strings[2])) {
                    article = customer.getFactors().get(i).getArticles().get(j);
                    score = new Score(Double.parseDouble(strings[0]), customer, article);
                    article.setAverage((article.getAverage() + Float.parseFloat(strings[0])) / score.getNumber());


                    check++;
                    break;
                }
            }
        }
        if (check == 1) {
            for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
                if (SuperAdmin.getInstance().getArticles().get(i).getId().equals(strings[2])) {
                    article = SuperAdmin.getInstance().getArticles().get(i);
                    article.setAverage((article.getAverage() + Float.parseFloat(strings[0])) / score.getNumber());
                    SuperAdmin.getInstance().getArticles().get(i).setAverage(SuperAdmin.getInstance().getArticles().get(i).getAverage()+Float.parseFloat(strings[0]) / score.getNumber());
                    break;
                }
            }

        }
    }
}
