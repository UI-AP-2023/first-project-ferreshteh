package controller;

import model.user.*;
import model.articles.*;
import model.others.*;
import view.Login;
import view.MenoUser;
import view.Messages;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class LoginController {
    String loginName;
    private static LoginController instance;

    private LoginController(String info) {
        loginName = info;
    }

    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController("LoginController");
        }
        return instance;
    }

    private ArrayList<Customer> allCostumers = new ArrayList<>();

    public void addCostumer(Customer customer) {
        allCostumers.add(customer);
        for (int i = 0; i < SuperAdmin.getInstance().getRequest().size(); i++) {
            if (SuperAdmin.getInstance().getRequest().get(i).getInfo().equals(customer.getInfo())) {
                customer.setCart(SuperAdmin.getInstance().getRequest().get(i).getArticle());
                String str = customer.getInfo();
                str = str + customer.getStatic();
                customer.setId(str);
            }
        }

    }
    // public void addRe


    Messages messages = new Messages();

    public void setUserInfoEnter(String info) {

        int check = 0;
        for (int i = 0; i < allCostumers.size(); i++) {
            if (allCostumers.get(i).getInfo().equals(info)) {
                // menoUser.menoUser();
                check++;
                break;
            }
        }
        if (check == 0) {
            messages.printError();
        }
    }

    public void setUserInfoRegister(String string[]) {
        String info = "";
        Pattern pattern = Pattern.compile("^[A-Z].*[1-9]@+.*gmail.com$");
        Matcher matcher1 = pattern.matcher(string[0]);
        Pattern pattern22 = Pattern.compile("^0913\\d{7}");
        Matcher matcher2 = pattern22.matcher(string[1]);
        Pattern pattern1 = Pattern.compile("\\S{8,}$");
        Pattern pattern2 = Pattern.compile("[A-Z]+");
        Pattern pattern3 = Pattern.compile("[a-z]+");
        Matcher matcher31=pattern1.matcher(string[2]);
        Matcher matcher32=pattern2.matcher(string[2]);
        Matcher matcher33=pattern3.matcher(string[2]);
//if(matcher1.find()){System.out.println("matcher1");}
//if(matcher2.find()){System.out.println("2");}
// if(matcher31.find()){System.out.println("31");}
// if(matcher32.find()){System.out.println("32");}
// if(matcher33.find()){System.out.println("33");}

        if (Stream.of(matcher1, matcher31, matcher32, matcher33, matcher2).allMatch(Matcher::find)) {
            info = string[0].substring(0, 3);
            info = info + string[1].substring(8, 11);
            info = info + string[2];

        }
        else {
            Messages messages1=new Messages();
            messages1.printError();
        }
        int check = 0;
        if (allCostumers.size() != 0) {
            for (int i = 0; i < allCostumers.size(); i++) {
                if (allCostumers.get(i).getInfo().equals(info)) {
                    messages.printError();
                    check++;
                    break;
                }
            }
            if (check == 0) {

                if (Login.getInstance().free) {

                } else {
                    Request request = new Request();
                    request.setInfo(info);
                }
            }
        } else {

            if (Login.getInstance().free) {

            } else {
                Request request = new Request();
                request.setInfo(info);
                SuperAdmin.getInstance().setRequests(request);
                Login.getInstance().firstMeno();
            }

        }
    }
}
