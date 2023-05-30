package model.user;
import model.articles.Article;
import model.others.Factor;
import model.others.Off;

import java.util.ArrayList;

//----------------------------------------
public class Customer extends Account {

    private String id;
    private String info;
    private String passWord;
    private String phone;
    private String email;
    private static  int number=0;
    String creditNumber;
    String creditPassword;
    String cvv2;
    int numberOfOrder;
    String[]order=new String[numberOfOrder];
    private ArrayList<Off>list_Offs=new ArrayList<Off>();

    public ArrayList<Off> getList_Offs() {
        return list_Offs;
    }

    public void setOrder(String []order, int numberOfOrder){
        this.numberOfOrder=numberOfOrder;
        this.order=order;
    }

    public String[] getOrder() {
        return order;
    }

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

    public void setCredit(double credit) {
        this.credit = credit;
    }

    private double defaultCredit;



    public double getDefaultValidity() {
        return defaultCredit;
    }


    public void setDefaultCredit(double defaultCredit) {
        this.defaultCredit = defaultCredit;
    }
    public void upperCredit(double defaultCredit){
        credit=credit+defaultCredit;
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
                "info='" + this.getInfo() + '\'' +
                ", id='" + id + '\'' +
                ", passWord='" +this. passWord + '\'' +
                ", phone='" + this.phone + '\'' +
                ", email='" +this. email + '\'' +
                ", cart=" + this.cart +
                ", factors=" + this.factors +
                ", credit=" + this.credit +
                '}';
    }

    public String getInfo() {
        return super.getInfo();
    }

    public void setInfo(String info){
        super.setInfo(info);
        this.info=info;
    }

    public void setCredit() {
        credit=defaultCredit+credit;
    }
    public void lowerCredit(double credit){
        this.credit=this.credit-credit;
    }
    public void addCredit(double credit){
        this.credit=this.credit+credit;
    }

    public void setCart(Article article){
        cart.add(article);
    }
    public void setFactors(ArrayList<Factor> factor){
        factors.addAll(factor);
    }

    public Customer(String info, String character,String phone,String email,String passWord) {
        super(info, character);
        super.setInfo(info);
        this.phone=phone;
        this.email=email;
        this.passWord=passWord;
        this.info=info;
        number++;
    }

    @Override
    public String getCharacter() {
        return super.getCharacter();
    }


}
