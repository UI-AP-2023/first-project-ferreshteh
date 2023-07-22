import controller.LoginController;
import controller.SuperCon;
import controller.UserController;
import model.articles.Article;
import model.articles.Bicycle;
import model.others.Comment;
import model.user.Customer;
import model.user.Request;
import model.user.SuperAdmin;
import view.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("Ali678Alii1234", "user", "09132345678", "Alii123@gmail.com", "Alii1234");
        Pattern pattern = Pattern.compile("^[A-Z].*[1-9]@+.*gmail.com$");
        Pattern pattern22 = Pattern.compile("^0913\\d{7}");
        Pattern pattern1 = Pattern.compile("\\S{8,}$");
        Pattern pattern2 = Pattern.compile("[A-Z]+");
        Pattern pattern3 = Pattern.compile("[a-z]+");
        Matcher matcher31 = pattern1.matcher("Alii1234");
        Matcher matcher32 = pattern2.matcher("Alii1234");
        Matcher matcher33 = pattern3.matcher("Alii1234");
        customer.addCredit(400000);
        customer.setId("id1");
        LoginController.getInstance().getAllCostumers().add(customer);
//        String[]order=new String[2];
//order[0]="1";
//order[1]="2";
//        customer.setOrder(order,4);
//------------------------
        Customer customer2=new Customer("info2","customer","09132345678","Fereshteh123@gmail.com","Fereshteh10");
        customer2.setId("4Fer567Fereshteh104");
        customer2.setCredit(20000);
        SuperCon.getInstance().productManagement("add ssd ssd1 23000 5 2 10 20 30 100 20");


        //
       // Scanner sc =new Scanner(System.in);
       // String[] products = new String[sc.nextInt() * 2];
//        int i=0;
//        for (int j = 0; j < products.length/2; j++) {
//            System.out.print("id of products");
//            products[i] = sc.next();
//            System.out.print("number of it you want");
//            i++;
//            products[i] = String.valueOf(sc.nextInt());
//            i++;
//        }
//        UserController.getInstance().addCart(customer, products, products.length);
        LoginController.getInstance().getAllCostumers().add(customer2);
        Customer customer3=new Customer("info3","customer","09132654759","Saeed3623@gmail.com","Saeeed12345");
        customer3.setId("Saeed122");
        LoginController.getInstance().getAllCostumers().add(customer3);
     //   First.getInstance().firstMeno();
        //------------------------------------
        SuperCon.getInstance().productManagement("add pen penName 10 5 blue vcxs");
        SuperCon.getInstance().productManagement("add computer co1 23 4 mkj 500 10 20 30");
        SuperCon.getInstance().productManagement("add meal chips 2000 6 22/10/1381 19/12/1381");

        SuperCon.getInstance().productManagement("add flash flash1 4100 7 12 10 23 700 usb1");
        SuperCon.getInstance().productManagement("add noteBook note1 54 4 typePaper 100 iran");
//        SuperCon.getInstance().productManagement("add noteBook note2 100 7 pelastik 200 eragh");
//        SuperCon.getInstance().productManagement("add machine bvw 700 4 mnb 10.2 true");
//        SuperCon.getInstance().productManagement("add meal pofak 100 4 22/10/1354 22/9/1326");
        //-----------------------------------

//        Customer two=new Customer("Fereshteh10","customer","09132345678","Fereshteh123@gmail.com","Fereshteh10");
//        LoginController.getInstance().getAllCostumers().add(two);
//       customer= SuperCon.getInstance().acceptUser("Fereshteh10");
//        Request request = new Request("Fereshteh10", "user", "09132345678", "Fereshteh123@gmail.com", "Fereshteh10");
//  System.out.println(SuperAdmin.getInstance().getComments().get(0).toString());
//        SuperAdmin.getInstance().getRequests().add(request);

        //-----------------------------------------
        Bicycle bicycle = new Bicycle("1", "1", "1", 10, 5, "Vehicle", "1", "hybrid");
        bicycle.setId("id1");
        SuperAdmin.getInstance().addArticle(bicycle);
        bicycle.lowerExist(4);
        System.out.println(bicycle.toString());
        System.out.println(bicycle.getExist());
       // SuperCon.getInstance().requestsManagement("accept comment 4Fer567Fereshteh104 id1");
