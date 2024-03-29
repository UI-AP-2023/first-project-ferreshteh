package model.others;

import model.articles.Article;

import java.util.ArrayList;
import java.util.Arrays;

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
     String[]strings;

    public void setStrings(String[] strings) {
        this.strings = strings;
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
    public String order(){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<=strings.length/2;i++){
            str.append("id");
        str.append(strings[i]);
        str.append("numberOf");
        i++;
        str.append(strings[i]);}
        return String.valueOf(str);}

    @Override
    public String toString() {
        return "Factor{" +
                "idFactor='" + idFactor + '\'' +
                ", history='" + history + '\'' +
                ", cash=" + cash +
                ", articles=" + articles +
                ", strings=" + Arrays.toString(strings) +
                '}';
    }
    public String printArticles(){
        String str="";
        for(int i=0;i<articles.size();i++){
            str+="Name: "+"i"+articles.get(i).getName()+"  "+"ID: "+articles.get(i).getId()+"\n";
        }
        return str;
    }
}
