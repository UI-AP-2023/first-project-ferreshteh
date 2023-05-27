package model.articles;

import model.others.Comment;
import model.others.Discount_feature;

import java.util.ArrayList;

public class Pen extends Stationary  implements Discount_feature {
    private String color;

    public Pen(String id, String name, String price, float average, int exist, String type,String color) {
        super(id, name, price, average, exist, type);
        this.color=color;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "color='" + color + '\'' +"country"+getCountry()+" "+"exist="+exist+" "+
                "name :"+ getName() +"id :"+getId()+"price :"+ getPrice() +"Avarege :"+getAverage()+"type :"+getType()+"comment :"+getComments()+"country :"+getCountry()+
                '}';
    }

    //


    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return super.getId();
    }

    @Override
    public float getAverage() {
        return super.getAverage();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getPrice() {
        return super.getPrice();
    }

    @Override
    public int isExist() {
        return super.isExist();
    }

    @Override
    public ArrayList<Comment> getComments() {
        return super.getComments();
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public void setAverage(float average) {
        super.setAverage(average);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setPrice(String price) {
        super.setPrice(price);
    }

    @Override
    public void setExist(int exist) {
        super.setExist(exist);
    }

    @Override
    public void setComments(Comment comments) {
        super.setComments(comments);
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    @Override
    public void add_Off( double percent) {
        double price=Double.parseDouble(this.getPrice());
        this.setPrice(String.valueOf(price-(price*percent/100)));
    }
    @Override
    public void delete_Off( double percent) {
        double price=Double.parseDouble(this.getPrice());
        this.setPrice(String.valueOf(price-(price*percent/100)));
    }

}
