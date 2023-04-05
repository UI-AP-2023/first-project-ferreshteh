package controller;

import model.articles.*;
import model.others.Factor;
import model.others.Score;
import model.user.Customer;
import model.user.SuperAdmin;
import view.Messages;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

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
                    if (customer.getCredit() >= Double.parseDouble(article.getPrice()) * (Integer.parseInt(id[j + 1]))) {
                        if (Integer.parseInt(id[j + 1]) <= article.getExist()) {
                            customer.lowerCredit(Double.parseDouble(article.getPrice()) * Integer.parseInt(id[j + 1]));
                            price += Double.parseDouble(article.getPrice()) * Integer.parseInt(id[j + 1]);
                            idFactor = String.valueOf(article.getNumber()) + idFactor;
                            factor.setArticles(article);
                            for (int z = 0; z < SuperAdmin.getInstance().getArticles().size(); z++) {
                                if (SuperAdmin.getInstance().getArticles().get(z).getId().equals(id[j])) {
                                    SuperAdmin.getInstance().getArticles().get(z).setExist(Integer.parseInt(id[j + 1]));
                                }
                            }
                            customer.getFactors().add(factor);

                            factor.setIdFactor(idFactor);
                            factor.setCash(price);
                            factor.setHistory(history);
                            LoginController.getInstance().getAllCostumers().add(customer);
                            factor.setStrings(id);
                        }

                    }

                }
            }
        }
    }

    public String factors(Customer customer) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < customer.getFactors().size(); i++) {
            str.append(customer.getFactors().get(i).order());
        }
        return String.valueOf(str);
    }

    public String StringViewCart(Customer customer) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < customer.getCart().size(); i++) {
            str.append(customer.getCart().get(i).toString());
        }
        return String.valueOf(str);
    }

    public void upperCredit(Customer customer, double credit, String password) {
        if (customer.getPassWord().equals(password)) {
            customer.setDefaultCredit(credit);
            customer.setCreditRequest(true);
            Messages.getInstance().printWait();
        }
    }

    public void checkRegexCredit(Customer customer, String[] string, double credit) {
        // creditNumber
        // cvv2
        // password
        Pattern pattern = Pattern.compile("^6037\\d{4}$");
        Matcher matcher1 = pattern.matcher(string[0]);
        Pattern pattern22 = Pattern.compile("^0\\d{3,}");
        Matcher matcher2 = pattern22.matcher(string[1]);

        Pattern pattern1 = Pattern.compile("\\S{8,}$");
        Pattern pattern2 = Pattern.compile("[A-Z]+");
        Pattern pattern3 = Pattern.compile("[a-z]+");
        Matcher matcher31 = pattern1.matcher(string[2]);
        Matcher matcher32 = pattern2.matcher(string[2]);
        Matcher matcher33 = pattern3.matcher(string[2]);
        if (Stream.of(matcher1, matcher31, matcher32, matcher33, matcher2).allMatch(Matcher::find)) {
            upperCredit(customer, credit, string[2]);
        }
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

    public Article search(String name) {
        for (Article article : SuperAdmin.getInstance().getArticles()) {
            if (article.getId().equals(name)) {
                return article;
            }
        }
        return null;
    }

    public String changeInfo(Customer customer, String function) {
        String id = "";
        String info = "";
        String[] strings = function.split("\\s+");
        //change name to ali
        if (strings[1].equalsIgnoreCase("password")) {
            Pattern pattern1 = Pattern.compile("\\S{8,}$");
            Pattern pattern2 = Pattern.compile("[A-Z]+");
            Pattern pattern3 = Pattern.compile("[a-z]+");
            Matcher matcher31 = pattern1.matcher(strings[3]);
            Matcher matcher32 = pattern2.matcher(strings[3]);
            Matcher matcher33 = pattern3.matcher(strings[3]);
            if (Stream.of(matcher31, matcher32, matcher33).allMatch(Matcher::find)) {
                info = customer.getEmail().substring(0, 3);
                info = info + customer.getPhone().substring(8, 11);
                info = info + strings[3];
                customer.setInfo(info);
                customer.setPassWord(strings[3]);
                id = customer.getStatic() + info + customer.getStatic();
                customer.setId(id);
                Messages.getInstance().printId(id);

            }
        } else if (strings[1].equalsIgnoreCase("email")) {
            customer.setEmail(strings[3]);
            Pattern pattern = Pattern.compile("^[A-Z].*[1-9]@+.*gmail.com$");
            Matcher matcher1 = pattern.matcher(strings[3]);
            if (matcher1.find()) {
                info = strings[3];
                info = info + customer.getPhone();
                info += customer.getPassWord();
                customer.setEmail(strings[3]);
                customer.setInfo(info);
                id = customer.getStatic() + info + customer.getStatic();
                customer.setId(id);
                Messages.getInstance().printId(id);
            }
        } else if (strings[1].equalsIgnoreCase("phone")) {
            Pattern pattern22 = Pattern.compile("^0913\\d{7}");
            Matcher matcher2 = pattern22.matcher(strings[3]);
            if (matcher2.find()) {
                info = customer.getEmail();
                info += strings[3];
                info += customer.getPassWord();
                customer.setInfo(info);
                customer.setPhone(strings[3]);
                id = customer.getStatic() + info + customer.getStatic();
                customer.setId(id);
                Messages.getInstance().printId(id);
            }
        }
        return id;
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
                    SuperAdmin.getInstance().getArticles().get(i).setAverage(Float.parseFloat(strings[1]) / score.getNumber());
                    break;
                }
            }

        }
    }

    public void addCart(Customer customer, String[] id, int numberOfOrder) {
        Article article;
        for (int j = 0; j <= id.length / 2; j = j + 2) {
            for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
                article = (SuperAdmin.getInstance().getArticles().get(i));
                if (article.getId().equals(id[j])) {
                    if (article.getExist() >= Integer.parseInt(id[j + 1])) {
                        customer.setCart(article);
                        customer.setOrder(id, numberOfOrder);
                    }
                }
            }
        }
    }
}
