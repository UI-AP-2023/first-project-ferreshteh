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
        while (scanner != 12) {
            System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
            System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-Add to cart  12-exit ");
            scanner = sc.nextInt();
            if (scanner == 11) {
                System.out.println("numberOfProducts");
                String[] products = new String[sc.nextInt() * 2];
                for (int i = 0; i <= products.length; i++) {
                    System.out.print("id of products");
                    products[i] = sc.next();
                    System.out.print("number of it you want");
                    i++;
                    products[i] = String.valueOf(sc.nextInt());
                }
                UserController.getInstance().addCart(customer, products, products.length);
               System.out.print( customer.getCart());
                System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
                System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-Add to cart  12-exit ");
                scanner = sc.nextInt();
            } else if (scanner == 1) {
                System.out.print("enter history");
                sc.nextLine();
                String history = sc.nextLine();
                UserController.getInstance().shopping(history, customer, customer.getOrder());
            }
            if (scanner == 6) {
                System.out.print("enter your text");
                sc.nextLine();
                scanNer = sc.nextLine();
                Comment comment = new Comment(customer, "waiting", customer.getId(), scanNer);
                SuperAdmin.getInstance().setComments(comment);
                System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
                System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-Add to cart  12-exit ");
                scanner = sc.nextInt();
            }
            else if(scanner==8){

            }
            if (scanner == 2) {
                System.out.print(UserController.getInstance().factors(customer));
                System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
                System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-Add to cart  12-exit ");
                scanner = sc.nextInt();
            }
            if (scanner == 4) {
                System.out.print(UserController.getInstance().StringViewCart(customer));
                System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
                System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-Add to cart  12-exit ");
                scanner = sc.nextInt();
            }
            if (scanner == 5) {
                String[]strings=new String[3];
                System.out.println("number of your credit card");
                strings[0]=sc.next();
                System.out.println("cvv2?");
                strings[1]=sc.next();
                System.out.println("password");
                strings[2]=sc.next();
                System.out.print("how mich money?");
                UserController.getInstance().checkRegexCredit(customer,strings,sc.nextDouble());
                System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
                System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-Add to cart  12-exit ");
                scanner = sc.nextInt();
            }
            if (scanner == 3) {
                System.out.print("enter your command :");
                sc.nextLine();
                scanNer = sc.nextLine();
                //change name to ali;
                System.out.print(UserController.getInstance().changeInfo(customer, scanNer));
                System.out.print("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
                System.out.print(" 6-comment |7 View products  8-filter 9-searching 10-score 11-Add to cart  12-exit ");
                scanner = sc.nextInt();
            }
            if (scanner == 10) {
                for (int i = 0; i < customer.getFactors().size(); i++) {
                    System.out.println(customer.getFactors().get(i).toString());
                }
                System.out.print("enter your command");
                sc.nextLine();
                scanNer = sc.nextLine();
//20 to id
                UserController.getInstance().score(customer, scanNer);
            }
        }
                First.getInstance().firstMeno();

    }



    public void setCustomer(Customer customer) {
        this.customer = customer;
        this.customer.setPassWord(customer.getPassWord());
        this.customer.setPhone(customer.getPhone());
        this.customer.setEmail(customer.getEmail());
        this.customer.setOrder(customer.getOrder(),customer.getOrder().length);
    }
}
