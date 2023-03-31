package model.user;
import model.articles.Article;
import model.others.Factor;

import java.util.ArrayList;

//----------------------------------------
public class Customer extends Account {

    private String id;
    private String passWord;
    private String phone;
    private String email;
    private static  int number=0;

    public double getCredit() {
        return credit;
    }

    public ArrayList<Factor> getFactors() {
        return factors;
    }

    public ArrayList<Article> getCart() {
        return cart;
    }

    public static int getNumber() {
        return number;
    }


    public static void setNumber(int number) {
        Customer.number = number;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getId() {
        return id;
    }

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
private  boolean creditRequest=false;
private double defaultCredit;

    public double getDefaultValidity() {
        return defaultCredit;
    }

    public void setDefaultValidity(double defaultValidity) {
       defaultCredit = defaultValidity;
    }

    public boolean getCreditRequest() {
        return creditRequest;
    }

    public void setCreditRequest(boolean creditRequest) {
        this.creditRequest = creditRequest;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "info='" + super.getInfo() + '\'' +
                ", id='" + id + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", cart=" + cart +
                ", factors=" + factors +
                ", credit=" + credit +
                '}';
    }

    public String getInfo() {
        return super.getInfo();
    }

    public void setInfo(String info){
        super.setInfo(info);
    }

    public void setCredit() {
        credit=defaultCredit;
    }

    public void setCart(ArrayList<Article> article){
        cart.addAll(article);
    }
    public void setFactors(ArrayList<Factor> factor){
        factors.addAll(factor);
    }

    public Customer(String info, String character,String phone,String email,String passWord) {
        super(info, character);
        number++;
    }

    @Override
    public String getCharacter() {
        return super.getCharacter();
    }
}
