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
    private ArrayList<Article> cart = new ArrayList<>();
    private ArrayList<Factor> factors = new ArrayList<>();
    private double credit;

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
