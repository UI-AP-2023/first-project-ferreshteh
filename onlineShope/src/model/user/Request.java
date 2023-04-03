package model.user;

import model.articles.Article;

import java.util.ArrayList;

public class Request {
    private String info;

    private String phone;
    private ArrayList<Article> articles=new ArrayList<>();


//    public String getPhone() {
//        return phone;
//    }
//
//    @Override
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
String email;
String passWord;
String character
        ;

    @Override
    public String toString() {
        return "Request{" +
                "info='" + info + '\'' +
                ", phone='" + phone + '\'' +
                ", articles=" + articles +
                ", email='" + email + '\'' +
                ", passWord='" + passWord + '\'' +
                ", character='" + character + '\'' +
                '}';
    }

    public Request(String info, String character, String phone, String email, String passWord) {
        this.email=email;
        this.info=info;
        this.passWord=passWord;
        this.phone=phone;
        this.character=character;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setInfo(String info){
        this.info=info;
    }
    public void setArticles(ArrayList<Article> articles){
        if(articles!=null){
        this.articles.addAll(articles);
    }}



    public ArrayList<Article> getArticles() {
        return articles;
    }


    public String getInfo(){
        return info;
    }
    public ArrayList<Article> getArticle(){
        return articles;
    }


}
