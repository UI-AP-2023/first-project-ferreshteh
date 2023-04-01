package model.others;

import model.articles.Article;

import java.util.ArrayList;

public class Factor {

    private String idFactor;
    private String history;
    private double cash;
    private ArrayList<Article> articles = new ArrayList<>();
     public Factor(String idFactor,String history,double cash){
         this.cash=cash;
         this.idFactor=idFactor;
         this.history=history;
     }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(Article article) {
       articles.add(article);
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getIdFactor() {
        return idFactor;
    }

    public void setIdFactor(String idFactor) {
        this.idFactor = idFactor;
    }
}
