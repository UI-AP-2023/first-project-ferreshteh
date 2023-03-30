package model.articles;

import model.others.Comment;

import java.util.ArrayList;

class FlashMemory extends Storages {
    private String usbType;
enum Type{
    USB1,USB2,USB3
}
    public FlashMemory(String id, String name, String price, float average, boolean exist, String type, float wight, float side1, float side2, double capacity,String usbType) {
        super(id, name, price, average, exist, type, wight, side1, side2, capacity);
        this.usbType=usbType;
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


    public String getUsbType() {
        return usbType;
    }

    public void setUsbType(String usbType) {
        this.usbType = usbType;
    }

    @Override
    public String toString() {
        return "FlashMemory{" +
                "usbType='" + usbType + '\'' +
                '}';
    }
}
