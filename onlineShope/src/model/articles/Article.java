package model.articles;

import model.others.Comment;
import view.Messages;

import java.util.ArrayList;

abstract public class Article {
    private String id;
    private float average;
    String name;
    String price;
    int exist;
    private static  int number=0;
    private ArrayList<Comment> comments = new ArrayList<>();

    public  int getNumber() {
        return number;
    }

    public int getExist() {
        return exist;
    }

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

    public int isExist() {
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

    public void setExist(int exist) {
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
          Messages.getInstance().printError();
        }
    }

    public Article(String id,String name,String price,float average,int exist,String type) {
        this.average=average;
        this.price=price;
        this.exist=exist;
        this.name=name;
        this.id = id;
        setType(type);
        number++;
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
