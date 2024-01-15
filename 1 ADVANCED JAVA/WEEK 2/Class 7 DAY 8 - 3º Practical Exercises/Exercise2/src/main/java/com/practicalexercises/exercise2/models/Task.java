package com.practicalexercises.exercise2.models;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;


public class Task {
    public String name;
    public List<Task> subtasks;
    String[] levels = {"Project","Main Task","Subtask","Sub-subtask"};

    public Task( String name) {
        this.name = name;
        this.subtasks = new ArrayList<>();
    }
    
    public void addSubtaskk(Task subtask) {
        subtasks.add(subtask);
    }
    
    public void displayTask (int level) {
        // to make mutable the indentation declaration (indentation is the additional margin)
        StringBuilder indentation = new StringBuilder();
        
        
        for(int i= 0; i<level;i++){
            indentation.append("|-- ");
        }
        
        System.out.println(indentation + levels[level] + ": " + name);
        
        for (Task subtask : subtasks) {
            subtask.displayTask( level + 1);
        }
    }
    
}
