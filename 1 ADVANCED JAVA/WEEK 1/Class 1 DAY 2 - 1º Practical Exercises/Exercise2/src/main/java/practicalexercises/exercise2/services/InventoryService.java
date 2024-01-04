package practicalexercises.exercise2.services;

import java.util.Scanner;
import practicalexercises.exercise2.exceptions.InvalidInvetoryException;
import practicalexercises.exercise2.models.Inventory;


public class InventoryService {
    Scanner sc = new Scanner(System.in);
    Inventory inventory = new Inventory();
    
    public String testingProduct(String args) throws InvalidInvetoryException{
        String regexPattern = "^[a-zA-Z\\s]*$";
        String input = sc.next();
        while (!input.matches(regexPattern)) {         
            throw new InvalidInvetoryException("Please enter a valid " + args + " MUST BE A WORD/s OR A STRING");  
        }
        return input;
    }
    
    public int testingStock(String args) throws InvalidInvetoryException {
        int input;
        do {            
            while (!sc.hasNextInt()) {
                throw new InvalidInvetoryException("Please enter a valid " + args + " MUST BE A INT/INTEGER");                
            }
            input = sc.nextInt();
            if (input < 0) {
                throw new InvalidInvetoryException("This number is negative is not valid for the " + args);
            }            
        } while (input < 0);
        return input;
        
    }
    
    public double testingPrice(String args) throws InvalidInvetoryException {
        double input;
        do {            
            while (!sc.hasNextDouble()) {
                throw new InvalidInvetoryException("Please enter a valid " + args + " MUST BE A DOUBLE");                
            }
            input = sc.nextDouble();
            if (input < 0) {
                throw new InvalidInvetoryException("This number is negative is not valid for the " + args);
            }            
        } while (input < 0);
        return input;
        
    }
    
    public Inventory createProduct(String userName) throws InvalidInvetoryException {
        
        System.out.println("Hi " + userName);
        
        System.out.println("Please enter a product to add to the inventory:");
        String product = testingProduct("product");
        
        System.out.println("Please enter a price for " + product);
        double price = testingPrice("price");
        
        System.out.println("Please enter the stock for " + product);
        int stock = testingStock("stock");
        
        return inventory;
    }
}
