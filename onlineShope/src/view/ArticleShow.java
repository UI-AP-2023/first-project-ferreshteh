package view;

import controller.UserController;
import model.articles.Article;
import model.user.Customer;
import model.user.SuperAdmin;
import controller.ArtContoroller;

import java.util.Objects;
import java.util.Scanner;

public class ArticleShow {
    String idArticle;

    public String getIdArticle() {
        return idArticle;
    }

    String[] string = new String[3];
    Customer customer = new Customer(" for example", "customer", string[0], string[1], string[2]);


    Scanner sc = new Scanner(System.in);
    int scanner = 0;
    String scanNer;
    private boolean free;
    private static ArticleShow instance;
    private int center=0;
    public static ArticleShow getInstance() {
        if (instance == null) {
            instance = new ArticleShow() {

            };
        }
        return instance;
    }
public void paging(){
        int first=0;
        int last=1;
        center=0;
        int size=SuperAdmin.getInstance().getArticles().size();
        if(SuperAdmin.getInstance().getArticles().size()>=5){
        for (int i=0;i<last*5;i++){
            System.out.print(SuperAdmin.getInstance().getArticles().get(i).toString());
            System.out.print("\n");
            center++;
        }
        first++;
        last++;
        size-=center;

        while (size!=0){
    System.out.print("next?");
    if(sc.next().equals("next")){
        for(int i=first*5;i<last*5;i++) {
            if(size<5){
                System.out.println(SuperAdmin.getInstance().getArticles().get(i));
                center++;
                size--;
                if(center==SuperAdmin.getInstance().getArticles().size())
                    break;
            }
            else {
               System.out.println(SuperAdmin.getInstance().getArticles().get(i));
               size--;
               center++;
            }
        }
}
        first++;
        last++;
        }}
    else {
    for(int i=0;i<SuperAdmin.getInstance().getArticles().size();i++){
    System.out.println(SuperAdmin.getInstance().getArticles().get(i).toString());}
        }
}
public void search(){
    System.out.print("id?");
    scanNer = sc.next();
    System.out.printf(ArtContoroller.getInstance().search(scanNer).toString());
    idArticle=ArtContoroller.getInstance().search(scanNer).getId();

}
public void article(){
        search();
        System.out.println();
}

    public void filterUser(){
        System.out.println("1-price   |2-typeOfBicycle   |3-exist or not|   4-expiration  5-numberOfNoteBookPapers 6-Type of Articles 7-unFiltering");
        scanner=sc.nextInt();
        if(scanner==1){
            System.out.print("which range of price?");
            scanNer=sc.next();
          ArtContoroller.getInstance().filterPrice(scanNer);
        }
        else if(scanner==2){
            System.out.print("enter type");
            scanNer=sc.next();
            ArtContoroller.getInstance().filterTypeOfBicycle(scanNer);
        }
        else if(scanner==3){
            System.out.print("tru for exist false for notExist");
            scanNer=sc.next();
            ArtContoroller.getInstance().filterExist(scanNer);
        }
        else if(scanner==4){
            System.out.print("enter expiration");
            scanNer=sc.next();
            ArtContoroller.getInstance().filterExpiration(scanNer);
        }
        else if(scanner==5){
            System.out.print("enter umber of book you want");
            ArtContoroller.getInstance().filterNoteNumber(sc.nextInt());
        }
        else if(scanner==6){
            System.out.print("which type?");
            ArtContoroller.getInstance().generalFilter(sc.next());
        }
        else if(scanner==7){
            ArtContoroller.getInstance().unFiltering();
        }
    }


}
