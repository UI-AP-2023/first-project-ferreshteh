package model.articles;

import model.others.Comment;

import java.util.ArrayList;

abstract class Stationary extends Article{
    private String country;

    public Stationary(String id, String name, String price, float average, int exist, String type) {
        super(id, name, price, average, exist,type);
        setType(type);
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
    public void setComments(Comment comments) {
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

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Stationary{" +
                "country='" + country + '\'' +
                '}';
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
