package practicalexercises.exercise2;

import java.util.ArrayList;
import java.util.Random;
import practicalexercises.exercise2.models.Product;


public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList <Product> products = new ArrayList<>();
        String[] names = {"Phone","Laptop","Headphones","Charger","Tablet","Camera","Monitor","Mouse","Keyboard","Speaker"};
        for(String name:names){
            int i = 1;
            Random random = new Random();
            products.add(new Product(i,name,"Brand"+i,"Type"+i,random.nextDouble(3000),random.nextDouble(500),random.nextInt(50)));
        }
        System.out.println("Products added to the inventory!");
        Product maxSalesPrice = products.get(0);
        Product minCostPrice = products.get(0);
        for(Product product : products ){
            maxSalesPrice = maxSalesPrice.getSalesPrice() < product.getSalesPrice() ? product: (Product) maxSalesPrice.clone();
            minCostPrice = minCostPrice.getCostPrice() > product.getCostPrice() ? product: (Product) minCostPrice.clone();
        }
        System.out.println("Product with the lowest cost price: " + minCostPrice.getName());
        System.out.println("Product with the highest selling price: " + maxSalesPrice.getName());
    
        products.remove(4);
        
        Product maxStock = products.get(0);
        for(Product product: products) {
            maxStock = maxStock.getStock() > product.getStock() ? maxStock: product;
        }
        
        System.out.println(products);
        maxStock.setStock(maxStock.getStock()-3);
        System.out.println(products);
//        for(Product product : products){
//            
//        }
    }
}
