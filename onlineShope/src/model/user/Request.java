package model.user;

import model.articles.Article;

import java.util.ArrayList;

public class Request {
    private String info;
    private String unAcceptedtId;
    private ArrayList<Article> articles=new ArrayList<>();
    public void setInfo(String info){
        this.info=info;
    }
    public void setArticles(ArrayList<Article> articles){
        if(articles!=null){
        this.articles.addAll(articles);
    }}
    public String getInfo(){
        return info;
    }
    public ArrayList<Article> getArticle(){
        return articles;
    }


}
