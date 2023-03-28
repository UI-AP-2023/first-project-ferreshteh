package view;

import controller.LoginController;

import java.util.Scanner;

public  class Login {
    LoginController loginController=new LoginController();
    Scanner sc=new Scanner(System.in);
   public int scanner=0;
   public String scanNer;
   public boolean free;
    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("1-login 2-register 3-free");
        scanner=sc.nextInt();
        if (scanner==1){
            System.out.printf(" enter your id ");
            scanNer=sc.next();
            loginController.setUserInfoEnter(scanNer);
        }
        else if(scanner==2){
            System.out.println("email telephoneNumber password");
            scanNer=sc.next();
        }
        else if(scanner==3){
            free=true;
        }
    }

    public void firstMeno(){
        System.out.printf("1-user 2-Admin 3-superAdmin");
       scanner= sc.nextInt();
       if(scanner==1){
           login();
       }
    }
}