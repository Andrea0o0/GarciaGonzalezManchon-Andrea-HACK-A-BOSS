package com.practicalexercises.exercise2.models;


public class Worker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public void task(Product product) {
        System.out.println(name + " is working on" + product.getName());
        
        try {
            Thread.sleep(200);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        
        System.out.println(name + " completed work on" + product.getName());
    }
    
    
}
