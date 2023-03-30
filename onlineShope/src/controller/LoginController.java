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

public class LoginController {
    String loginName;
    private static LoginController instance;
    private  LoginController(String info) {
        loginName=info;
    }

    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController("LoginController") ;
        }
        return instance;
    }
    private ArrayList<Customer> allCostumers = new ArrayList<>();

    public void addCostumer(Customer customer) {
        allCostumers.add(customer);
        for(int i=0;i<SuperAdmin.getInstance().getRequest().size();i++){
            if(SuperAdmin.getInstance().getRequest().get(i).getInfo().equals(customer.getInfo())){
                customer.setCart(SuperAdmin.getInstance().getRequest().get(i).getArticle());
                String str=customer.getInfo();
                str=str+customer.getStatic();
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
        Pattern pattern=Pattern.compile("^[A-Z].*[1-9]@+.*gmail.com$");
      Matcher matcher1= pattern.matcher(string[0]);
      pattern=Pattern.compile("^0913\\{7}");
  Matcher matcher2=   pattern.matcher(string[1]);
      pattern=Pattern.compile("[A-Z]+\\S{8,}$");
        Matcher matcher3=pattern.matcher(string[2]);
      pattern=Pattern.compile("[a-z]+");
         matcher3=pattern.matcher(string[2]);
      pattern=Pattern.compile("[1-9]");
         matcher3=pattern.matcher(string[2]);

      if(matcher1.find()&&matcher3.find()&&matcher2.find()){

          info= string[0].substring(0,3);
          info=info+string[1].substring(8,11);
          info=info+string[2];

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

    }}}
