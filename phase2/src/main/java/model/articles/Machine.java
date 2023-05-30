package model.articles;

public class Machine extends Vehicles {
    private double capacityMotor;
    private boolean automatic;
    private String type;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    public Machine(String id, String name, String price, float average, int exist, String type, String nameCompany, double capacityMotor, boolean automatic) {
        super(id, name, price, average, exist, type,nameCompany);
        this.automatic=automatic;
        this.capacityMotor=capacityMotor;
        this.type=type;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "capacityMotor=" + capacityMotor +
                ", automatic=" + automatic +" "+"id='" + super.getId() + " " +
                "average=" +super.getAverage() +" "+
                "name=" + name + " " +
                "price=" + price + " " +
                "exist=" + exist +" "+
                "comments=" + super.getComments() +" "+"type="+type+" "+"company="+super.getNameCompany()+
                '}';
    }

    @Override
    public int getNumber() {
        return super.getNumber();
    }

    public double getCapacityMotor() {
        return capacityMotor;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public void setCapacityMotor(double capacityMotor) {
        this.capacityMotor = capacityMotor;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }

}
