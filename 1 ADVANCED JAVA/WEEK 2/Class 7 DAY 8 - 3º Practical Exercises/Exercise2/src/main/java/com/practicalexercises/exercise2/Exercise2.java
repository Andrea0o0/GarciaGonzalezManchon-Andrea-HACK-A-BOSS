package com.practicalexercises.exercise2;

import com.practicalexercises.exercise2.models.Task;


public class Exercise2 {

    public static void main(String[] args) {
        Task project = new Task("Software Development");

        Task task1 = new Task("Application Design");
        task1.addSubtaskk(new Task("Create Prototype"));
        Task designInterface = new Task("Design Interface");
        designInterface.addSubtaskk(new Task("Define Color Scheme"));
        designInterface.addSubtaskk(new Task("Design Responsive Design"));
        task1.addSubtaskk(designInterface);
        task1.addSubtaskk(new Task("Document Requirements"));

        Task task2 = new Task("Code Implementation");
        task2.addSubtaskk(new Task("Develop Backend"));
        Task developFrontend = new Task("Develop Frontend");
        developFrontend.addSubtaskk(new Task("Code User Interface"));
        developFrontend.addSubtaskk(new Task("Integrate with Backend"));
        task2.addSubtaskk(developFrontend);

        Task task3 = new Task("Testing and Debugging");
        task3.addSubtaskk(new Task("Run Integration Tests"));
        task3.addSubtaskk(new Task("Fix Errors"));

        project.addSubtaskk(task1);
        project.addSubtaskk(task2);
        project.addSubtaskk(task3);

        // Display the task hierarchy
        project.displayTask(0);
    }
}