//First.getInstance().firstMeno();
        //First.getInstance().firstMeno();
        //------------------------------
//        for(int i=0;i<SuperAdmin.getInstance().getArticles().size();i++){
//            System.out.println(SuperAdmin.getInstance().getArticles().get(i).getType());
//        }

//    SuperCon.getInstance().delete("2penName10");
//    SuperCon.getInstance().editExist("3co123",5);
//    SuperCon.getInstance().editPrice("4chips2000","1000");
//    SuperCon.getInstance().editName("4chips2000","mast");
ArticleShow.getInstance().paging();
//        UserController.getInstance().unFiltering();
//        ArticleShow.getInstance().paging();


        //-----------------------------------
//System.out.println(SuperAdmin.getInstance().getArticles().size());

//ArticleShow.getInstance().paging();
    //  ArticleShow.getInstance().showAllproducts();
        //First.getInstance().firstMeno();
     //------------------------------------------------
        //-----------------------------------------------
//        String[] products=new String[4];
//        products[0]=(SuperAdmin.getInstance().getArticles().get(0).getId());
//        products[1]= String.valueOf(2);
//        products[2]=(SuperAdmin.getInstance().getArticles().get(1).getId());
//        products[3]= String.valueOf(3);
//        UserController.getInstance().addCart(customer,products,4);
//        UserController.getInstance().shopping("histo", customer, customer.getOrder());
//        UserController.getInstance().score(customer,"20 to id1");
//        System.out.println(bicycle.toString());

//        System.out.println(customer.getCart());
//        System.out.println("String view cart");
//        System.out.print(UserController.getInstance().StringViewCart(customer));
    //  UserController.getInstance().shopping("histo", customer, customer.getOrder());
//       System.out.println( UserController.getInstance().factors(customer));
       //-------------------------------------------------------
//        products[0]="60371234";
//        products[1]="0609";
//        products[2]="Pass123";
//        //change name to ali
    //    UserController.getInstance().checkRegexCredit(customer,products,1000);
//UserController.getInstance().changeInfo(customer,"change credit to 500");
        //-------------------------------------------------------------
       // UserController.getInstance().upperCredit(customer,1000);
//        Comment comment = new Comment(customer, "waiting", customer.getId(), "text1");
//        System.out.println("comment");
//        SuperAdmin.getInstance().setComments(comment);
//        System.out.println(SuperAdmin.getInstance().getComments().size());
//        System.out.println(SuperAdmin.getInstance().getComments().get(0).toString());
        //-------------------------------------------------------------
      //  System.out.println(" write :accept comment [id user] [idArticle] ");

   //    SuperCon.getInstance().requestsManagement("accept comment "+customer.getId()+" "+SuperAdmin.getInstance().getArticles().get(0).getId());
        //------------------------------------------------------------
     //  System.out.println(customer.getCart().get(1).toString());
     //   UserController.getInstance().shopping("22/10/1381", customer, products);
        //-----------------------------------------
//       System.out.println(SuperAdmin.getInstance().getArticles().get(0).toString());
//       System.out.println(SuperAdmin.getInstance().getArticles().get(1).toString());
//        //--------------
//        System.out.println(SuperAdmin.getInstance().getArticles().size());
        //
//        Request request = new Request("Ali678Alii1234", "user", "45", "745", "12");
//        System.out.println(SuperAdmin.getInstance().getComments().get(0).toString());
//        SuperAdmin.getInstance().getRequests().add(request);
//        LoginController.getInstance().getAllCostumers().add(customer);
//        SuperAdmin.getInstance().getArticles().add(bicycle);



//First.getInstance().firstMeno();
//First.getInstance().intialize();

     //   System.out.print(SuperAdmin.getInstance().getArticles().get(1).toString());
//    SuperCon.getInstance().requestsManagement("accept user ");


    }

//---------------------
    //Asall123@gmail.com
    //09132345678
    //Asall123
    //Asa678Asall123
    //-------------
    //Ali678Alii1234
}


