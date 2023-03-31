package model.articles;

import model.others.Comment;

import java.util.ArrayList;

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
abstract public class Storages extends Digital {
    private double capacity;

    public Storages(String id, String name, String price, float average, int exist, String type, float wight, float side1, float side2,double capacity) {
        super(id, name, price, average, exist,type, wight, side1, side2);
        this.capacity=capacity;
        setType(type);

    }
    public void setType(String type) {
        super.setType(type);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public float getSide1() {
        return super.getSide1();
    }

    @Override
    public float getSide2() {
        return super.getSide2();
    }

    @Override
    public void setWight(float wight) {
        super.setWight(wight);
    }

    @Override
    public void setSide1(float side1) {
        super.setSide1(side1);
    }

    @Override
    public void setSide2(float side2) {
        super.setSide2(side2);
    }

    @Override
    public float getWight() {
        return super.getWight();
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
