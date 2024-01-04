package practicalexercises.exercise2.models;


public class Inventory {
    private String product;
    private double price;
    private int stock;

    public Inventory() {
    }
    
    public Inventory(String product, double price, int stock) {
        this.product = product;
        this.price = price;
        this.stock = stock;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Inventory{" + "product=" + product + ", price=" + price + ", stock=" + stock + '}';
    }
    
    
}
