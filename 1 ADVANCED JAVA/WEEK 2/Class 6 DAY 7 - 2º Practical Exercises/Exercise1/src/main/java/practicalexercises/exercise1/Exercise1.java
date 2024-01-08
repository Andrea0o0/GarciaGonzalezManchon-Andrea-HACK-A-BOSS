package practicalexercises.exercise1;

import java.util.List;
import practicalexercises.exercise1.models.Auto;
import practicalexercises.exercise1.models.InventoryAutos;


public class Exercise1 {

    public static void main(String[] args) {
        Auto car1 = new Auto("BMW", "x5", 2018, 50000);
        Auto car2 = new Auto("Jeep", "Commander", 2008, 62000);
        Auto car3 = new Auto("Ford", "Mustang", 2023, 40000);
        
        InventoryAutos inventory = new InventoryAutos();
        
        inventory.addCar(car1);
        inventory.addCar(car2);
        inventory.addCar(car3);
        
        List<Auto> jeepCars = inventory.searchByModel("Jeep");
        System.out.println("Jeep Cars are: \n" + jeepCars);
        
        List<Auto> cars2000 = inventory.searchByYear(2000);
        System.out.println("Cars from 2000 are: \n" + cars2000);
        
        List<Auto> cars2008 = inventory.searchByYear(2008);
        System.out.println("Cars from 2008 are: \n" + cars2008);
        
        double totalPrice = inventory.totalAutos();
        System.out.println("The total price of the autos in the inventory are: "+ totalPrice);
        
    }
}
