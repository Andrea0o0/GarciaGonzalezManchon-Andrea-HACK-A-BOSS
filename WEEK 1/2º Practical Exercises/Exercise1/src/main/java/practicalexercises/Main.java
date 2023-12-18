package practicalexercises;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int age;

        System.out.println("Enter your age to check if you can enter the recital: ");
        age = sc.nextInt();

        if(age <= 0 || age > 120) {
            System.out.println("Enter a valid age, please: ");
            age = sc.nextInt();
        }

        String validation = age >= 18 ?
                "You can enter the recital because your age is " + age + " years old, and you are of legal age":
                "Sorry, you cannot enter the recital, you are a minor at "+ age + (age == 1 ? " year old.":" years old.");

        System.out.println(validation);

    }
}