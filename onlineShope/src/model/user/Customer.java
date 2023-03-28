package model.user;
import model.articles.Article;
import model.others.Factor;
import model.articles.*;
import model.user.*;
import model.others.*;
import java.util.ArrayList;

//----------------------------------------
public class Customer extends Account {

    private ArrayList<Article> cart = new ArrayList<>();
    private ArrayList<Factor> factors = new ArrayList<>();
    private int credit;

    public void setInfo() {
    }

}
