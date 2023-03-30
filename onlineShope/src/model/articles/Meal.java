package model.articles;

import model.others.Comment;

import java.util.ArrayList;

class Meal extends Article{
    private String production;
    private String expiration;

    public Meal(String id, String name, String price, float average, boolean exist,String production,String expiration) {
        super(id, name, price, average, exist);
        setType(type);
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

    public boolean isExist() {
        return exist;
    }

    @Override
    public ArrayList<Comment> getComments() {
        return super.getComments();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.setId(id);
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

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.setComments(comments);
    }

}
