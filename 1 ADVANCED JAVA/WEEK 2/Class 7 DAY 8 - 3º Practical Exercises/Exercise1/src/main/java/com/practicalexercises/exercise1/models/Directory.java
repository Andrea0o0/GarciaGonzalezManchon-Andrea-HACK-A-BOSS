package com.practicalexercises.exercise1.models;

import java.util.ArrayList;
import java.util.List;


public class Directory {
    public String name;
    public List<Directory> subdirectories;
    public List<String> files;

    public Directory(String name) {
        this.name = name;
        this.subdirectories = new ArrayList<>();
        this.files = new ArrayList<>();
    }
    
    public void addSubdirectory (Directory subdirectory){
        subdirectories.add(subdirectory);
    }
    
    public void addFile (String file) {
        files.add(file);
    }
}
