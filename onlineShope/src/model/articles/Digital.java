package model.articles;

abstract class Digital extends Article{
    private float wight;
    private float side1;
    private float side2;

    public Digital(String id, String name, String price, float average, boolean exist, String type,float wight,float side1,float side2) {
        super(id, name, price, average, exist);
        this.side1=side1;
        this.side2=side2;
        this.wight=wight;
        setType(type);
    }

    public float getWight() {
        return wight;
    }

    public void setSide2(float side2) {
        this.side2 = side2;
    }

    public void setSide1(float side1) {
        this.side1 = side1;
    }

    public void setWight(float wight) {
        this.wight = wight;
    }

    public float getSide2() {
        return side2;
    }

    public float getSide1() {
        return side1;
    }
}
