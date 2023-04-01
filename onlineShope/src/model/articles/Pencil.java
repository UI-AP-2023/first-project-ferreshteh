package model.articles;

import model.others.Comment;

import java.util.ArrayList;

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class Pencil extends Stationary {
    public Pencil(String id, String name,String type, String price, float average, int exist, String typePen) {
        super(id, name, price, average, exist, typePen);
        setType(type);
    }

    @Override
    public String getCountry() {
        return super.getCountry();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void setCountry(String country) {
        super.setCountry(country);
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



    private enum Type {
        HB, B, F, H, H2
    }
}
