package com.practicalexercises.ClientsSupplier;

import lombok.Getter;

@Getter
public class ClientModel {
    private int id;
    private String nameClient;

    public ClientModel(int id, String nameClient)
    {
        this.id = id;
        this.nameClient = nameClient;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameClient(String nameClient)
    {
        this.nameClient = nameClient;
    }

    @Override
    public String toString() {
        return "ClientModel{" + "id=" + id + ", nameClient='" + nameClient +
               '\'' + '}';
    }
}
