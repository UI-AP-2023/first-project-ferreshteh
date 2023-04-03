package view;

import controller.UserController;
import model.user.Customer;
import model.user.SuperAdmin;

import java.util.Objects;
import java.util.Scanner;

public class ArticleShow {
    String loginName;
    String[] string = new String[3];
    Customer customer = new Customer(" for example", "customer", string[0], string[1], string[2]);


    Scanner sc = new Scanner(System.in);
    int scanner = 0;
    String scanNer;
    private boolean free;
    private static ArticleShow instance;
    public static ArticleShow getInstance() {
        if (instance == null) {
            instance = new ArticleShow() {

            };
        }
        return instance;
    }

    public void showAllFree(){
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
        UserMeno.getInstance().menoFree();
    }
    public void showAllUser(){
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
        UserMeno.getInstance().menoUser();
    }
    public void filterUser(){
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
    }
    public void filterFree(){
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
        for(int i=0;i<SuperAdmin.getInstance().getArticles().size();i++){

        }
    }

}
