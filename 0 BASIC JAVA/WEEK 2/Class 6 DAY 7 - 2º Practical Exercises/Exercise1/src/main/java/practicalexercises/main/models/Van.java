package practicalexercises.main.models;

public class Van extends Vehicle implements Combustion{
    private double tankCapacity;
    private double fuelConsumption;

    public Van(double tankCapacity, double fuelConsumption, int id, String licensePlate, String brand, String model, int year, double price) {
        super(id, licensePlate, brand, model, year, price);
        this.tankCapacity = tankCapacity;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public int calculateAge() {
        return 2023 - year;
    }

    @Override
    public void displayCombustion() {
        System.out.println("Refueling combustion truck with a " + tankCapacity + "liter capacity tank, and a fuel consumption of " + fuelConsumption + "liters/km" );
    }
    
    
}
