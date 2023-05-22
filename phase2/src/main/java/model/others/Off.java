package model.others;

import java.time.LocalDate;

public class Off {
    private double percent;
    private LocalDate expiration;
    private int capacity;
    private String id;

    public Off(double percent, LocalDate expiration, int capacity) {
        this.percent = percent;
        this.expiration = expiration;
        this.capacity = capacity;
        id = String.valueOf(expiration) + String.valueOf(counter);
        Id_builder(this);
    }

    static int counter;

    //------------------------------------
    //setter of id
    private void Id_builder(Off off) {
        String id = "Vision";
        id+=counter;
        id += String.valueOf(off.expiration);
        off.id=id;
    }
}
