package controller;

import model.articles.Article;
import model.others.Factor;
import model.others.Off;
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
    private  boolean off=false;

    public boolean isOff() {
        return off;
    }

    public void setOff(boolean off) {
        this.off = off;
    }

    public void shopping(String history, Customer customer, String[] id) {
        Article article;
        String idFactor = "";
        double price = 0;
        int check=0;
        for (int i = 0; i < LoginController.getInstance().getAllCostumers().size(); i++) {
            if (LoginController.getInstance().getAllCostumers().get(i).getId().equals(customer.getId())) {
                customer = LoginController.getInstance().getAllCostumers().get(i);
              //  LoginController.getInstance().getAllCostumers().remove(LoginController.getInstance().getAllCostumers().get(i));
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
                                check++;
                                customer.lowerCredit(Double.parseDouble(article.getPrice()) * Integer.parseInt(id[j + 1]));
                               // article.lowerExist(Integer.parseInt(id[j + 1]));
                                price += Double.parseDouble(article.getPrice()) * Integer.parseInt(id[j + 1]);
                                idFactor = String.valueOf(article.getNumber()) + idFactor;}
                            else {
                                System.out.println("exist");
                            }
                                factor.setArticles(article);
                            if(check==1){
                                for (int z = 0; z < SuperAdmin.getInstance().getArticles().size(); z++) {
                                    if (SuperAdmin.getInstance().getArticles().get(z).getId().equals(id[j])) {
                                        SuperAdmin.getInstance().getArticles().get(z).lowerExist(Integer.parseInt(id[j + 1]));
                                    }
                                }}
                                customer.getFactors().add(factor);
                                factor.setIdFactor(idFactor);
                                factor.setCash(price);
                                factor.setHistory(history);
                               // LoginController.getInstance().getAllCostumers().add(customer);
                                factor.setStrings(id);
                            } else {
                                Messages.getInstance().print();
                                //System.out.println("credit");
                            }
                        }
                    }
                }
            }
    public String factors(Customer customer) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < customer.getFactors().size(); i++) {
            str.append(customer.getFactors().get(i).order());
            str.append(" ");
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
            customer.setDefaultCredit(credit);
            customer.setCreditRequest(true);
            Messages.getInstance().printWait();
    }
    public void checkRegexCredit(Customer customer, String[] string, double credit) {
        // creditNumber
        // cvv2
        // password
        Pattern pattern = Pattern.compile("\\d{10,}$");
        Matcher matcher1 = pattern.matcher(string[0]);
        Pattern pattern22 = Pattern.compile("^\\d{4}");
        Matcher matcher2 = pattern22.matcher(string[1]);
        Pattern pattern1 = Pattern.compile("\\S{8,}$");
        Pattern pattern2 = Pattern.compile("[A-Z]+");
        Pattern pattern3 = Pattern.compile("[a-z]+");
        Matcher matcher31 = pattern1.matcher(string[2]);
        Matcher matcher32 = pattern2.matcher(string[2]);
        Matcher matcher33 = pattern3.matcher(string[2]);
        if (Stream.of(matcher1, matcher31, matcher32, matcher33, matcher2).allMatch(Matcher::find)) {
            Messages.getInstance().printWait();
            upperCredit(customer, credit, string[2]);
        }
        else {

        }
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
                    else {
                        Messages.getInstance().print();
                    }
                }
            }
        }
    }
}
