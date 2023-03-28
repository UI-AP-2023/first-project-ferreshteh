package controller;

import model.user.*;
import model.articles.*;
import model.others.*;
import view.Login;
import view.MenoUser;
import view.Messages;

public class LoginController {
    Customer customer = new Customer();
    AllLists allLists = new AllLists();
    MenoUser menoUser = new MenoUser();
    Login login = new Login();
    Messages messages=new Messages();
    String scanNer;
    int scanner;

    public void setUserInfoEnter(String info) {
        int check = 0;
        for (int i = 0; i < allLists.allCostumers.size(); i++) {
            if (allLists.allCostumers.get(i).getInfo().equals(info)) {
                menoUser.menoUser();
                check++;
                break;
            }
        }
        if(check==0){
            messages.printError();
        }
    }
    public void setUserInfoRegister(String info){
        int check = 0;
        for (int i = 0; i < allLists.allCostumers.size(); i++) {
            if (allLists.allCostumers.get(i).getInfo().equals(info)) {
                messages.printError();
                check++;
                break;
            }
    }
        if(check==0){
          if(login.free){

          }
          else{

          }
        }
}}
