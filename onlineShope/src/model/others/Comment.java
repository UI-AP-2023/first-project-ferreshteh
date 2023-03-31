package model.others;

import controller.LoginController;
import model.user.Account;
import model.user.Customer;

public class Comment  {
    private Customer customer;
    private String id;
    private StringBuilder comment;

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "customer=" + customer +
                ", id='" + id + '\'' +
                ", comment=" + comment +
                ", buy=" + buy +
                '}';
    }

    public void setComment(StringBuilder comment) {
        this.comment = comment;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isBuy() {
        return buy;
    }

    public StringBuilder getComment() {
        return comment;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    private enum Station {
        WAITING, ACCEPTED, NOTACCEPTED
    }
    public void setComment(){

    }
    private boolean buy;
}
