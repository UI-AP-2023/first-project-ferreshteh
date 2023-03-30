package model.articles;

import model.others.Comment;

import java.util.ArrayList;

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
class Pencil extends Stationary {
    public Pencil(String id, String name, String price, float average, boolean exist, String type) {
        super(id, name, price, average, exist, type);
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



    private enum Type {
        HB, B, F, H, H2
    }
}
