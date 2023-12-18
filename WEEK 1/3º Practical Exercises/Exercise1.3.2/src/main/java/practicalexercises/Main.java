package practicalexercises;

import practicalexercises.models.Person;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Person[] peopleArray = new Person[5];
        String[] name = new String[]{"Andrea Gama","Tomás García","Montse Manchón","Alex Vilar","Valeria Ustratova"};
        String[] address = new String[]{"Calle Aragon 115","Paseo de Gracia 15","Via laitena 200","Calle Marina 52","Calle Diagonal 300"};
        Random random = new Random();
        for (int i=0; i < 5;i++){
            peopleArray[i] = new Person((i+1), name[i], random.nextInt(95), address[i], String.valueOf(random.nextInt(999999999)));
            System.out.println("Name: " + peopleArray[i].getName() + ", Age: " + peopleArray[i].getAge());
        }

        System.out.println("\nChanging names of two people:");
        for (int i = 0; i < 2; i++) {
            System.out.print("Old Name: " + peopleArray[i].getName());
            peopleArray[i].setName("Fulanito " + (i + 1));
            System.out.print(" -- After change -> Name: " + peopleArray[i].getName() + "\n");
        }

        System.out.println("\nPeople over 30 years old:");
        for (Person person : peopleArray) {
            if (person.getAge() > 30) {
                System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
            }
        }
    }
}