package controller;

import model.user.*;
import view.Login;
import view.Messages;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class LoginController {
    String loginName;
    private ArrayList<Customer> allCostumers = new ArrayList<>();
    private static LoginController instance;

    public ArrayList<Customer> getAllCostumers() {
        return allCostumers;
    }

    private LoginController(String info) {
        loginName = info;
    }

    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController("LoginController");
        }
        return instance;
    }





    public Customer setUserInfoEnter(String id) {

        int check = 0;
        for (Customer allCostumer : allCostumers) {
            if (allCostumer.getId().equals(id)) {

                return allCostumer;

            }
        }

       return null;
    }


    public void setUserInfoRegister(String[] string) {
        String info = "";
        Pattern pattern = Pattern.compile("^[A-Z].*[1-9]@+.*gmail.com$");
        Matcher matcher1 = pattern.matcher(string[0]);
        Pattern pattern22 = Pattern.compile("^0913\\d{7}");
        Matcher matcher2 = pattern22.matcher(string[1]);
        Pattern pattern1 = Pattern.compile("\\S{8,}$");
        Pattern pattern2 = Pattern.compile("[A-Z]+");
        Pattern pattern3 = Pattern.compile("[a-z]+");
        Matcher matcher31 = pattern1.matcher(string[2]);
        Matcher matcher32 = pattern2.matcher(string[2]);
        Matcher matcher33 = pattern3.matcher(string[2]);
//if(matcher1.find()){System.out.println("matcher1");}
//if(matcher2.find()){System.out.println("2");}
// if(matcher31.find()){System.out.println("31");}
// if(matcher32.find()){System.out.println("32");}
// if(matcher33.find()){System.out.println("33");}

        if (Stream.of(matcher1, matcher31, matcher32, matcher33, matcher2).allMatch(Matcher::find)) {
            info = string[0].substring(0, 3);
            info = info + string[1].substring(8, 11);
            info = info + string[2];
            System.out.println("ok");
            System.out.println(info);
            int check = 0;
            if (allCostumers.size() != 0) {
                for (Customer allCostumer : allCostumers) {
                    if (allCostumer.getInfo().equals(info)) {
                        Messages.getInstance().printError();
                        check++;
                        break;
                    }
                }
                if (check == 0) {

                    if (Login.getInstance().isFree()) {

                    } else {
                        Request request = new Request(info,"Customer",string[1],string[0],string[2]);
                        request.setInfo(info);
                        SuperAdmin.getInstance().setRequests(request);
                        Messages.getInstance().printWait();
                        Login.getInstance().firstMeno();

                    }
                }
            }
            else {
                if (Login.getInstance().isFree()) {

                } else {
                    Request request = new Request(info,"Customer",string[1],string[0],string[2]);
                    request.setInfo(info);
                    SuperAdmin.getInstance().setRequests(request);
                    Messages.getInstance().printWait();
                    Login.getInstance().firstMeno();

                }
            }
        }
        else {

            Messages.getInstance().printError();
        }
    }
    public void createId(String info,String[] string){
        Customer customer=new Customer(info,"Costumer",string[1],string[0],string[2]);
        String id=customer.getStatic()+info+customer.getStatic();
        customer.setId(id);
        allCostumers.add(customer);
        Messages.getInstance().printId(id);
    }
}
