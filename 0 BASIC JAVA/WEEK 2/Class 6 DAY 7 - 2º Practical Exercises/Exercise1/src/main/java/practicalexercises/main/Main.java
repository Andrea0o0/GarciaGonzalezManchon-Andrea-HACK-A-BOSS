package practicalexercises.main;

import java.util.ArrayList;
import java.util.Random;
import practicalexercises.main.models.Car;
import practicalexercises.main.models.Combustion;
import practicalexercises.main.models.Electric;
import practicalexercises.main.models.Motorcycle;
import practicalexercises.main.models.Van;
import practicalexercises.main.models.Vehicle;


public class Main {

    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        int lengthVehicles = 3;
        for (int i=0; i < lengthVehicles ; i++){
            Random random = new Random();
            int i1 = i+lengthVehicles;
            int i2 = i+lengthVehicles+1;
            vehicles.add(new Car(random.nextInt(100), random.nextDouble(18), i, "licensePlate"+i, "brand"+i, "model"+i, random.nextInt(138) + 1886, random.nextDouble(19999901) + 100));
            vehicles.add(new Van(random.nextDouble(65), random.nextDouble(0.1), i1, "licensePlate"+i1, "brand"+i1, "model"+i1, random.nextInt(124) + 1900, random.nextDouble(19999901) + 100));
            vehicles.add(new Motorcycle(random.nextInt(351) + 250, "engineType"+i2, i2, "licensePlate"+i2, "brand"+i2, "model"+i2, random.nextInt(114) + 1910, random.nextDouble(1999901) + 100));
        }
        
        for (  Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getClass().getSimpleName() + " ID:" + vehicle.getId());
            System.out.println("License Plate: " + vehicle.getLicensePlate());
            System.out.println("Brand: " + vehicle.getBrand());
            System.out.println("Model: " + vehicle.getModel());
            System.out.println("Year" + vehicle.getYear());
            System.out.println("Price: " + vehicle.getPrice() + "€");
            System.out.println("Age: " + vehicle.calculateAge() + "years");
        
            if (vehicle instanceof Electric electric) {
                electric.displayElectric();
            } else if (vehicle instanceof Combustion combustion) {
                combustion.displayCombustion();
            }
            System.out.println();
        }
    }   
}
