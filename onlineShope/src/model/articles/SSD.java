package model.articles;

import model.others.Comment;

import java.util.ArrayList;

public class SSD extends Storages {
    private double speedWriting;
    private double speedLoading;

    public SSD(String id, String name, String price, float average, int exist, String type, float wight, float side1, float side2, double capacity,double speedLoading,double speedWriting) {
        super(id, name, price, average, exist, type, wight, side1, side2, capacity);
        this.speedLoading=speedLoading;
        this.speedWriting=speedWriting;
    }

    @Override
    public String toString() {
        return "SSD{" +
                "speedWriting=" + speedWriting +
                ", speedLoading=" + speedLoading +
                '}';
    }

    public double getSpeedWriting() {
        return speedWriting;
    }

    public void setSpeedLoading(double speedLoading) {
        this.speedLoading = speedLoading;
    }

    public double getSpeedLoading() {
        return speedLoading;
    }

    public void setSpeedWriting(double speedWriting) {
        this.speedWriting = speedWriting;
    }

    @Override
    public float getWight() {
        return super.getWight();
    }

    @Override
    public void setSide2(float side2) {
        super.setSide2(side2);
    }

    @Override
    public void setSide1(float side1) {
        super.setSide1(side1);
    }

    @Override
    public void setWight(float wight) {
        super.setWight(wight);
    }

    @Override
    public float getSide2() {
        return super.getSide2();
    }

    @Override
    public float getSide1() {
        return super.getSide1();
    }

    @Override
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




}
