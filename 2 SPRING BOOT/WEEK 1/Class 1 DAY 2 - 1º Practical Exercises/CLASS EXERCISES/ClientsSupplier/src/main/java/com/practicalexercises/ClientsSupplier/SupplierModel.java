package com.practicalexercises.ClientsSupplier;

import lombok.Getter;

@Getter
public class SupplierModel {
    private int id;
    private String nameSupplier;

    public SupplierModel(int id, String nameSupplier) {
        this.id = id;
        this.nameSupplier = nameSupplier;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    @Override
    public String toString() {
        return "SupplierModel{" +
                "id=" + id +
                ", nameSupplier='" + nameSupplier + '\'' +
                '}';
    }
}
