package model.articles;

import model.others.Comment;

import java.time.LocalDate;
import java.util.ArrayList;

public class Meal extends Article{
    private LocalDate production;
    private LocalDate expiration;

    public Meal(String id, String name, String type, String price, float average, int exist, LocalDate production, LocalDate expiration) {
        super(id, name,price, average, exist,type);
        this.production=production;
        this.expiration=expiration;

    }

    @Override
    public String toString() {
        return "Meal{" +
                "production='" + production + ' ' +
                "expiration='" + expiration + ' ' +", id='"+super.getId()+' ' +",exist= "+exist +" "+ "price="+price+" "+ "name="+name+
             " "+"type"+type+" "+"comment"+" "+super.getComments2()+"average="+getAverage()+   '}';
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
        super.setId(id);
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

    public LocalDate getExpiration() {
        return expiration;
    }

    public LocalDate getProduction() {
        return production;
    }

    public void setProduction(LocalDate production) {
        this.production = production;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }
}
