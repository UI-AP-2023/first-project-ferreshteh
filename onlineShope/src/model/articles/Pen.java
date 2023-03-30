package model.articles;

import model.others.Comment;

import java.util.ArrayList;

class Pen extends Stationary {
    private String color;

    public Pen(String id, String name, String price, float average, boolean exist, String type,String color) {
        super(id, name, price, average, exist, type);
        this.color=color;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "color='" + color + '\'' +
                '}';
    }

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
    public boolean isExist() {
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
    public void setExist(boolean exist) {
        super.setExist(exist);
    }

    @Override
    public void setComments(ArrayList<Comment> comments) {
        super.setComments(comments);
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }


}
