package com.practicalexercises.PostAndRequestPostman.models;

import java.util.List;
import java.util.Random;

public class Menu {
    Random r = new Random();
    private int id = r.nextInt();
    private List<Dish> dishes;

    public Menu() {
    }

    public Menu(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", dishes=" + dishes + '}';
    }
}
