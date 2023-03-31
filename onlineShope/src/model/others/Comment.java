package model.others;

import model.user.Customer;
import view.Messages;

public class Comment  {
    private Customer customer;
    private String idAr;
    private String text;

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "customer=" + customer +
                ", id='" + idAr + '\'' +
                ", comment=" + text +
                ", buy=" + buy +
                '}';
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIdAr(String idAr) {
        this.idAr = idAr;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isBuy() {
        return buy;
    }

    public String getText() {
        return text;
    }

    public String getIdAr() {
        return idAr;
    }

    public Customer getCustomer() {
        return customer;
    }

    private enum Station {
        WAITING, ACCEPTED, NOTACCEPTED
    }
    String station;
   public void setStation(String station){
       if(Station.ACCEPTED.name().equalsIgnoreCase(station)){

       this.station=station;}
       else if(Station.WAITING.name().equalsIgnoreCase(station)){
           this.station=station;
       }
       else if(Station.NOTACCEPTED.name().equalsIgnoreCase(station)){
           this.station=station;
       }
       else {
           Messages.getInstance().printError();
       }
   }

    public Comment(Customer customer,String station,String id,String text) {
        this.customer = customer;
        this.station=station;
        this.text=text;
        this.idAr =id;
    }


    private boolean buy;
}
