package view;

import com.example.phase2.*;

import controller.LoginController;
import controller.SuperCon;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.user.Customer;
import model.user.SuperAdmin;

import java.util.Scanner;

public class SuperMeno {
    String loginName;
    String[] string = new String[3];
    Customer customer = new Customer(" for example", "customer", string[0], string[1], string[2]);


    Scanner sc = new Scanner(System.in);
    int scanner = 0;
    String scanNer;
    private boolean free;
    private static SuperMeno instance;

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    private SuperMeno(String info) {
        loginName = info;
    }

    public static SuperMeno getInstance() {
        if (instance == null) {
            instance = new SuperMeno("Login") {
            };
        }
        return instance;
    }

    public void adminMeno() {
        scanner=0;
        System.out.println("1-Responding to Registration requests  2-view comments 3-Product management(add\\delete\\edit) 4-viewProducts ");
        System.out.println(" 5-Responding to Requests for comments  6-Responding to Requests for credit enhancement 7-exit");
        scanner = sc.nextInt();
        while (scanner != 7) {
            if (scanner == 1) {
                for (int i = 0; i < SuperAdmin.getInstance().getRequest().size(); i++) {
                    System.out.println(SuperAdmin.getInstance().getRequests().get(i).toString());
                }
                System.out.println("write: accept  user info");
                sc.nextLine();
                customer = SuperCon.getInstance().requestUser(sc.nextLine());
                UserMeno.getInstance().setCustomer(customer);
                RegisterController.customer=customer;
                RegisterController.check = 1;
                scanner=7;
            } else if (scanner == 5) {
                for (int i = 0; i < SuperAdmin.getInstance().getComments().size(); i++) {
                    System.out.println(SuperAdmin.getInstance().getComments().get(i).toString());
                }
                System.out.println(" write :accept comment [id user] [idArticle] ");
                sc.nextLine();
                SuperCon.getInstance().requestsManagement(sc.nextLine());
                System.out.println("1-Responding to Registration requests  2-view commentsRequested 3-Product management(add\\delete\\edit) 4-viewProducts ");
                System.out.println(" 5-Responding to Requests for comments  6-Responding to Requests for credit enhancement 7-exit");
                scanner = sc.nextInt();
            } else if (scanner == 6) {
                for (int i = 0; i < LoginController.getInstance().getAllCostumers().size(); i++) {
                    if (LoginController.getInstance().getAllCostumers().get(i).getCreditRequest()) {
                        System.out.println(LoginController.getInstance().getAllCostumers().get(i).toString());
                    }
                }
                System.out.println(" write: write accept credit idUser ");
                sc.nextLine();
                SuperCon.getInstance().requestsManagement(sc.nextLine());
                System.out.println("1-Responding to Registration requests  2-view comments 3-Product management(add\\delete\\edit) 4-viewProducts ");
                System.out.println(" 5-Responding to Requests for comments  6-Responding to Requests for credit enhancement 7-exit");
                scanner = sc.nextInt();
            } else if (scanner == 2) {
                for (int i = 0; i < SuperAdmin.getInstance().getComments().size(); i++) {
                    System.out.println(SuperAdmin.getInstance().getComments().get(i).toString());
                }
                System.out.println("1-Responding to Registration requests  2-view comments 3-Product management(add\\delete\\edit) 4-viewProducts ");
                System.out.println(" 5-Responding to Requests for comments  6-Responding to Requests for credit enhancement 7-exit");
                scanner = sc.nextInt();
            } else if (scanner == 3) {
                System.out.println("enter your command");
                sc.nextLine();
                scanNer = sc.nextLine();
                SuperCon.getInstance().productManagement(scanNer);
                System.out.println("1-Responding to Registration requests  2-view comments 3-Product management(add\\delete\\edit) 4-viewProducts ");
                System.out.println(" 5-Responding to Requests for comments  6-Responding to Requests for credit enhancement 7-exit");
                scanner = sc.nextInt();
            } else if (scanner == 4) {
                for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
                    System.out.println(SuperAdmin.getInstance().getArticles().get(i).toString());
                }
                System.out.println("1-Responding to Registration requests  2-view comments 3-Product management(add\\delete\\edit) 4-viewProducts ");
                System.out.println(" 5-Responding to Requests for comments  6-Responding to Requests for credit enhancement 7-exit");
                scanner = sc.nextInt();
            }

        }
//        if (scanner == 7) {
//            scanner = 0;
//            System.out.println("adminMeno");
//            First.getInstance().firstMeno();
       System.out.println("break while"); }
//            RegisterController.check=1;
//        try {
//            RegisterController.mainPage();
//            System.out.println(RegisterController.check);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }


    }

