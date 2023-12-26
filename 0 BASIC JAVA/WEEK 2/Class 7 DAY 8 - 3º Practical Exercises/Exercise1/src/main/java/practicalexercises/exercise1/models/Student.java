package practicalexercises.exercise1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private int age;
    private double grade;

    public Student() {
    }

    public Student(int id, String name, int age, double grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", age=" + age + ", grade=" + grade + '}';
    }
     
    
}


//Create an application to manage a list of students in a database. Students will have attributes such as id, name, age and grade.
//
//The system must be able to allow adding new students, retrieving everyone's list and displaying their information.
//
//Create a database using MySQL called university and a table called students whose columns match the attributes of the student class.
//
//Use JDBC (Java Database Connectivity) to interact with the database.
