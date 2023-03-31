package model.user;

import model.articles.Article;
import model.others.Comment;

import java.util.ArrayList;

public class SuperAdmin extends Account{
    public ArrayList<Request> getRequests() {
        return requests;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public static void setInstance(SuperAdmin instance) {
        SuperAdmin.instance = instance;
    }

    SuperAdmin(String info, String character) {
        super(info, character);
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }

    @Override
    public String getCharacter() {
        return super.getCharacter();
    }

    @Override
    public String toString() {
        return "SuperAdmin{" +
                "requests=" + requests +
                ", articles=" + articles +
                '}';
    }

    @Override
    public void setInfo(String info) {
        super.setInfo(info);
    }

    public void setArticles(Article articles) {
        this.articles.add(articles);
    }

    public void setRequests(ArrayList<Request> requests) {
        this.requests = requests;
    }

    private static SuperAdmin instance;
    private  SuperAdmin(String info) {
        super(info);
    }

    public static SuperAdmin getInstance() {
        if (instance == null) {
            instance = new SuperAdmin("admin") {

            };
        }
        return instance;
    }


    private   ArrayList<Request> requests=new ArrayList<>();
    private ArrayList<Article>articles=new ArrayList<>();
    private ArrayList<Comment> comments=new ArrayList<>();

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public void setRequests(Request request){
        requests.add(request);
    }
    public ArrayList<Request> getRequest(){
        return requests;
    }
}
