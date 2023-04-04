package model.articles;

import model.others.Comment;

import java.util.ArrayList;

public class Meal extends Article{
    private String production;
    private String expiration;

    public Meal(String id, String name,String type, String price, float average, int exist,String production,String expiration) {
        super(id, name,price, average, exist,type);
        this.production=production;
        this.expiration=expiration;

    }
String id;
    @Override
    public String toString() {
        return "Meal{" +
                "production='" + production + '\'' +
                ", expiration='" + expiration + '\'' +", id='"+super.getId()+'\'' +",exist= "+exist +
                '}';
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    @Override
    public float getAverage() {
        return super.getAverage();
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int isExist() {
        return exist;
    }

    @Override
    public ArrayList<Comment> getComments() {
        return super.getComments();
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id=id;
    }

    public void setAverage(float average) {
        this.setAverage(average);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }

    public void setComments(Comment comments) {
        this.setComments(comments);
    }

    public String getExpiration() {
        return expiration;
    }
}
