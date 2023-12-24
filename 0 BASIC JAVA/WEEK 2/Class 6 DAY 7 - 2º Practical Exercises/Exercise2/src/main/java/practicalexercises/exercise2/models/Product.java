package practicalexercises.exercise2.models;


public class Product implements Cloneable {
    int code;
    String name, brand, type;
    double costPrice, salesPrice;
    int stock;

    public Product(int code, String name, String brand, String type, double costPrice, double salesPrice, int stock) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.costPrice = costPrice;
        this.salesPrice = salesPrice;
        this.stock = stock;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" + "code=" + code + ", name=" + name + ", brand=" + brand + ", type=" + type + ", costPrice=" + costPrice + ", salesPrice=" + salesPrice + ", stock=" + stock + '}';
    }
    
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }   
    
}
