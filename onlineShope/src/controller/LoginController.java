package controller;

import model.user.*;
import view.First;
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
        Customer customer = new Customer("wrong","user","1254","adgghfyt","7854");
        customer=createId("wrong");
        for (int i = 0; i < LoginController.getInstance().allCostumers.size(); i++) {
            if (LoginController.getInstance().allCostumers.get(i).getId().equals(id)) {
customer=LoginController.getInstance().allCostumers.get(i);
                System.out.println("logined");
                check++;
                return customer;

            }
            else {
                System.out.println("not");
            }
        }
        if (check == 0) {
            Messages.getInstance().printError();
            First.getInstance().firstMeno();
        }

        return customer;
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
                    Request request = new Request(info, "Customer", string[1], string[0], string[2]);
                    request.setInfo(info);
                    SuperAdmin.getInstance().setRequests(request);
                    Messages.getInstance().printWait();
                    First.getInstance().firstMeno();
                }
            } else {
                Request request = new Request(info, "Customer", string[1], string[0], string[2]);
                request.setInfo(info);
                SuperAdmin.getInstance().setRequests(request);
                Messages.getInstance().printWait();
                First.getInstance().firstMeno();
            }
        } else {
            Messages.getInstance().printError();
        }
    }

    public Customer createId(String info) {
        Customer customer = new Customer(info, "Costumer", "1", "2", "3");
        for (int i = 0; i < SuperAdmin.getInstance().getRequests().size(); i++) {
            if (SuperAdmin.getInstance().getRequests().get(i).getInfo().equals(info)) {
                customer.setEmail(SuperAdmin.getInstance().getRequests().get(i).getEmail());
                customer.setPhone(SuperAdmin.getInstance().getRequests().get(i).getPhone());
                customer.setPassWord(SuperAdmin.getInstance().getRequests().get(i).getPassWord());
                // LoginController.getInstance().getAllCostumers().add(customer);
            }
        }
        String id = customer.getStatic() + info + customer.getStatic();
        customer.setId(id);
        allCostumers.add(customer);
        Messages.getInstance().printId(id);
        return customer;
    }
}
