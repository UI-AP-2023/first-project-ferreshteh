package model.articles;

import model.others.Comment;
import view.Messages;

import java.util.ArrayList;

public class Article {
    private String id;
    private float average;
    String name;
    String price;
    boolean exist;
    private ArrayList<Comment> comments = new ArrayList<>();

    String type;

    public String getId() {
        return id;
    }

    public float getAverage() {
        return average;
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

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAverage(float average) {
        this.average = average;
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
        this.comments = comments;
    }

    public void setType(String type) {
        if(Type.DIGITAL.name().equalsIgnoreCase(type)){
            this.type=type;
        }
        else if(Type.MEAL.name().equalsIgnoreCase(type)){
            this.type=type;
        }
        else if(Type.VEHICLE.name().equalsIgnoreCase(type)){
            this.type=type;
        }
        else if(Type.STATIONARY.name().equalsIgnoreCase(type)){
            this.type=type;
        }
        else {
            Messages messages=new Messages();
            messages.printError();
        }
    }

    public Article(String id,String name,String price,float average,boolean exist) {
        this.average=average;
        this.price=price;
        this.exist=exist;
        this.name=name;
        this.id = id;
        setType(type);
    }


    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", average=" + average +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", exist=" + exist +
                ", comments=" + comments +
                ", type='" + type + '\'' +
                '}';
    }
}
