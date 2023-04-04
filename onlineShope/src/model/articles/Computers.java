package model.articles;

import model.others.Comment;

import java.util.ArrayList;

public class Computers extends Digital {
    private String modelCpu;
    private double capacityRam;

    public Computers(String id, String name, String price, float average, int exist, String type, float wight, float side1, float side2,String modelCpu,double capacityRam) {
        super(id, name, price, average, exist, type, wight, side1, side2);
        this.capacityRam=capacityRam;
        this.modelCpu=modelCpu;
    }


    public void setCapacityRam(double capacityRam) {
        this.capacityRam = capacityRam;
    }

    public void setModelCpu(String modelCpu) {
        this.modelCpu = modelCpu;
    }

    public double getCapacityRam() {
        return capacityRam;
    }

    public String getModelCpu() {
        return modelCpu;
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

    @Override
    public String toString() {
        return "Computers{" +
                "modelCpu='" + modelCpu + '\'' +
                ", capacityRam=" + capacityRam + "id='" + super.getId() + '\'' +
                ", average=" +super.getAverage() +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", exist=" + exist +
                ", comments=" + super.getComments() +
                ", type='" + type +
                '}';
    }

}
