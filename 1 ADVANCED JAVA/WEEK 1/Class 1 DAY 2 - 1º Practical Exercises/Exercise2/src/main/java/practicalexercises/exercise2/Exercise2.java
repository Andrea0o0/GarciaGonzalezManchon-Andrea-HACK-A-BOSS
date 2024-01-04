package practicalexercises.exercise2;

import practicalexercises.exercise2.exceptions.InvalidInvetoryException;
import practicalexercises.exercise2.services.InventoryService;


public class Exercise2 {

    public static void main(String[] args) throws InvalidInvetoryException {
        InventoryService inventoryS = new InventoryService();
        
        System.out.println("Please enter your name:");
        String userName = inventoryS.testingProduct("name");
        inventoryS.createProduct(userName);
    }
}

