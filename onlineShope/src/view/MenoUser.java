package view;
import controller.LoginController;

import java.util.Scanner;

public class MenoUser {
    Scanner sc=new Scanner(System.in);
    public int menoUser(){
        System.out.printf("1shopping |2-factors |3-changingInfo |4-View shopping cart |5-Top up user account credit ");
        System.out.printf("|6-Register comments and scores for Kaa |7 View products and filter 8-filter 9-searching  ");
        int scanner=sc.nextInt();
        return (scanner);
    }
}
