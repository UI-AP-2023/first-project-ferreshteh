package model.articles;

import model.others.Comment;
import view.Messages;

import java.util.ArrayList;
import java.util.Objects;

abstract public class Article implements Comparable<Article> {
    private String id;
    private float average;
    String name;
    String price;
    int exist;
    private static int number = 0;
    private ArrayList<Comment> comments = new ArrayList<>();

    public int compareTo(Article o) {
        if (o instanceof Meal && this instanceof Meal) {
            if (this.getName().compareTo(o.getName()) > 0)
                return 1;
            else if (this.getName().compareTo(o.getName()) < 0)
                return -1;
            else {
                if (((Meal) this).getExpiration().isAfter(((Meal) o).getExpiration()))
                    return -1;
                else if (((Meal) this).getExpiration().isBefore(((Meal) o).getExpiration()))
                    return 1;
                else {
                    if (this.getAverage() > o.getAverage())
                        return 1;
                    else if (this.getAverage() < o.getAverage())
                        return -1;
                    else {
                        if (Double.parseDouble(this.getPrice()) < Double.parseDouble(o.getPrice()))
                            return 1;
                        else if (Double.parseDouble(this.getPrice()) > Double.parseDouble(o.getPrice()))
                            return -1;
                        else {
                            if (this.getExist() > o.exist)
                                return 1;
                            else if (this.exist < o.exist)
                                return -1;
                            else
                                return 0;
                        }
                    }
                }
            }
        } else if (this instanceof Meal) {
            return 1;
        } else if (o instanceof Meal)
            return -1;
            //Vehicle
        else if (this instanceof Vehicles && o instanceof Vehicles) {
            if (this instanceof Machine && o instanceof Machine) {
                if (this.getName().compareTo(o.getName()) > 0)
                    return 1;
                else if (this.getName().compareTo(o.getName()) < 0)
                    return -1;
                else {
                    if (((Machine) this).isAutomatic() && ((Machine) o).isAutomatic()) {
                        if (this.getAverage() > o.getAverage())
                            return 1;
                        else if (this.getAverage() < o.getAverage())
                            return -1;
                        else {
                            if (Double.parseDouble(this.getPrice()) < Double.parseDouble(o.getPrice()))
                                return 1;
                            else if (Double.parseDouble(this.getPrice()) > Double.parseDouble(o.getPrice()))
                                return -1;
                            else {
                                if (this.getExist() > o.exist)
                                    return 1;
                                else if (this.exist < o.exist)
                                    return -1;
                                else
                                    return 0;
                            }
                        }
                    } else if (((Machine) this).isAutomatic())
                        return 1;
                    else if (((Machine) o).isAutomatic())
                        return -1;


                }
            } else if (this instanceof Machine)
                return 1;
            else if (o instanceof Machine)
                return -1;
            else {
                return 0;
            }
        }

        //Stationary
        else if (this instanceof Stationary && o instanceof Stationary) {
            if (this instanceof NoteBook && o instanceof NoteBook) {
                if (this.getName().compareTo(o.getName()) > 0)
                    return 1;
                else if (this.getName().compareTo(o.getName()) < 0)
                    return -1;
                if (((NoteBook) this).getNumPaper() > ((NoteBook) o).getNumPaper())
                    return 1;
                else if (((NoteBook) this).getNumPaper() < ((NoteBook) o).getNumPaper())
                    return -1;
                    else {
                        if (this.getAverage() > o.getAverage())
                            return 1;
                        else if (this.getAverage() < o.getAverage())
                            return -1;
                        else {
                            if (Double.parseDouble(this.getPrice()) < Double.parseDouble(o.getPrice()))
                                return 1;
                            else if (Double.parseDouble(this.getPrice()) > Double.parseDouble(o.getPrice()))
                                return -1;
                            else {
                                if (this.getExist() > o.exist)
                                    return 1;
                                else if (this.exist < o.exist)
                                    return -1;
                                else
                                    return 0;
                            }
                        }
                    }
            } else if (this instanceof Pen && o instanceof Pen) {
                if (this.getName().compareTo(o.getName()) > 0)
                    return 1;
                else if (this.getName().compareTo(o.getName()) < 0)
                    return -1;
                if (Objects.equals(((Pen) this).getColor(), "blue"))
                    return 1;
                else if (((Pen) o).getColor().equalsIgnoreCase("blue"))
                    return -1;
                else {
                    if (this.getAverage() > o.getAverage())
                        return 1;
                    else if (this.getAverage() < o.getAverage())
                        return -1;
                    else {
                        if (Double.parseDouble(this.getPrice()) < Double.parseDouble(o.getPrice()))
                            return 1;
                        else if (Double.parseDouble(this.getPrice()) > Double.parseDouble(o.getPrice()))
                            return -1;
                        else {
                            if (this.getExist() > o.exist)
                                return 1;
                            else if (this.exist < o.exist)
                                return -1;
                            else
                                return 0;
                        }
                    }
                }

            } else if (this instanceof Pencil && o instanceof Pencil) {
                if (this.getName().compareTo(o.getName()) > 0)
                    return 1;
                else if (this.getName().compareTo(o.getName()) < 0)
                    return -1;
                if (this.getType().equalsIgnoreCase("hb"))
                    return 1;
                else if (o.getType().equalsIgnoreCase("hb"))
                    return -1;
                else {
                    if (this.getAverage() > o.getAverage())
                        return 1;
                    else if (this.getAverage() < o.getAverage())
                        return -1;
                    else {
                        if (Double.parseDouble(this.getPrice()) < Double.parseDouble(o.getPrice()))
                            return 1;
                        else if (Double.parseDouble(this.getPrice()) > Double.parseDouble(o.getPrice()))
                            return -1;
                        else {
                            if (this.getExist() > o.exist)
                                return 1;
                            else if (this.exist < o.exist)
                                return -1;
                            else
                                return 0;
                        }
                    }
                }

            } else if (this instanceof Pen)
                return 1;
            else if (o instanceof Pen)
                return -1;
            else if (this instanceof Pencil)
                return 1;
            else if (o instanceof Pencil)
                return -1;
            else if (this instanceof NoteBook)
                return 1;
            else if (o instanceof NoteBook)
                return -1;
            //Digital

        } else if (this instanceof Digital && o instanceof Digital) {
            //Computer
            if (this instanceof Computers && o instanceof Computers) {
                if (this.getName().compareTo(o.getName()) > 0)
                    return 1;
                else if (this.getName().compareTo(o.getName()) < 0)
                    return -1;
                else {
                    if (((Computers) this).getCapacityRam() > ((Computers) o).getCapacityRam())
                        return 1;
                    else if (((Computers) this).getCapacityRam() == ((Computers) o).getCapacityRam()) {
                        if (((Computers) this).getWight() < ((Computers) o).getWight())
                            return 1;
                        else return -1;
                    } else if (this.getAverage() > o.getAverage())
                        return 1;
                    else if (this.getAverage() < o.getAverage())
                        return -1;
                    else {
                        if (Double.parseDouble(this.getPrice()) < Double.parseDouble(o.getPrice()))
                            return 1;
                        else if (Double.parseDouble(this.getPrice()) > Double.parseDouble(o.getPrice()))
                            return -1;
                        else {
                            if (this.getExist() > o.exist)
                                return 1;
                            else if (this.exist < o.exist)
                                return -1;
                            else
                                return 0;
                        }
                    }
                }
            } else if (this instanceof FlashMemory && o instanceof FlashMemory) {
                if (this.getName().compareTo(o.getName()) > 0)
                    return 1;
                else if (this.getName().compareTo(o.getName()) < 0)
                    return -1;
                else {
                    if (((FlashMemory) this).getWight() < ((FlashMemory) o).getWight())
                        return 1;
                    else if (((FlashMemory) this).getWight() > ((FlashMemory) o).getWight())
                        return -1;
                    else {
                        if (this.getAverage() > o.getAverage())
                            return 1;
                        else if (this.getAverage() < o.getAverage())
                            return -1;
                        else {
                            if (Double.parseDouble(this.getPrice()) < Double.parseDouble(o.getPrice()))
                                return 1;
                            else if (Double.parseDouble(this.getPrice()) > Double.parseDouble(o.getPrice()))
                                return -1;
                            else {
                                if (this.getExist() > o.exist)
                                    return 1;
                                else if (this.exist < o.exist)
                                    return -1;
                                else
                                    return 0;
                            }
                        }
                    }
                }
            }
            //SSD
            else if (this instanceof SSD && o instanceof SSD) {
                if (this.getName().compareTo(o.getName()) > 0)
                    return 1;
                else if (this.getName().compareTo(o.getName()) < 0)
                    return -1;
                else {
                    if (((SSD) this).getSpeedLoading() > ((SSD) o).getSpeedLoading())
                        return 1;
                    else if (((SSD) this).getSpeedLoading() < ((SSD) o).getSpeedLoading())
                        return -1;
                    else {
                        if (((SSD) this).getSpeedWriting() > ((SSD) o).getSpeedWriting())
                            return 1;
                        else if (((SSD) this).getSpeedWriting() < ((SSD) o).getSpeedWriting())
                            return -1;
                        else {
                            if (this.getAverage() > o.getAverage())
                                return 1;
                            else if (this.getAverage() < o.getAverage())
                                return -1;
                            else {
                                if (Double.parseDouble(this.getPrice()) < Double.parseDouble(o.getPrice()))
                                    return 1;
                                else if (Double.parseDouble(this.getPrice()) > Double.parseDouble(o.getPrice()))
                                    return -1;
                                else {
                                    if (this.getExist() > o.exist)
                                        return 1;
                                    else if (this.exist < o.exist)
                                        return -1;
                                    else
                                        return 0;
                                }
                            }
                        }
                    }
                }
            }


        }


        return 0;
    }

