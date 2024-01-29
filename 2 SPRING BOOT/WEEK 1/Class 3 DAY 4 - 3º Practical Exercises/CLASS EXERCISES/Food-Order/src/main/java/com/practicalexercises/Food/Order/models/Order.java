package com.practicalexercises.Food.Order.models;

import java.util.List;
import java.util.Random;

public class Order {
    Random r = new Random();
  private int id = r.nextInt(10000);
  private boolean status;
  private String customer;
  private List<Dish> dishes;

    public Order(boolean status, String customer, List<Dish> dishes) {
        this.status = status;
        this.customer = customer;
        this.dishes = dishes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", status=" + status + ", customer='" + customer + '\'' + ", dishes=" + dishes + '}';
    }
}
