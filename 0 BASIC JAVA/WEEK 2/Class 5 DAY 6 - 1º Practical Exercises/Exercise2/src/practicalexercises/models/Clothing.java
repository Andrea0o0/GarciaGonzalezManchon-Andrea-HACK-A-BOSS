package practicalexercises.models;

public class Clothing {
    String code;
    String name;
    double price;
    String brand;
    String size;
    String color;

    public Clothing() {
    }
    
    public Clothing(String code, String name, double price, String brand, String size, String color) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.size = size;
        this.color = color;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Clothing{" + "code=" + code + ", name=" + name + ", price=" + price + ", brand=" + brand + ", size=" + size + ", color=" + color + '}';
    }
    
     public void displayBrand(){
         System.out.println(getClass());
    }
    
}
