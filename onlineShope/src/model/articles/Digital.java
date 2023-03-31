package model.articles;

import model.others.Comment;

import java.util.ArrayList;

public abstract class Digital extends Article{
    private float wight;
    private float side1;
    private float side2;

    public Digital(String id, String name, String price, float average, int exist, String type,float wight,float side1,float side2) {
        super(id, name, price, average, exist,type);
        this.side1=side1;
        this.side2=side2;
        this.wight=wight;
        setType(type);
    }

    @Override
    public String toString() {
        return "Digital{" +
                "wight=" + wight +
                ", side1=" + side1 +
                ", side2=" + side2 +
                '}';
    }

    public float getWight() {
        return wight;
    }

    public void setSide2(float side2) {
        this.side2 = side2;
    }

    public void setSide1(float side1) {
        this.side1 = side1;
    }

    public void setWight(float wight) {
        this.wight = wight;
    }

    public float getSide2() {
        return side2;
    }

    public float getSide1() {
        return side1;
    }
    @Override
    public void setType(String type) {
        super.setType(type);
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setComments(ArrayList<Comment> comments) {
        super.setComments(comments);
    }

    @Override
    public void setExist(int exist) {
        super.setExist(exist);
    }

    @Override
    public void setPrice(String price) {
        super.setPrice(price);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setAverage(float average) {
        super.setAverage(average);
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public ArrayList<Comment> getComments() {
        return super.getComments();
    }

    @Override
    public int isExist() {
        return super.isExist();
    }

    @Override
    public String getPrice() {
        return super.getPrice();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public float getAverage() {
        return super.getAverage();
    }


}

