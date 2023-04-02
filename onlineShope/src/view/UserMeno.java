package view;

import controller.SuperCon;
import controller.UserController;
import model.others.Comment;
import model.user.Customer;
import model.user.SuperAdmin;

import java.util.Objects;
import java.util.Scanner;

public class UserMeno {
    String loginName;
    String[] string = new String[3];
    Customer customer = new Customer(" for example", "customer", string[0], string[1], string[2]);


    Scanner sc = new Scanner(System.in);
    int scanner = 0;
    String scanNer;
    private boolean free;
    private static UserMeno instance;

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
    private UserMeno(String info) {
        loginName = info;
    }

    public static UserMeno getInstance() {
        if (instance == null) {
            instance = new UserMeno("Login") {

            };
        }
        return instance;
    }

    public void menoUser() {

        SuperCon.getInstance().productManagement("add pen penName 1000 5 blue");
        SuperCon.getInstance().productManagement("add computer co1 2300 4 mkj 500 10 20 30");
        SuperCon.getInstance().productManagement("add pencil pen1 450 6 hb ");
        SuperCon.getInstance().productManagement("add machine bmw 780 5 bmw bvc 123 tru");
        while (scanner != 11) {
            System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
            System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-exit ");
            scanner = sc.nextInt();
            if (scanner == 1) {
                System.out.print("enter history");
                sc.nextLine();
                String history=sc.nextLine();
                System.out.println("numberOfProducts");
                String[] products = new String[sc.nextInt()*2];
                for (int i = 0; i < products.length; i++) {
                    System.out.print("id of products");
                    products[i] = sc.next();
                    System.out.print("number of it you want");
                    products[i+1]= String.valueOf(sc.nextInt());
                }
                UserController.getInstance().shopping(history,customer, products);
                System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
                System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-exit ");
                scanner = sc.nextInt();
            }
            if (scanner == 6) {
                System.out.print("enter your text");
                scanNer = sc.nextLine();
                Comment comment = new Comment(customer, "waiting", customer.getId(), scanNer);
                SuperAdmin.getInstance().setComments(comment);
                System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
                System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-exit ");
                scanner = sc.nextInt();
            }
            if (scanner==2){
                System.out.print(UserController.getInstance().factors(customer));
                System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
                System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-exit ");
                scanner = sc.nextInt();
            }
            if(scanner==4){
                System.out.print( UserController.getInstance().StringViewCart(customer));
                System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
                System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-exit ");
                scanner = sc.nextInt();
            }
            if(scanner==5){
                System.out.print("how mich money?");
                UserController.getInstance().upperCredit(customer,sc.nextInt());
                System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
                System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-exit ");
                scanner = sc.nextInt();
            }
            if(scanner==3){
                System.out.print("enter your command :");
                sc.nextLine();
                scanNer=sc.nextLine();
                //change name to ali;
System.out.print(UserController.getInstance().changeInfo(customer,scanNer));

            }
            if(scanner==10){

            }

        }
    }
    public void menoFree() {
        System.out.print("|1-Register 2-comment |3- View products  4-filter 5-searching 6-exit");
        scanner=sc.nextInt();
        while (scanner != 6) {
            if (scanner == 1) {
                First.getInstance().login();
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

}
