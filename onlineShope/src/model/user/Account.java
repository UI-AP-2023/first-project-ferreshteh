package model.user;

public abstract class Account {
    Account(String info,String character){
        this.info=info;
        this.character=character;
    }
    private String info;
    private String character;
    public Account(String info) {
        this.info=info;
    }

    public String getInfo(){
        return info;
    }

    public String getCharacter() {
        return character;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Account{" +
                "info='" + info + '\'' +
                ", character='" + character + '\'' +
                '}';
    }


}
