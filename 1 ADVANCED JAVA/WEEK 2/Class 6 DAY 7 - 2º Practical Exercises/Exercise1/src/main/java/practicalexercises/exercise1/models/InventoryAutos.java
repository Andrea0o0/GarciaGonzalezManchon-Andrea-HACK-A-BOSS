package practicalexercises.exercise1.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class InventoryAutos <T extends Auto>{
    private List<T> inventory;

    public InventoryAutos() {
        this.inventory = new ArrayList<>();
    }
    
    public void addCar(T car){
        this.inventory.add(car);
        System.out.println("Added succesfully");
    }
    
    public List<T> searchByModel (String model) {
        List<T> byModel = this.inventory.stream().
                filter(auto -> auto.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
        if(byModel.isEmpty()){
            System.out.println("There's no result for model " + model);
            return null;
        } else {
            return byModel;
        }
    }
    
    public List<T> searchByYear (int year) {
        List<T> byModel = this.inventory.stream().
                filter(auto -> auto.getYear() == year)
                .collect(Collectors.toList());
        if(byModel.isEmpty()){
            System.out.println("There's no result for year " + year);
            return null;
        } else {
            return byModel;
        }
    }
    
    public double totalAutos (){
        double totalValue = 0;
        for (T auto : inventory) {
            totalValue += auto.getPrice();
        }
        return totalValue;
        
    }
    
    
}
