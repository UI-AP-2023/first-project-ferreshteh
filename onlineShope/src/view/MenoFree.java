package view;

import controller.UserController;
import model.others.Comment;
import model.user.Customer;
import model.user.SuperAdmin;

import java.util.Scanner;

public class MenoFree {
    private static MenoFree instance;

    public static MenoFree getInstance() {
        if (instance == null) {
            instance = new MenoFree() {

            };
        }
        return instance;
    }

    String[] string = new String[3];
    Customer customer = new Customer(" for example", "customer", string[0], string[1], string[2]);


    Scanner sc = new Scanner(System.in);
    int scanner = 0;
    String scanNer;

    public void menoFree() {
        System.out.print("|1-Register 2-comment |3- View products  4-filter 5-searching 6-Add to cart 7-exit");
        scanner = sc.nextInt();
        while (scanner != 7) {
            if (scanner == 1) {
                First.getInstance().login();
            } else if (scanner == 2) {
                System.out.print("enter your text");
                sc.nextLine();
                scanNer = sc.nextLine();
                Comment comment = new Comment(customer, "waiting", customer.getId(), scanNer);
                SuperAdmin.getInstance().setComments(comment);
                System.out.print("|1-Register 2-comment |3- View products  4-filter 5-searching 6-Add to cart 7-exit");
                sc.nextInt();
            } else if (scanner == 3) {
                ArticleShow.getInstance().showAllFree();
                System.out.print("|1-Register 2-comment |3- View products  4-filter 5-searching 6-exit");
                scanner = sc.nextInt();
            } else if (scanner == 4) {
                ArticleShow.getInstance().showAllFree();
                System.out.print("|1-Register 2-comment |3- View products  4-filter 5-searching 6-exit");
                scanner = sc.nextInt();
            } else if (scanner == 5) {
                System.out.print("name?");
                scanNer = sc.next();
                UserController.getInstance().search(scanNer);
                System.out.print("|1-Register 2-comment |3- View products  4-filter 5-searching 6-exit");
                scanner = sc.nextInt();
            }
            else if(scanner==6){
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
            }
        }
First.getInstance().firstMeno();

    }
}
