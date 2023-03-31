package controller;

import model.articles.*;
import model.user.Customer;
import model.user.SuperAdmin;
import controller.LoginController;
import view.Login;

import java.util.ArrayList;

public class SuperCon {

    String adminName;
    private static SuperCon instance;

    private SuperCon(String info) {
        adminName = info;
    }
    public static SuperCon getInstance() {
        if (instance == null) {
            instance = new SuperCon("admin") {

            };
        }
        return instance;
    }
    public void productManagement(String function){
       String[]strings= function.split(" ");
       if(strings[0].equalsIgnoreCase("add") ){
           if(strings[1].equalsIgnoreCase("Vehicle")){
addVehicle(strings[2],strings[3],strings[1],Integer.parseInt(strings[4]),strings[5],Double.parseDouble(strings[6]),Boolean.parseBoolean(strings[7]));
           }
       }
    }
    public void addVehicle(String name, String price, String type, int exist, String nameCompany, double capacity, boolean auto) {
        String id;
            Machine machine = new Machine("123", name, price, 0, exist, "machine", nameCompany, capacity, auto);
            id = String.valueOf(machine.getNumber());
            id = id + name + price;
            machine.setId(id);
            SuperAdmin.getInstance().setArticles(machine);


    }
public void addBic(String name, String price, String type, int exist,String bicType,String nameCompany){
    String id;
    Bicycle bicycle = new Bicycle("123", name, price, 0, exist, "bicycle",nameCompany,bicType);
    id = String.valueOf(bicycle.getNumber());
    id = id + name + price;
   bicycle.setId(id);
    SuperAdmin.getInstance().setArticles(bicycle);

}
    public void addNoteBook(String name, String price, String type, int exist,int numberPaper,String typePaper){
        String id;
        NoteBook noteBook = new NoteBook("123", name, price, 0, exist, "noteBook",numberPaper,typePaper);
        id = String.valueOf(noteBook.getNumber());
        id = id + name + price;
        noteBook.setId(id);
        SuperAdmin.getInstance().setArticles(noteBook);

    }
    public void addPen(String name, String price, String type, int exist,String color){
        String id;
        Pen pen = new Pen("123", name, price, 0, exist, "Pen",color);
        id = String.valueOf(pen.getNumber());
        id = id + name + price;
        pen.setId(id);
        SuperAdmin.getInstance().setArticles(pen);

    }
    public void addPencil(String name, String price, String type, int exist,String typePen){
        String id;
        Pencil pencil = new Pencil("123", name, "pencil",price, 0, exist, typePen);
        id = String.valueOf(pencil.getNumber());
        id = id + name + price;
        pencil.setId(id);
        SuperAdmin.getInstance().setArticles(pencil);
    }
    public void addComputer(String name, String price, String type, int exist,String modelCpu,float weight,float side1,float side2,double capacity){
        String id;
       Computers computers= new Computers("123", name, price, 0, exist, "computer",weight,side1,side2,modelCpu,capacity);
        id = String.valueOf(computers.getNumber());
        id = id + name + price;
        computers.setId(id);
        SuperAdmin.getInstance().setArticles(computers);

    }
    public void addSSD(String name, String price, String type, int exist,float weight,float side1,float side2,double capacity,double speedWriting,double speedLoading){
        String id;
        SSD ssd= new SSD("123", name, price, 0, exist, "ssd",weight,side1,side2,capacity,speedLoading,speedWriting);
        id = String.valueOf(ssd.getNumber());
        id = id + name + price;
        ssd.setId(id);
        SuperAdmin.getInstance().setArticles(ssd);

    }
    public void addFlash(String name, String price, String type, int exist,float weight,float side1,float side2,double capacity,String usbType){
        String id;
        FlashMemory flashMemory = new FlashMemory("123", name, price, 0, exist, "flash",weight,side1,side2,capacity,usbType);
        id = String.valueOf(flashMemory.getNumber());
        id = id + name + price;
        flashMemory.setId(id);
        SuperAdmin.getInstance().setArticles(flashMemory);
    }

}