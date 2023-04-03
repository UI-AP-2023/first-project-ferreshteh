import controller.LoginController;
import controller.SuperCon;
import model.articles.Bicycle;
import model.user.Customer;
import model.user.Request;
import model.user.SuperAdmin;
import view.*;

public class Main {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle("1", "1", "1", 1, 2, "Vehicle", "1", "1");
        Customer customer = new Customer("Ali678Alii1234", "user", "09132345678", "Alii123@gmail.com", "Alii1234");
        customer=LoginController.getInstance().createId("Ali678Alii1234");
        Request request = new Request("Ali678Alii1234", "user", "45", "745", "12");
        SuperAdmin.getInstance().getRequests().add(request);
        LoginController.getInstance().getAllCostumers().add(customer);
        SuperAdmin.getInstance().getArticles().add(bicycle);
        SuperAdmin.getInstance().getArticles().add(bicycle);
        System.out.println(LoginController.getInstance().getAllCostumers().size());
First.getInstance().firstMeno();
First.getInstance().intialize();

     //   System.out.print(SuperAdmin.getInstance().getArticles().get(1).toString());
//    SuperCon.getInstance().requestsManagement("accept user ");
//        SuperCon.getInstance().productManagement("add pen penName 1000 5 blue");
//        SuperCon.getInstance().productManagement("add computer co1 2300 4 mkj 500 10 20 30");
//        SuperCon.getInstance().productManagement("add pencil pen1 450 6 hb ");
//        SuperCon.getInstance().productManagement("add machine bmw 780 5 bmw bvc 123 tru");

    }
//    Fereshteh123@gmail.com
//    09131234567
//    Fereshteh10
    //4Fer567Fereshteh104


    //add pen penName 1000 5 blue
    //Asall123@gmail.com
    //09132345678
    //Asall123
    //Asa678Asall123
    //-------------
    //Ali678Alii1234
}


