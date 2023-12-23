package practicalexercises.models;

public class Shoe extends Clothing {
    String material;
    String closureType;
    
    public Shoe(String code, String name, double price, String brand, String size, String color,
            // SHOE ATTRIBUTES:
            String material, String closureType) {
        super(code, name, price, brand, size, color);
        this.material = material;
        this.closureType = closureType;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getClosureType() {
        return closureType;
    }

    public void setClosureType(String closureType) {
        this.closureType = closureType;
    }

    @Override
    public String toString() {
        return super.toString() + "Shoe {" + "material=" + material + ", closureType=" + closureType + "}";
    }
    
    
    public void displayBrand(){
        System.out.println("These shoes are brand" +  brand);
    }
    
}
