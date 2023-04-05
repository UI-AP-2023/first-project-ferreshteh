package model.others;

import model.articles.Article;
import model.user.Account;
import model.user.Customer;

public class Score {
    private Customer account;
    private double score;
    private static int number=0;
    public Score(double score, Customer customer,Article article){
        this.score=score;
        this.article=article;
        account=customer;
        number++;
    }

    public  int getNumber() {
        return number;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Customer account) {
        this.account = account;
    }

    private Article article;
}
