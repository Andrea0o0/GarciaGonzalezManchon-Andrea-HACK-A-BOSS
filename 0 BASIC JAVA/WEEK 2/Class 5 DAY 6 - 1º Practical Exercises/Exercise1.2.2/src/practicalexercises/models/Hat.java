package practicalexercises.models;

public class Hat extends Clothing{
    String hatType;

    public Hat(String hatType, String code, String name, double price, String brand, String size, String color) {
        super(code, name, price, brand, size, color);
        this.hatType = hatType;
    }

    public String getHatType() {
        return hatType;
    }

    public void setHatType(String hatType) {
        this.hatType = hatType;
    }

    @Override
    public String toString() {
        return "Hat{" + "hatType=" + hatType + super.toString();
    }
    
    public void displayBrand(){
        System.out.println("This hat is brand" +  hatType);
    }
      
    
}
