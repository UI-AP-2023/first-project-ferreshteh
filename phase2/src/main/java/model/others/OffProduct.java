package model.others;

import java.time.LocalDate;

public class OffProduct {
    private double percent;
    private LocalDate expiration;
    private int capacity;
    private String id;

    public OffProduct(double percent, LocalDate expiration, int capacity) {
        this.percent = percent;
        this.expiration = expiration;
        this.capacity = capacity;
        id = String.valueOf(expiration) + String.valueOf(counter);
        Id_builder(this);
    }

    static int counter;

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        OffProduct.counter = counter;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //------------------------------------
    //setter of id
    private void Id_builder(OffProduct off) {
        String id = "Vision";
        id+=counter;
        id += String.valueOf(off.expiration);
        off.id=id;
    }
}
