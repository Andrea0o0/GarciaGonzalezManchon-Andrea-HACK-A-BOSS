package com.practicalexercises.Food.Order.models;

public class Customer {

    private int id;
    private String name;
    private String surname;
    private String location;

    public Customer(int id, String name, String surname, String location) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name='" + name + '\'' + ", surname='" + surname + '\'' + ", location='" + location + '\'' + '}';
    }
}
