package practicalexercises.models;

public class Appliance {
    private int code;
    private String brand;
    private String model;
    private double consumption;
    private String color;

    public Appliance(int code, String brand, String model, double consumption, String color) {
        this.code = code;
        this.brand = brand;
        this.model = model;
        this.consumption = consumption;
        this.color = color;
    }

    public Appliance() {
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getConsumption() {
        return consumption;
    }
}