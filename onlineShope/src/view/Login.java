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
    String[] string = new String[3];
    Customer customer = new Customer(" for example", "customer", string[0], string[1], string[2]);


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
        SuperCon.getInstance().productManagement("add pen penName 1000 5 blue");
        SuperCon.getInstance().productManagement("add computer co1 2300 4 mkj 500 10 20 30");
        SuperCon.getInstance().productManagement("add pencil pen1 450 6 hb ");
        SuperCon.getInstance().productManagement("add machine bmw 780 5 bmw bvc 123 tru");
        while (scanner != 5) {
            System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
            System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-exit ");
            scanner = sc.nextInt();
            if (scanner == 1) {
                System.out.print("enter history");
                sc.nextLine();
                String history=sc.nextLine();
                System.out.println("numberOfProducts");
                scanner = sc.nextInt();
                String[] products = new String[scanner*2];
                for (int i = 0; i < products.length; i++) {
                    System.out.print("id of products");
                    products[i] = sc.next();
                    System.out.print("number of it you want");
                    products[i+1]= String.valueOf(sc.nextInt());
                }
                UserController.getInstance().shopping(history,customer, products);
                System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
                System.out.print("|6-ADD comments and scores for Kaa |7 View products and filter 8-filter 9-searching 10-exit ");
                scanner = sc.nextInt();
            }
            if (scanner == 6) {
                System.out.print("enter your text");
                scanNer = sc.nextLine();
                Comment comment = new Comment(customer, "waiting", customer.getId(), scanNer);
                SuperAdmin.getInstance().setComments(comment);
            }
        }
    }

    public void menoFree() {
        System.out.print("|1-Register 2-comment |3- View products  4-filter 5-searching 6-exit");
        scanner=sc.nextInt();
        while (scanner != 6) {
            if (scanner == 1) {
                login();
            } else if (scanner == 2) {


            } else if (scanner == 3) {
                int j = 0;
                int plus = 0;
                while (!Objects.equals(scanNer, "finish")) {
                    for (j = 0; j < 5; j++) {
                        System.out.print(SuperAdmin.getInstance().getArticles().get(j + plus).toString());
                        System.out.print("next\\last\\finish");
                        scanNer = sc.next();
                    }
                    if (Objects.equals(scanNer, "next") && SuperAdmin.getInstance().getArticles().size() > j + 1) {
                        j++;
                        while (SuperAdmin.getInstance().getArticles().size() > j + plus) {
                            System.out.print(SuperAdmin.getInstance().getArticles().get(j + plus).toString());
                            plus++;
                        }

                    }

                }
                System.out.print("|1-Register 2-comment |3- View products  4-filter 5-searching 6-exit");
                scanner=sc.nextInt();
            }
            else if(scanner==4){
                System.out.print("1-price   |2-typeOfBicycle   |3-exist or not|   4-expiration  5-numberOfNoteBookPapers");
                scanner=sc.nextInt();
                if(scanner==1){
                    System.out.print("which range of price?");
                    scanNer=sc.next();
                    UserController.getInstance().filterPrice(scanNer);
                }
                else if(scanner==2){
                    System.out.print("enter type");
                    scanNer=sc.next();
                    UserController.getInstance().filterTypeOfBicycle(scanNer);
                }
                else if(scanner==3){
                    System.out.print("tru for exist false for notExist");
                    scanNer=sc.next();
                    UserController.getInstance().filterExist(scanNer);
                }
                else if(scanner==4){
                    System.out.print("enter expiration");
                    scanNer=sc.next();
                    UserController.getInstance().filterExpiration(scanNer);
                }
                else if(scanner==5){
                    System.out.print("enter umber of book you want");
                    UserController.getInstance().filterNoteNumber(sc.nextInt());
                }
                System.out.print("|1-Register 2-comment |3- View products  4-filter 5-searching 6-exit");
                scanner=sc.nextInt(); }
            else if(scanner==5){
                System.out.print("name?");
                scanNer=sc.next();
                UserController.getInstance().search(scanNer);
                System.out.print("|1-Register 2-comment |3- View products  4-filter 5-searching 6-exit");
                scanner=sc.nextInt();
            }
        }


    }


    public void login() {
        //LoginController.getInstance().setUserInfoRegister();
        Scanner sc = new Scanner(System.in);
        System.out.printf("1-login 2-register 3-free");
        scanner = sc.nextInt();
        if (scanner == 1) {
            System.out.printf(" enter your id ");
            scanNer = sc.next();

            customer = LoginController.getInstance().setUserInfoEnter(scanNer);
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
                System.out.print("1-view request 2-view comments 3-Product management(add\\delete\\edit) 4-viewProducts 5-exit");
                scanner = sc.nextInt();
                if (scanner == 1) {
                    for (int i = 0; i < SuperAdmin.getInstance().getRequest().size(); i++) {
                        System.out.println(SuperAdmin.getInstance().getRequests().get(i).toString());
                    }
                    System.out.println("enter user's info");
                    scanNer = sc.next();
                    LoginController.getInstance().createId(scanNer, string);
                    System.out.print("1-view request 2-view comments 3-Product management(add\\delete\\edit) 4-viewProducts 5-exit");
                    scanner = sc.nextInt();
                } else if (scanner == 2) {
                    for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
                        for (int j = 0; j < SuperAdmin.getInstance().getArticles().get(i).getComments().size(); j++) {
                            System.out.println(SuperAdmin.getInstance().getArticles().get(i).getComments().toString());
                            System.out.print("1-view request 2-view comments 3-Product management(add\\delete\\edit) 4-viewProducts 5-exit");
                            scanner = sc.nextInt();
                        }
                    }
                } else if (scanner == 3) {
                    System.out.println("enter your command");
                    sc.nextLine();
                    scanNer = sc.nextLine();
                    SuperCon.getInstance().productManagement(scanNer);
                    System.out.print("1-view request 2-view comments 3-Product management(add\\delete\\edit) 4-viewProducts 5-exit");
                    scanner = sc.nextInt();
                } else if (scanner == 4) {
                    for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
                        System.out.println(SuperAdmin.getInstance().getArticles().get(i).toString());
                    }
                    System.out.print("1-view request 2-view comments 3-Product management 4-viewProducts 5-exit");
                    scanner = sc.nextInt();
                }
            }
        }
        if (scanner == 5) {
            firstMeno();
        }

    }

}