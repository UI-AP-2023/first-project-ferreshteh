package model.articles;

import model.others.Comment;

import java.util.ArrayList;

public class NoteBook extends Stationary {
    private int numPaper;
    private String typePaper;

    public NoteBook(String id, String name, String price, float average, int exist, String type,int numPaper,String typePaper) {
        super(id, name, price, average, exist, type);
        this.numPaper=numPaper;
        this.typePaper=typePaper;
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
    public void setCountry(String country) {
        super.setCountry(country);
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    public void setTypePaper(String typePaper) {
        this.typePaper = typePaper;
    }

    public void setNumPaper(int numPaper) {
        this.numPaper = numPaper;
    }

    public String getTypePaper() {
        return typePaper;
    }

    public int getNumPaper() {
        return numPaper;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "numPaper=" + numPaper +
                ", typePaper='" + typePaper  +' ' +", id='"+super.getId()+' ' +",exist= "+exist +" "+ "price="+price+" "+ "name="+name+
                " "+"type"+type+" "+"comment"+super.getComments2()+" "+"average="+getAverage()+" "+"country="+super.getCountry()+
                '}';
    }
}
