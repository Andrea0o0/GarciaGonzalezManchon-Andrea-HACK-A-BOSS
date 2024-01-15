package com.practicalexercises.exercise1.models;


public class Call {
    private String clientName;
    private String infoQuery;

    public Call(String clientName, String infoQuery) {
        this.clientName = clientName;
        this.infoQuery = infoQuery;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getInfoQuery() {
        return infoQuery;
    }

    public void setInfoQuery(String infoQuery) {
        this.infoQuery = infoQuery;
    }

    @Override
    public String toString() {
        return "Call{" + "clientName=" + clientName + ", infoQuery=" + infoQuery + '}';
    }
    
}
