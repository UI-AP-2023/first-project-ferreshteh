package view;

import controller.LoginController;
import controller.SuperCon;
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
        while (scanner != 7) {
            System.out.println("if you want help >>enter help or enter your order");
            scanNer = sc.next();
            if (scanNer.equals("help")) {
                System.out.println("1-Responding to Registration requests  2-view comments 3-Product management(add\\delete\\edit) 4-viewProducts ");
                System.out.println(" 5-Responding to Requests for comments  6-Responding to Requests for credit enhancement 7-exit");
                scanner = sc.nextInt();
                if (scanner == 1) {
                    for (int i = 0; i < SuperAdmin.getInstance().getRequest().size(); i++) {
                        System.out.println(SuperAdmin.getInstance().getRequests().get(i).toString());
                    }
                    System.out.println("write: accept  user id");
                   sc.nextLine();
                   customer=SuperCon.getInstance().requestUser(sc.nextLine());
                  First.getInstance().setCustomer(customer);
                  First.getInstance().showInfo(customer);
                  UserMeno.getInstance().menoUser();
                  break;

                }
                else  if(scanner==5){
                    System.out.println(" write :accept comment [id user] [idArticle] ");
                    sc.nextLine();
                    SuperCon.getInstance().requestsManagement(sc.nextLine());
                    System.out.println("1-Responding to Registration requests  2-view comments 3-Product management(add\\delete\\edit) 4-viewProducts ");
                    System.out.println(" 5-Responding to Requests for comments  6-Responding to Requests for credit enhancement 7-exit");
                    scanner = sc.nextInt();
                }
                else if(scanner==6){
                    System.out.println(" write: write accept credit idUser ");
                    sc.nextLine();
                    SuperCon.getInstance().requestsManagement(sc.nextLine());
                    System.out.println("1-Responding to Registration requests  2-view comments 3-Product management(add\\delete\\edit) 4-viewProducts ");
                    System.out.println(" 5-Responding to Requests for comments  6-Responding to Requests for credit enhancement 7-exit");
                    scanner = sc.nextInt();
                }
                else if (scanner == 2) {
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
           First.getInstance(). firstMeno();


    }

}
