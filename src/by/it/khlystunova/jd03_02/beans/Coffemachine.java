package by.it.khlystunova.jd03_02.beans;

public class Coffemachine {

    private long id;
    private String name;
    private long firm_ID;
    private int power;
    private String size;
    private double weight;
    private long steam_ID;
    private String waterContainer;
    private String beansContainer;
    private String color;
    private double price;

    public Coffemachine() {
    }

    public Coffemachine(long id, String name, long firm_ID, int power, String size, double weight, long steam_ID, String waterContainer, String beansContainer, String color, double price) {
        this.id = id;
        this.name = name;
        this.firm_ID = firm_ID;
        this.power = power;
        this.size = size;
        this.weight = weight;
        this.steam_ID = steam_ID;
        this.waterContainer = waterContainer;
        this.beansContainer = beansContainer;
        this.color = color;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getFirm_ID() {
        return firm_ID;
    }

    public int getPower() {
        return power;
    }

    public String getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }

    public long getSteam_ID() {
        return steam_ID;
    }

    public String getWaterContainer() {
        return waterContainer;
    }

    public String getBeansContainer() {
        return beansContainer;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirm_ID(long firm_ID) {
        this.firm_ID = firm_ID;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setSteam_ID(long steam_ID) {
        this.steam_ID = steam_ID;
    }

    public void setWaterContainer(String waterContainer) {
        this.waterContainer = waterContainer;
    }

    public void setBeansContainer(String beansContainer) {
        this.beansContainer = beansContainer;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Coffemachine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firm_ID=" + firm_ID +
                ", power=" + power +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                ", steam_ID=" + steam_ID +
                ", waterContainer='" + waterContainer + '\'' +
                ", beansContainer='" + beansContainer + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
