package model.user;

public abstract class Account {
    private String info;

    public Account(String info) {
        this.info=info;
    }

    public String getInfo(){
        return info;
    }

    private String character;
}
