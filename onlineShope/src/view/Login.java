package view;

import controller.LoginController;
import controller.SuperCon;
import controller.UserController;
import model.others.Comment;
import model.user.Customer;
import model.user.SuperAdmin;

import java.util.Objects;
import java.util.Scanner;

public class Login {
    String loginName;
    String[]string=new String[3];
    Customer customer = new Customer(" for example", "customer",string[0],string[1],string[2]);


    Scanner sc = new Scanner(System.in);
    int scanner = 0;
    String scanNer;
    private boolean free;
    private static Login instance;

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    private Login(String info) {
        loginName = info;
    }

    public static Login getInstance() {
        if (instance == null) {
            instance = new Login("Login") {

            };
        }
        return instance;
    }

    public void menoUser() {
        while (scanner != 5) {
            System.out.printf("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
            System.out.printf("|6-Register 7-comment |7 View products and filter 8-filter 9-searching 10-exit ");
            scanner = sc.nextInt();
            if (scanner == 1) {
                System.out.println("numberOfProducts");
                scanner = sc.nextInt();
                String[] products = new String[scanner];
                for (int i = 0; i < products.length; i++) {
                    products[i] = sc.next();
                }
                UserController.getInstance().shopping(customer, products);
                System.out.printf("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
                System.out.printf("|6-ADD comments and scores for Kaa |7 View products and filter 8-filter 9-searching 10-exit ");
                scanner = sc.nextInt();
            }
            if(scanner==6){
                scanNer=sc.next();
                Comment comment=new Comment(customer,"waiting",customer.getId(),scanNer);
                SuperAdmin.getInstance().setComments(comment);
            }
        }
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("1-login 2-register 3-free");
        scanner = sc.nextInt();
        if (scanner == 1) {
            System.out.printf(" enter your id ");
            scanNer = sc.next();

        customer=LoginController.getInstance().setUserInfoEnter(scanNer);
        menoUser();
        } else if (scanner == 2) {
            System.out.println("email\n telephoneNumber \npassword");

            string[0] = sc.next();
            string[1] = sc.next();
            string[2] = sc.next();
            LoginController.getInstance().setUserInfoRegister(string);
        } else if (scanner == 3) {
            free = true;
            menoUser();
        }
    }

    public void firstMeno() {
        System.out.printf("1-user 2-Admin 3-superAdmin");
        scanner = sc.nextInt();
        if (scanner == 1) {
            login();
        } else if (scanner == 3) {
            System.out.println("username");
            scanNer = sc.next();
            if (scanNer.equals("admin")) {
                adminMeno();
            }
        }
    }

    public void adminMeno() {
        while (scanner != 5) {
            System.out.println("if you want help >>enter help or enter your order");
            scanNer = sc.next();
            if (scanNer.equals("help")) {
                System.out.printf("1-view request 2-view comments 3-Product management(add\\delete\\edit) 4-viewProducts 5-exit");
                scanner = sc.nextInt();
                if (scanner == 1) {
                    for (int i = 0; i < SuperAdmin.getInstance().getRequest().size(); i++) {
                        System.out.println(SuperAdmin.getInstance().getRequests().get(i).toString());
                    }
                    System.out.println("enter user's info");
                    scanNer = sc.next();
                    LoginController.getInstance().createId(scanNer,string);

                }
                System.out.printf("1-view request 2-view comments 3-Product management 4-viewProducts 5-exit");
                scanner = sc.nextInt();
            } else if (scanner == 3) {
SuperCon.getInstance().productManagement(scanNer);
                System.out.printf("1-view request 2-view comments 3-Product management 4-viewProducts 5-exit");
                scanner = sc.nextInt();

            }
        }

    }

}