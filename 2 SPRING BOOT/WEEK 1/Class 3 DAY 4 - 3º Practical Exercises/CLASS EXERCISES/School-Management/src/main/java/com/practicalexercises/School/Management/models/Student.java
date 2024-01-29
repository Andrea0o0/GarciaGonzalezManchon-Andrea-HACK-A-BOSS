package com.practicalexercises.School.Management.models;

public class Student {
    private int id;
    private String name;
    private String surname;
    private int registrationNumber;
    private double finalGrade;
    private String educationalLevel;
//    (Primary, Secondary and Tertiary)


    public Student(int id, String name, String surname, int registrationNumber, double finalGrade, String educationalLevel) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.registrationNumber = registrationNumber;
        this.finalGrade = finalGrade;
        this.educationalLevel = educationalLevel;
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

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }

    public String getEducationalLevel() {
        return educationalLevel;
    }

    public void setEducationalLevel(String educationalLevel) {
        this.educationalLevel = educationalLevel;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", surname='" + surname + '\'' + ", registrationNumber=" + registrationNumber + ", finalGrade=" + finalGrade + ", educationalLevel='" + educationalLevel + '\'' + '}';
    }
}