    public int getNumber() {
        return number;
    }

    public int getExist() {
        return exist;
    }

    String type;

    public String getId() {
        return id;
    }

    public float getAverage() {
        return average;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int isExist() {
        return exist;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public String getComments2() {
        String str = "";
        for (int i = 0; i < comments.size(); i++) {
            str = str + comments.get(i).getText();
        }
        return str;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAverage(float average) {
        this.average += average;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }

    public void setComments(Comment comment) {
        comments.add(comment);
    }

    public void setType(String type) {
        if (Type.DIGITAL.name().equalsIgnoreCase(type)) {
            this.type = type;
        } else if (Type.MEAL.name().equalsIgnoreCase(type)) {
            this.type = type;
        } else if (Type.VEHICLE.name().equalsIgnoreCase(type)) {
            this.type = type;
        } else if (Type.STATIONARY.name().equalsIgnoreCase(type)) {
            this.type = type;
        } else {
            Messages.getInstance().printError();
        }
    }

    public Article(String id, String name, String price, float average, int exist, String type) {
        this.average = average;
        this.price = price;
        this.exist = exist;
        this.name = name;
        this.id = id;
        setType(type);
        number++;
    }

    public void lowerExist(int exist) {
        this.exist = this.exist - exist;

    }

    public void score(double score) {
        average += score;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", average=" + average +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", exist=" + exist +
                ", comments=" + comments +
                ", type='" + type + '\'' +
                '}';
    }
}
