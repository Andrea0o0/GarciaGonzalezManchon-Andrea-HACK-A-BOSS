package com.practicalexercises.exercise2;

import com.practicalexercises.exercise2.models.Product;
import com.practicalexercises.exercise2.models.Worker;
import java.util.ArrayList;
import java.util.List;


public class Exercise2 {

    public static void main(String[] args) {
        List<Product> products = createProducts();

        // Create workers for different stages
        Worker assemblyWorker = new Worker("Assembly Worker");
        Worker qualityCheckWorker = new Worker("Quality Check Worker");
        Worker packagingWorker = new Worker("Packaging Worker");

        // Simulate the production line sequentially
        for (Product product : products) {
            assemblyWorker.task(product);
            qualityCheckWorker.task(product);
            packagingWorker.task(product);
        }
    }

    private static List<Product> createProducts() {
        List<Product> products = new ArrayList<>();

        // Create products
        for (int i = 1; i <= 5; i++) {
            products.add(new Product("Product " + i));
        }

        return products;
    }
}
