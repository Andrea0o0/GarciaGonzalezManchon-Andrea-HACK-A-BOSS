package practicalexercises.models;

public class Pant extends Clothing {
    String style;
    String typeFabric;

    public Pant(String style, String typeFabric, String code, String name, double price, String brand, String size, String color) {
        super(code, name, price, brand, size, color);
        this.style = style;
        this.typeFabric = typeFabric;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getTypeFabric() {
        return typeFabric;
    }

    public void setTypeFabric(String typeFabric) {
        this.typeFabric = typeFabric;
    }

    @Override
    public String toString() {
        return "Pants{" + "style=" + style + ", typeFabric=" + typeFabric + super.toString();
    }
    
    public void displayBrand(){
        System.out.println("These pants are brand" +  style);
    }
    
    
    
}
