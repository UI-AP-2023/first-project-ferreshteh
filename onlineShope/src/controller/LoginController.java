package controller;

import model.user.*;
import model.articles.*;
import model.others.*;
import view.Login;
import view.MenoUser;
import view.Messages;

import java.util.ArrayList;

public class LoginController {
    private ArrayList<Customer> allCostumers = new ArrayList<>();

    public void addCostumer(Customer customer) {
        allCostumers.add(customer);
    }


    Messages messages = new Messages();

    public void setUserInfoEnter(String info) {
        MenoUser menoUser = new MenoUser();
        int check = 0;
        for (int i = 0; i < allCostumers.size(); i++) {
            if (allCostumers.get(i).getInfo().equals(info)) {
                menoUser.menoUser();
                check++;
                break;
            }
        }
        if (check == 0) {
            messages.printError();
        }
    }

    public void setUserInfoRegister(String info) {
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
                    request.setArticles(null);
                }
            }
        } else {

            if (Login.getInstance().free) {

            } else {
                Request request = new Request();
                request.setInfo(info);
Login.getInstance().firstMeno();
            }

    }}}
