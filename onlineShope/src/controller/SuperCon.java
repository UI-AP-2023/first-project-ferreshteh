package controller;

import model.articles.*;
import model.others.Comment;
import model.user.Customer;
import model.user.SuperAdmin;
import view.Messages;

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

    public void productManagement(String function) {
        String[] strings = function.split("\\s+");
        if (strings[0].equalsIgnoreCase("add")) {
            if (strings[1].equalsIgnoreCase("machine")) {
                addVehicle(strings[2], strings[3], "VEHICLE", Integer.parseInt(strings[4]), strings[5], Double.parseDouble(strings[6]), Boolean.parseBoolean(strings[7]));
            } else if (strings[1].equalsIgnoreCase("Bicycle")) {
                addBic(strings[2], strings[3], "vehicle", Integer.parseInt(strings[4]), strings[5], strings[6]);
            } else if (strings[1].equalsIgnoreCase("noteBook")) {
                addNoteBook(strings[2], strings[3], "stationary", Integer.parseInt(strings[4]), strings[5], Integer.parseInt(strings[6]));
            } else if (strings[1].equalsIgnoreCase("pen")) {//ok
                addPen(strings[2], strings[3], "stationary", Integer.parseInt(strings[4]), strings[5]);
            } else if (strings[1].equalsIgnoreCase("pencil")) {
                addPencil(strings[2], strings[3], "stationary", Integer.parseInt(strings[4]), strings[5]);
            } else if (strings[1].equalsIgnoreCase("computer")) {
                addComputer(strings[2], strings[3], "DIGITAL", Integer.parseInt(strings[4]), strings[5], Float.parseFloat(strings[6]), Float.parseFloat(strings[7]), Float.parseFloat(strings[8]), Double.parseDouble(strings[9]));
            } else if (strings[1].equalsIgnoreCase("ssd")) {
                addSSD(strings[2], strings[3], "DIGITAL", Integer.parseInt(strings[4]), Float.parseFloat(strings[5]), Float.parseFloat(strings[6]), Float.parseFloat(strings[7]), Double.parseDouble(strings[8]), Double.parseDouble(strings[9]), Double.parseDouble(strings[10]));
            } else if (strings[1].equalsIgnoreCase("flash")) {
                addFlash(strings[2], strings[3], "DIGITAL", Integer.parseInt(strings[4]), Float.parseFloat(strings[5]), Float.parseFloat(strings[6]), Float.parseFloat(strings[7]), Double.parseDouble(strings[8]), strings[9]);
            }

        } else if (strings[0].equalsIgnoreCase("delete")) {
            delete(strings[1]);
        } else if (strings[0].equalsIgnoreCase("edit")) {
            if (strings[2].equalsIgnoreCase("name")) {
                editName(strings[1], strings[3]);
            } else if (strings[2].equalsIgnoreCase("price")) {
                editPrice(strings[1], strings[3]);
            } else if (strings[2].equalsIgnoreCase("exist")) {

                editExist(strings[2], Integer.parseInt(strings[3]));
            }
        }
    }

    public void addVehicle(String name, String price, String type, int exist, String nameCompany, double capacity, boolean auto) {
        String id;
        Machine machine = new Machine("123", name, price, 0, exist, type, nameCompany, capacity, auto);
        id = String.valueOf(machine.getNumber());
        id = id + name + price;
        machine.setId(id);
       SuperAdmin.getInstance().addArticle(machine);


    }

    public void delete(String id) {
        int check = 0;
        for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
            if (SuperAdmin.getInstance().getArticles().get(i).getId().equals(id)) {
                SuperAdmin.getInstance().getArticles().remove(SuperAdmin.getInstance().getArticles().get(i));
                check++;
                break;
            }
        }
        if (check == 0) {
            Messages.getInstance().printError();
        }
    }

    public void editName(String id, String name) {
        int check = 0;
        for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
            if (SuperAdmin.getInstance().getArticles().get(i).getId().equals(id)) {
                SuperAdmin.getInstance().getArticles().get(i).setName(name);
            }
        }
    }

    public void editExist(String id, int exist) {
        int check = 0;
        for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
            if (SuperAdmin.getInstance().getArticles().get(i).getId().equals(id)) {
                SuperAdmin.getInstance().getArticles().get(i).setExist(exist);
            }
        }
    }

    public void editPrice(String id, String price) {
        int check = 0;
        for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
            if (SuperAdmin.getInstance().getArticles().get(i).getId().equals(id)) {
                SuperAdmin.getInstance().getArticles().get(i).setPrice(price);
            }
        }
    }

    public void addBic(String name, String price, String type, int exist, String bicType, String nameCompany) {
        String id;
        Bicycle bicycle = new Bicycle("123", name, price, 0, exist, type, nameCompany, bicType);
        id = String.valueOf(bicycle.getNumber());
        id = id + name + price;
        bicycle.setId(id);
        SuperAdmin.getInstance().addArticle(bicycle);

    }

    public void addNoteBook(String name, String price, String type, int exist, String typePaper, int numberPaper) {
        String id;
        NoteBook noteBook = new NoteBook("123", name, price, 0, exist, type, numberPaper, typePaper);
        id = String.valueOf(noteBook.getNumber());
        id = id + name + price;
        noteBook.setId(id);
        SuperAdmin.getInstance().addArticle(noteBook);

    }

    public void addPen(String name, String price, String type, int exist, String color) {
        String id;
        Pen pen = new Pen("123", name, price, 0, exist, type, color);
        id = String.valueOf(pen.getNumber());
        id = id + name + price;
        pen.setId(id);
        SuperAdmin.getInstance().addArticle(pen);

    }
    //        SuperCon.getInstance().productManagement("add pencil pen1 450 6 hb");
    //addPencil(strings[2], strings[3], "stationary", Integer.parseInt(strings[4]), strings[5]);

    public void addPencil(String name, String price, String type, int exist, String typePen) {
        String id;
        Pencil pencil = new Pencil("123", name, type, price, 0, exist, typePen);
        id = String.valueOf(pencil.getNumber());
        id = id + name + price;
        pencil.setId(id);
        SuperAdmin.getInstance().addArticle(pencil);
    }

    public void addComputer(String name, String price, String type, int exist, String modelCpu, float weight, float side1, float side2, double capacity) {
        String id;
        Computers computers = new Computers("123", name, price, 0, exist, type, weight, side1, side2, modelCpu, capacity);
        id = String.valueOf(computers.getNumber());
        id = id + name + price;
        computers.setId(id);
        SuperAdmin.getInstance().addArticle(computers);

    }

    public void addSSD(String name, String price, String type, int exist, float weight, float side1, float side2, double capacity, double speedWriting, double speedLoading) {
        String id;
        SSD ssd = new SSD("123", name, price, 0, exist, "ssd", weight, side1, side2, capacity, speedLoading, speedWriting);
        id = String.valueOf(ssd.getNumber());
        id = id + name + price;
        ssd.setId(id);
        SuperAdmin.getInstance().addArticle(ssd);

    }

    public void addFlash(String name, String price, String type, int exist, float weight, float side1, float side2, double capacity, String usbType) {
        String id;
        FlashMemory flashMemory = new FlashMemory("123", name, price, 0, exist, "flash", weight, side1, side2, capacity, usbType);
        id = String.valueOf(flashMemory.getNumber());
        id = id + name + price;
        flashMemory.setId(id);
        SuperAdmin.getInstance().addArticle(flashMemory);
    }

    public void requestsManagement(String function) {
        Customer customer=null;
        String[] strings = function.split("\\s+");
        if (strings[0].equalsIgnoreCase("Accept")) {
            if (strings[1].equalsIgnoreCase("comment")) {
                acceptComment(strings[3], strings[2]);
            } else if (strings[1].equalsIgnoreCase("credit")) {
                acceptCredit(strings[2]);
            }
        }
    }
    public Customer requestUser(String function){
        Customer customer=null;
        String[] strings = function.split("\\s+");
         if (strings[1].equalsIgnoreCase("user")) {//ok
            customer= acceptUser(strings[2]);
        }
   return customer; }

    public void acceptComment(String idAr, String idUser) {
        Customer customer = null;
        Comment comment = null;
        for (int i = 0; i < LoginController.getInstance().getAllCostumers().size(); i++) {
            if (LoginController.getInstance().getAllCostumers().get(i).getId().equals(idUser)) {
                customer = LoginController.getInstance().getAllCostumers().get(i);
                break;
            }
        }
        for (int i = 0; i < SuperAdmin.getInstance().getComments().size(); i++) {
            if (SuperAdmin.getInstance().getComments().get(i).getIdAr().equals(idAr) && SuperAdmin.getInstance().getComments().get(i).getCustomer().getId().equals(idUser)) {
                comment = SuperAdmin.getInstance().getComments().get(i);
            }
        }
        for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
            if (SuperAdmin.getInstance().getArticles().get(i).getId().equals(idAr)) {
                SuperAdmin.getInstance().getArticles().get(i).setComments(comment);
                comment.setStation("Accepted");
                SuperAdmin.getInstance().getComments().remove(comment);
                comment.setCustomer(customer);
            }
        }
    }

    public Customer acceptUser(String info) {//ok
        Customer customer=null;
        for (int i = 0; i < SuperAdmin.getInstance().getRequests().size(); i++) {
            if (SuperAdmin.getInstance().getRequests().get(i).getInfo().equals(info)) {
                //LoginController.getInstance().getAllCostumers().add(SuperAdmin.getInstance().getRequests().get(i));
                SuperAdmin.getInstance().getRequests().remove(SuperAdmin.getInstance().getRequests().get(i));
              customer=  LoginController.getInstance().createId(info);
                break;
            }
        }
        return customer;
    }

    public void acceptCredit(String idUser) {
        for (int i = 0; i < LoginController.getInstance().getAllCostumers().size(); i++) {
            if (LoginController.getInstance().getAllCostumers().get(i).getId().equals(idUser)) {
                LoginController.getInstance().getAllCostumers().get(i).setCreditRequest(true);
                LoginController.getInstance().getAllCostumers().get(i).setCredit();
            }
        }
    }



}