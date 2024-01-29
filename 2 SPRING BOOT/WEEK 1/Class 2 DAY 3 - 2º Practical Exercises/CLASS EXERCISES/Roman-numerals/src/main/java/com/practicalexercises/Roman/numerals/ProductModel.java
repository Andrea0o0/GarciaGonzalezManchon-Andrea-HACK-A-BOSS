package com.practicalexercises.Roman.numerals;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class ProductModel {
    private int id;
    private String product;
    public ProductModel(int id, String product) {
        this.id = id;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductModel{" + "id=" + id + ", product='" + product + '\'' + '}';
    }
}
