package practicalexercises.main.models;


public class Motorcycle extends Vehicle implements Combustion {
    private int displacement;
    private String engineType;

    public Motorcycle(int displacement, String engineType, int id, String licensePlate, String brand, String model, int year, double price) {
        super(id, licensePlate, brand, model, year, price);
        this.displacement = displacement;
        this.engineType = engineType;
    }

    @Override
    public int calculateAge() {
        return 2023 - year;
    }
        

    @Override
    public void displayCombustion() {
        System.err.println("Refueling combustion motorcycle with displacement: " + displacement + " cc. Engine type: " + engineType);
    }
    
    
    
}
