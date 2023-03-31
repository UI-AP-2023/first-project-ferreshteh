package model.user;

import model.articles.Article;

import java.util.ArrayList;

public class Request extends  Customer{
    private String info;

    private String phone;
    private ArrayList<Article> articles=new ArrayList<>();

    @Override
    public String toString() {
        return super.toString();
    }

    public Request(String info, String character, String phone, String email, String passWord) {
        super(info, character, phone, email, passWord);
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
