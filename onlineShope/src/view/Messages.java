package view;

import model.user.SuperAdmin;

public class Messages {
    private static Messages instance;
    String name;
    private  Messages(String info) {
        name=info;
    }

    public static Messages getInstance() {
        if (instance == null) {
            instance = new Messages("admin") {

            };
        }
        return instance;
    }

    public void printError(){
        System.out.println("error");
    }
    public void printWait(){
        System.out.println("wait for super Admin Decision");
    }

    public String printId(String str){
        return str;
    }
}
