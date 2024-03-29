package controller;

import exception.ID_Off;
import model.articles.*;
import model.others.Comment;
import model.others.OffProduct;
import model.user.Customer;
import model.user.Request;
import model.user.SuperAdmin;
import view.Messages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SuperCon {

    String adminName;
    String id = "";
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
                addNoteBook(strings[2], strings[3], "stationary", Integer.parseInt(strings[4]), strings[5], Integer.parseInt(strings[6]), strings[7]);
            } else if (strings[1].equalsIgnoreCase("pen")) {//ok
                addPen(strings[2], strings[3], "stationary", Integer.parseInt(strings[4]), strings[5], strings[6]);
            } else if (strings[1].equalsIgnoreCase("pencil")) {
                addPencil(strings[2], strings[3], "stationary", Integer.parseInt(strings[4]), strings[5]);
            } else if (strings[1].equalsIgnoreCase("computer")) {
                addComputer(strings[2], strings[3], "DIGITAL", Integer.parseInt(strings[4]), strings[5], Float.parseFloat(strings[6]), Float.parseFloat(strings[7]), Float.parseFloat(strings[8]), Double.parseDouble(strings[9]));
            } else if (strings[1].equalsIgnoreCase("ssd")) {
                addSSD(strings[2], strings[3], "DIGITAL", Integer.parseInt(strings[4]), Float.parseFloat(strings[5]), Float.parseFloat(strings[6]), Float.parseFloat(strings[7]), Double.parseDouble(strings[8]), Double.parseDouble(strings[9]), Double.parseDouble(strings[10]));
            } else if (strings[1].equalsIgnoreCase("flash")) {
                addFlash(strings[2], strings[3], "DIGITAL", Integer.parseInt(strings[4]), Float.parseFloat(strings[5]), Float.parseFloat(strings[6]), Float.parseFloat(strings[7]), Double.parseDouble(strings[8]), strings[9]);
            } else if (strings[1].equalsIgnoreCase("meal")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
                LocalDate date = LocalDate.parse(strings[5], formatter);
                LocalDate date2 = LocalDate.parse(strings[6], formatter);
                addMeal(strings[2], strings[3], "meal", Integer.parseInt(strings[4]), date, date2);
                Messages.getInstance().printId(id);
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
        Machine machine = new Machine("123", name, price, 0, exist, "machine", nameCompany, capacity, auto);
        id = String.valueOf(machine.getNumber());
        id = id + name + price;
        machine.setId(id);
        this.id = id;
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
        this.id = id;
        SuperAdmin.getInstance().addArticle(bicycle);

    }

    public void addMeal(String name, String price, String type, int exist, LocalDate production, LocalDate expiration) {
        String id;
        Meal meal = new Meal("123", name, type, "1200", 0, exist, production, expiration);
        id = String.valueOf(meal.getNumber());
        id = id + name + price;
        meal.setId(id);
        this.id = id;
        SuperAdmin.getInstance().addArticle(meal);
    }

    public void addNoteBook(String name, String price, String type, int exist, String typePaper, int numberPaper, String country) {
        String id;
        NoteBook noteBook = new NoteBook("123", name, price, 0, exist, type, numberPaper, typePaper);
        noteBook.setCountry(country);
        id = String.valueOf(noteBook.getNumber());
        id = id + name + price;
        noteBook.setId(id);
        this.id = id;
        SuperAdmin.getInstance().addArticle(noteBook);
    }

    public void addPen(String name, String price, String type, int exist, String color, String country) {
        String id;
        Pen pen = new Pen("123", name, price, 0, exist, type, color);
        pen.setCountry(country);
        id = String.valueOf(pen.getNumber());
        id = id + name + price;
        pen.setId(id);
        this.id = id;
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
        this.id = id;
        SuperAdmin.getInstance().addArticle(pencil);
    }

    public void addComputer(String name, String price, String type, int exist, String modelCpu, float weight, float side1, float side2, double capacity) {
        String id;
        Computers computers = new Computers("123", name, price, 0, exist, type, weight, side1, side2, modelCpu, capacity);
        id = String.valueOf(computers.getNumber());
        id = id + name + price;
        computers.setId(id);
        this.id = id;
        SuperAdmin.getInstance().addArticle(computers);
    }

    public void addSSD(String name, String price, String type, int exist, float weight, float side1, float side2, double capacity, double speedWriting, double speedLoading) {
        String id;
        SSD ssd = new SSD("123", name, price, 0, exist, type, weight, side1, side2, capacity, speedLoading, speedWriting);
        id = String.valueOf(ssd.getNumber());
        id = id + name + price;
        ssd.setId(id);
        this.id = id;
        SuperAdmin.getInstance().addArticle(ssd);
    }

    public void addFlash(String name, String price, String type, int exist, float weight, float side1, float side2, double capacity, String usbType) {
        String id;
        FlashMemory flashMemory = new FlashMemory("123", name, price, 0, exist, type, weight, side1, side2, capacity, usbType);
        id = String.valueOf(flashMemory.getNumber());
        id = id + name + price;
        flashMemory.setId(id);
        this.id = id;
        SuperAdmin.getInstance().addArticle(flashMemory);
    }

    public void requestsManagement(String function) {
        Customer customer = null;
        //accept comment id1 id2
        String[] strings = function.split("\\s+");
        if (strings[0].equalsIgnoreCase("Accept")) {
            if (strings[1].equalsIgnoreCase("comment")) {
                acceptComment(strings[3], strings[2]);
            } else if (strings[1].equalsIgnoreCase("credit")) {
                acceptCredit(strings[2]);
            }
        }
    }

    public Customer requestUser(String function) {
        Customer customer = null;
        String[] strings = function.split("\\s+");
        if (strings[1].equalsIgnoreCase("user")) {//ok
            customer = acceptUser(strings[2]);
        }
        return customer;
    }

    public void acceptComment(String idAr, String idUser) {
        Article article = null;
        Customer customer = null;
        Comment comment = null;
        for (int i = 0; i < LoginController.getInstance().getAllCostumers().size(); i++) {
            if (LoginController.getInstance().getAllCostumers().get(i).getId().equals(idUser)) {
                customer = LoginController.getInstance().getAllCostumers().get(i);
                break;
            }
        }
        for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
            if (SuperAdmin.getInstance().getArticles().get(i).getId().equals(idAr)) {
                article = SuperAdmin.getInstance().getArticles().get(i);
            }
        }
        if (SuperAdmin.getInstance().getComments().size() != 0) {
            for (int i = 0; i < SuperAdmin.getInstance().getComments().size(); i++) {
                if (SuperAdmin.getInstance().getComments().get(i).getIdAr().equals(idAr)) {
                    if (SuperAdmin.getInstance().getComments().get(i).getCustomer().getId().equals(idUser)) {
                        comment = SuperAdmin.getInstance().getComments().get(i);
                        comment.setStation("accepted");
                        comment.setCustomer(customer);
                        assert article != null;
                        article.setComments(comment);
                        SuperAdmin.getInstance().getComments().remove(comment);
                        //
                    }
                }
            }
        }
    }

    public Customer acceptUser(String info) {//ok
        Customer customer = null;
        Request request;
        for (int i = 0; i < SuperAdmin.getInstance().getRequests().size(); i++) {
            request = SuperAdmin.getInstance().getRequest().get(i);
            if (request.getInfo().equals(info)) {
                //LoginController.getInstance().getAllCostumers().add(SuperAdmin.getInstance().getRequests().get(i));
                SuperAdmin.getInstance().getRequests().remove(SuperAdmin.getInstance().getRequests().get(i));
                customer = LoginController.getInstance().createId(info);
                customer.setEmail(request.getEmail());
                customer.setPhone(request.getPhone());
                customer.setInfo(request.getInfo());
                customer.setPassWord(request.getPassWord());
                break;
            }
        }
        return customer;
    }

    public void acceptCredit(String idUser) {
        for (int i = 0; i < LoginController.getInstance().getAllCostumers().size(); i++) {
            if (LoginController.getInstance().getAllCostumers().get(i).getId().equals(idUser)) {
                Customer customer = LoginController.getInstance().getAllCostumers().get(i);
                customer.upperCredit(customer.getDefaultValidity());
                System.out.println(customer.getCredit());
            }
        }
    }

    public String add_Off(Customer customer) {
        LocalDate lD = LocalDate.now();
        double price = 0;
        lD = lD.plusDays(5);
        double sum = 0;
        for (int i = 0; i < customer.getCart().size(); i++) {
            sum += Double.parseDouble(customer.getCart().get(i).getPrice());
        }
        if (sum > 5) {
            OffProduct off = new OffProduct(20, lD, 1);
            customer.getList_Offs().add(off);

            return off.getId();
        } else if (customer.getFactors().size() == 3) {
            OffProduct off = new OffProduct(30, lD, 1);
            customer.getList_Offs().add(off);
            for (int i = 0; i < customer.getCart().size(); i++) {
                price = Double.parseDouble(customer.getCart().get(i).getPrice());
                price = price - price * 30 / 100;
                customer.getCart().get(i).setPrice(String.valueOf(price));
            }
            return off.getId();
        }
        return "no chance to have off for you";
    }

    //------------------------------------------
    public void add_Off_Digi_pen_Pencil(String id, Customer customer) {
        Article find;
        double price = 0;
        for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
            if (customer.getCart().get(i).getId().equals(id)) {
                find = SuperAdmin.getInstance().getArticles().get(i);
                if (find instanceof Digital) {
                    ((Digital) find).add_Off(12);

                } else if (find instanceof Pencil)
                    ((Pencil) find).add_Off(40);
                else if (find instanceof Pen)
                    ((Pen) find).add_Off(30);
            }
        }
    }

    //--------------------------------------------
    public double[] accept_Off(String id, Customer customer) throws ID_Off {
        double[] total = new double[2];
        LocalDate currentTime = LocalDate.now();
        double first = 0;
        double end = 0;
        double price;
        int check = 0;
        OffProduct off;
        for (int i = 0; i < SuperAdmin.getInstance().getOffs().size(); i++) {
            off = SuperAdmin.getInstance().getOffs().get(i);
            if (SuperAdmin.getInstance().getOffs().get(i).getId().equals(id)) {
                if (SuperAdmin.getInstance().getOffs().get(i).getCapacity() > 0) {
                    if (SuperAdmin.getInstance().getOffs().get(i).getExpiration().isAfter(currentTime) || SuperAdmin.getInstance().getOffs().get(i).getExpiration().equals(currentTime)) {
                        if (customer.getList_Offs().contains(SuperAdmin.getInstance().getOffs().get(i))) {
                            check++;
                            for (int j = 0; j < customer.getCart().size(); j++) {
                                first += Double.parseDouble(customer.getCart().get(j).getPrice());
                                price = Double.parseDouble(customer.getCart().get(j).getPrice()) * (100 - off.getPercent());
                                end += Double.parseDouble(customer.getCart().get(j).getPrice()) * (100 - off.getPercent());
                                customer.getCart().get(j).setPrice(String.valueOf(price));
                            }

                        }
                    }
                }
            }
        }
        total[0] = first;
        total[1] = end;

        if (check == 0) {
            throw new ID_Off();
        }
        return total;
    }

    //-------------------------------------------
    public double[] accept_FinalOff(String id, Customer customer) throws ID_Off {
        double[] total = new double[2];
        LocalDate currentTime = LocalDate.now();
        double first = 0;
        double end = 0;
        double price;
        int check = 0;
        OffProduct off = null;
        for (int i = 0; i < customer.getList_Offs().size(); i++) {
            if(customer.getList_Offs().get(i).getId().equalsIgnoreCase(id)){
            off = SuperAdmin.getInstance().getOffs().get(i);}}

            for (int j = 0; j < customer.getCart().size(); j++) {
                first += Double.parseDouble(customer.getCart().get(j).getPrice());
                price = Double.parseDouble(customer.getCart().get(j).getPrice()) * (100 - off.getPercent());
                end += Double.parseDouble(customer.getCart().get(j).getPrice()) * (100 - off.getPercent());
                customer.getCart().get(j).setPrice(String.valueOf(price));
            }

        total[0] = first;
        total[1] = end;
        return total;
    }

    //-------------------------------------------
    public ArrayList<Article> filterCar() {
        ArrayList<Article> total = new ArrayList<>();
        for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
            if (SuperAdmin.getInstance().getArticles().get(i) instanceof Machine) {
                total.add(SuperAdmin.getInstance().getArticles().get(i));
            }
        }
        return total;
    }

    public ArrayList<Article> filterSSD() {
        ArrayList<Article> total = new ArrayList<>();
        for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
            if (SuperAdmin.getInstance().getArticles().get(i) instanceof SSD) {
                total.add(SuperAdmin.getInstance().getArticles().get(i));
            }
        }
        return total;
    }

    public ArrayList<Vehicles> filterVehicle() {
        ArrayList<Vehicles> total = new ArrayList<>();
        for (int i = 0; i < SuperAdmin.getInstance().getArticles().size(); i++) {
            if (SuperAdmin.getInstance().getArticles().get(i) instanceof Vehicles) {
                total.add((Vehicles) SuperAdmin.getInstance().getArticles().get(i));
            }
        }
        return total;
    }
}