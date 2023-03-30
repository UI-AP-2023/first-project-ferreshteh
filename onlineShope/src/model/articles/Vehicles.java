package model.articles;

abstract public class Vehicles extends Article{
    private String nameCompany;

    public Vehicles(String id, String name, String price, float average, boolean exist, String type,String nameCompany) {
        super(id, name, price, average, exist, type);
        this.nameCompany=nameCompany;
    }
}
