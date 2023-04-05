package model.articles;

import model.others.Comment;
import view.Messages;

import java.util.ArrayList;

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class Bicycle extends Vehicles {
String bicType;
    public Bicycle(String id, String name, String price, float average, int exist, String type,String nameCompany,String bicType) {
        super(id, name, price, average, exist, type,nameCompany);
        setBicType(bicType);
        setType(type);

    }

    private enum Type {
        MOUNTAINOUS, ROAD, URBAN, HYBRID
    }

    @Override
    public void score(double score) {
        super.score(score);
    }


    @Override
    public String toString() {
        return "Bicycle{" +
                "bicType=" + bicType + "name :"+name+"id :"+getId()+"price :"+price+"Avarege :"+getAverage()+"type :"+getType()+"comment :"+getComments()+
              "nameCompany"+getNameCompany()+  '}';
    }

    @Override
    public int getNumber() {
        return super.getNumber();
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


    public void setBicType(String bicType) {

        if(bicType.equalsIgnoreCase(Type.HYBRID.name())){
            this.bicType=bicType;
        }
        else if(bicType.equalsIgnoreCase(Type.URBAN.name())){
            this.bicType=bicType;
        }
        else if(bicType.equalsIgnoreCase(Type.MOUNTAINOUS.name())){
            this.bicType=bicType;
        }
        else if(bicType.equalsIgnoreCase(Type.ROAD.name())){
            this.bicType=bicType;
        }
        else {
         Messages.getInstance().printError();
        }
    }
}
