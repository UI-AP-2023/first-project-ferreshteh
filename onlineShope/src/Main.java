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
        //-----------------------------------------
        Bicycle bicycle = new Bicycle("1", "1", "1", 1, 2, "Vehicle", "1", "hybrid");
        bicycle.setId("id1");
        SuperAdmin.getInstance().addArticle(bicycle);
      //  First.getInstance().firstMeno();
        //------------------------------
        SuperCon.getInstance().productManagement("add pen penName 10 5 blue");
        SuperCon.getInstance().productManagement("add computer co1 23 4 mkj 500 10 20 30");
        SuperCon.getInstance().productManagement("add meal chips 2000 6 22/10/1381 19/12/1381");
        SuperCon.getInstance().productManagement("add ssd ssd1 23000 5 2 10 20 30 100 20");
        SuperCon.getInstance().productManagement("add flash flash1 4100 7 12 10 23 700 usb1");
        SuperCon.getInstance().productManagement("add noteBook note1 54 4 typePaper 100");
        SuperCon.getInstance().productManagement("add machine bvw 700 4 mnb 10.2 true");
        //-----------------------------------
System.out.println(SuperAdmin.getInstance().getArticles().size());

ArticleShow.getInstance().paging();
    //  ArticleShow.getInstance().showAllproducts();
       // First.getInstance().firstMeno();
     //------------------------------------------------
        //-----------------------------------------------
        String[] products=new String[4];
        products[0]=(SuperAdmin.getInstance().getArticles().get(0).getId());
        products[1]= String.valueOf(2);
        products[2]=(SuperAdmin.getInstance().getArticles().get(1).getId());
        products[3]= String.valueOf(3);
        UserController.getInstance().addCart(customer,products,4);
//        System.out.println(customer.getCart());
//        System.out.println("String view cart");
//        System.out.print(UserController.getInstance().StringViewCart(customer));
//        UserController.getInstance().shopping("histo", customer, customer.getOrder());
//       System.out.println( UserController.getInstance().factors(customer));
       //-------------------------------------------------------
        products[0]="60371234";
        products[1]="0609";
        products[2]="Pass123";
        //change name to ali
        UserController.getInstance().checkRegexCredit(customer,products,1000);
//UserController.getInstance().changeInfo(customer,"change credit to 500");
        //-------------------------------------------------------------
       // UserController.getInstance().upperCredit(customer,1000);
        Comment comment = new Comment(customer, "waiting", customer.getId(), "text1");
        System.out.println("comment");
        SuperAdmin.getInstance().setComments(comment);
//        System.out.println(SuperAdmin.getInstance().getComments().size());
//        System.out.println(SuperAdmin.getInstance().getComments().get(0).toString());
        //-------------------------------------------------------------
        System.out.println(" write :accept comment [id user] [idArticle] ");

        SuperCon.getInstance().requestsManagement("accept comment "+customer.getId()+" "+SuperAdmin.getInstance().getArticles().get(0).getId());
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
//Fereshteh123@gmail.com
//09131234567
//Fereshteh10
    //4Fer567Fereshteh104


    //add pen penName 1000 5 blue
    //Asall123@gmail.com
    //09132345678
    //Asall123
    //Asa678Asall123
    //-------------
    //Ali678Alii1234
}


