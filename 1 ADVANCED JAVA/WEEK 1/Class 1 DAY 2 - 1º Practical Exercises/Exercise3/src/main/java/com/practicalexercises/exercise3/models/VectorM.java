package com.practicalexercises.exercise3.models;

import com.practicalexercises.exercise3.exceptions.InvalidVectorException;
import java.util.ArrayList;
import java.util.List;


public class VectorM<T> {
    private List<T> dataList = new ArrayList<>();

    public VectorM() {
    }

    public VectorM(List<T> dataList) {
        this.dataList = dataList;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void addDataList(T dataList) {
        this.dataList.add(dataList);
        System.out.println(dataList + " added to the dataList");
    }
    
    public T getOneData(int index) throws InvalidVectorException {
        if(index < 0 || index > this.dataList.size() || this.dataList.isEmpty()){
            throw new InvalidVectorException("Index " + index + "doesn't exist");
        } else {
            return this.dataList.get(index);
        }
        
    }

    @Override
    public String toString() {
        return "VectorM{" + "dataList=" + dataList + '}';
    }
    
}
