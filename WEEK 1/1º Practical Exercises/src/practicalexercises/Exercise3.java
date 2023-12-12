package practicalexercises;

import java.util.Scanner;
public class Exercise3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double base;
        double height;

        System.out.println("This software calculates the area of a triangle" + "\n" + "Please enter the value of the base: ");
        base = sc.nextInt();

        System.out.println("Please enter the height value: ");
        height = sc.nextInt();

        double area = (base * height)/2;

        System.out.println(area);

    }

}
