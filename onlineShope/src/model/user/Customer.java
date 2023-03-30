package model.user;
import model.articles.Article;
import model.others.Factor;
import model.articles.*;
import model.user.*;
import model.others.*;
import java.util.ArrayList;

//----------------------------------------
public class Customer extends Account {
    private String info;
    private String id;
    private String passWord;
    private String phone;
    private String email;
    private static  int number=0;

    public void setPassWord(String passWord){
        this.passWord=passWord;

    }
    public int getStatic(){
        return number;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void setEmail(String email){
        this.email=email;
    }
    private ArrayList<Article> cart = new ArrayList<>();
    private ArrayList<Factor> factors = new ArrayList<>();
    private double credit;

    public Customer(String info) {

        super(info);
        number++;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info){
        this.info=info;
    }
    public void setCredit(double money){
        credit=money;
    }
    public void setCart(ArrayList<Article> article){
        cart.addAll(article);
    }
    public void setFactors(ArrayList<Factor> factor){
        factors.addAll(factor);
    }
}
