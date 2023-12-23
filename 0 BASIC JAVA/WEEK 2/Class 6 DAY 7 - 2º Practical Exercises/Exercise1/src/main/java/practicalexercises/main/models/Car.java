package practicalexercises.main.models;

public class Car extends Vehicle implements Electric{
    private int batteryCapacity;
    private double autonomy;

    public Car(int batteryCapacity, double autonomy, int id, String licensePlate, String brand, String model, int year, double price) {
        super(id, licensePlate, brand, model, year, price);
        this.batteryCapacity = batteryCapacity;
        this.autonomy = autonomy;
    }

    @Override
    public int calculateAge() {
        int yearNow = 2023;
        return yearNow - year;
    }

    @Override
    public void displayElectric() {
        System.out.println("Charging electric car with " + batteryCapacity + "Autonomy: " + autonomy + "hours" );
    }
  
    
}
