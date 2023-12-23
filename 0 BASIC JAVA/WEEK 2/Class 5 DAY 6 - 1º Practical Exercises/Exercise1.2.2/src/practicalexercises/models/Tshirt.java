package practicalexercises.models;


public class Tshirt extends Clothing {
    String sleeve;
    String neck;

    public Tshirt(String sleeve, String neck, String code, String name, double price, String brand, String size, String color) {
        super(code, name, price, brand, size, color);
        this.sleeve = sleeve;
        this.neck = neck;
    }

    public String getSleeve() {
        return sleeve;
    }

    public void setSleeve(String sleeve) {
        this.sleeve = sleeve;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    @Override
    public String toString() {
        return "Tshirt{" + "sleeve=" + sleeve + ", neck=" + neck + super.toString();
    }
    
    public void displayBrand(){
        System.out.println("This T-shirt is branded" +  sleeve);
    }
    
}
