package view;

import controller.LoginController;
import model.user.Customer;

import java.util.Scanner;

public class First {
    String loginName;
    String[] string = new String[3];
    Customer customer = new Customer(" for example", "customer", string[0], string[1], string[2]);


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

//    public void menoUser() {
//        SuperCon.getInstance().productManagement("add pen penName 1000 5 blue");
//        SuperCon.getInstance().productManagement("add computer co1 2300 4 mkj 500 10 20 30");
//        SuperCon.getInstance().productManagement("add pencil pen1 450 6 hb ");
//        SuperCon.getInstance().productManagement("add machine bmw 780 5 bmw bvc 123 tru");
//        while (scanner != 11) {
//            System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
//            System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-exit ");
//            scanner = sc.nextInt();
//            if (scanner == 1) {
//                System.out.print("enter history");
//                sc.nextLine();
//                String history=sc.nextLine();
//                System.out.println("numberOfProducts");
//                String[] products = new String[sc.nextInt()*2];
//                for (int i = 0; i < products.length; i++) {
//                    System.out.print("id of products");
//                    products[i] = sc.next();
//                    System.out.print("number of it you want");
//                    products[i+1]= String.valueOf(sc.nextInt());
//                }
//                UserController.getInstance().shopping(history,customer, products);
//                System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
//                System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-exit ");
//                scanner = sc.nextInt();
//            }
//            if (scanner == 6) {
//                System.out.print("enter your text");
//                scanNer = sc.nextLine();
//                Comment comment = new Comment(customer, "waiting", customer.getId(), scanNer);
//                SuperAdmin.getInstance().setComments(comment);
//                System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
//                System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-exit ");
//                scanner = sc.nextInt();
//            }
//            if (scanner==2){
//                System.out.print(UserController.getInstance().factors(customer));
//                System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
//                System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-exit ");
//                scanner = sc.nextInt();
//            }
//            if(scanner==4){
//               System.out.print( UserController.getInstance().StringViewCart(customer));
//                System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
//                System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-exit ");
//                scanner = sc.nextInt();
//            }
//            if(scanner==5){
//                System.out.print("how mich money?");
//                UserController.getInstance().upperCredit(customer,sc.nextInt());
//                System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
//                System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-exit ");
//                scanner = sc.nextInt();
//            }
//            if(scanner==3){
//
//            }
//            if(scanner==10){
//
//            }
//
//        }
//    }



    public void login() {
        //LoginController.getInstance().setUserInfoRegister();
        Scanner sc = new Scanner(System.in);
        System.out.printf("1-login 2-register 3-free");
        scanner = sc.nextInt();
        if (scanner == 1) {
            System.out.printf(" enter your id ");
            scanNer = sc.next();

            customer = LoginController.getInstance().setUserInfoEnter(scanNer);
            UserMeno.getInstance().menoUser();
        } else if (scanner == 2) {
            System.out.println("email\n telephoneNumber \npassword");

            string[0] = sc.next();
            string[1] = sc.next();
            string[2] = sc.next();
            LoginController.getInstance().setUserInfoRegister(string);
        } else if (scanner == 3) {
            free = true;
           UserMeno.getInstance(). menoUser();
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
               SuperMeno.getInstance(). adminMeno();
            }
        }
    }


}