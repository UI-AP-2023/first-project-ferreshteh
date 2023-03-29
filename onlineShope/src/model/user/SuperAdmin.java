package model.user;

import model.articles.Article;

import java.util.ArrayList;

public class SuperAdmin extends Account{
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
    public void setRequests(Request request){
        requests.add(request);
    }
    public ArrayList<Request> getRequest(){
        return requests;
    }
}
