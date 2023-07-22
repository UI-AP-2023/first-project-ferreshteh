package view;

import controller.LoginController;
import controller.SuperCon;
import model.articles.Article;
import model.articles.Bicycle;
import model.user.Customer;
import model.user.Request;
import model.user.SuperAdmin;

import java.util.Scanner;

public class First {
    String loginName;
    String[] string = new String[3];
    Customer customer = new Customer("Asa678Asall123", "user", "09132345678", "Asall123@gmail.com", "Asall123");
Bicycle bicycle=new Bicycle("1","1","1",1,2,"Vehicle","1","1");

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    Scanner sc = new Scanner(System.in);
    int scanner = 0;
    String scanNer;
    private boolean free;
    private static First instance;

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    private First(String info) {
        loginName = info;
    }

    public static First getInstance() {
        if (instance == null) {
            instance = new First("Login") {

            };
        }
        return instance;
    }


    public void intialize(){

        LoginController.getInstance().getAllCostumers().add(customer);
        SuperAdmin.getInstance().getArticles().add(bicycle);
    }



    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("1-login 2-register 3-free");
        scanner = sc.nextInt();
        if (scanner == 1) {
            System.out.print(" enter your id ");
            scanNer = sc.next();
           // LoginController.getInstance().equalingCustomer(customer,LoginController.getInstance().setUserInfoEnter(scanNer));
            customer=LoginController.getInstance().setUserInfoEnter(scanNer);
            UserMeno.getInstance().customer=customer;
         //   UserMeno.getInstance().scanner=0;
           UserMeno.getInstance().menoUser();

        } else if (scanner == 2) {
            System.out.println("email\n telephoneNumber \npassword");
            string[0] = sc.next();
            string[1] = sc.next();
            string[2] = sc.next();
            LoginController.getInstance().setUserInfoRegister(string);
        } else if (scanner == 3) {
            System.out.println("free");
            free = true;
           UserMeno.getInstance(). menoUser();
        }
    }

    public void firstMeno() {
        System.out.print("1-user 2-Admin 3-superAdmin");
        scanner = sc.nextInt();
        if (scanner == 1) {
            login();
        } else if (scanner == 3) {
            System.out.println("username");
            scanNer = sc.next();
            if (scanNer.equals("admin")) {
               SuperMeno.getInstance(). adminMeno();
            }
        }
    }
    public void showInfo(Customer customer){
        System.out.println(customer.getId());
    }


}