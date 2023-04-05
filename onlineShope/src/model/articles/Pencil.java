package model.articles;

import model.others.Comment;
import view.Messages;

import java.util.ArrayList;

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class Pencil extends Stationary {
    String typePencil;
    public Pencil(String id, String name,String type, String price, float average, int exist, String typePen) {
        super(id, name, price, average, exist, type);
        setType(typePen);
    }

    @Override
    public String getCountry() {
        return super.getCountry();
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
      if(type.equalsIgnoreCase(Type.B.name())){
typePencil=type;
      }
      else if(type.equalsIgnoreCase(Type.H2.name())){
          typePencil=type;
      }
      else if(type.equalsIgnoreCase(Type.HB.name())){
          typePencil=type;
      }
      else if(type.equalsIgnoreCase(Type.H.name())){
          typePencil=type;
      }
      else if(type.equalsIgnoreCase(Type.F.name())){
          typePencil=type;
      }
      else {
          Messages.getInstance().printError();
      }
    }

    @Override
    public String toString() {
        return "Pencil{" +
                "typePencil='" + typePencil + '\'' +"country"+getCountry()+" "+"exist="+exist+" "+
                "name :"+name+"id :"+getId()+"price :"+price+"Avarege :"+getAverage()+"type :"+getType()+"comment :"+getComments()+
                '}';
    }

    private enum Type {
        HB, B, F, H, H2
    }
}
