package practicalexercises;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double[] temperatureArray = new Double[7];
        String[] daysName = new String[]{"first","second","third","fourth","fifth","sixth","seventh"};
        double total = 0;
        for(int i = 0; i < temperatureArray.length; i++){
            System.out.println("Enter the maximum temperature of the " + daysName[i] + " day: ");
            temperatureArray[i] = sc.nextDouble();
            total += temperatureArray[i];
        }

        System.out.print("The average maximum temperature between these temperatures ");
        int i = 0;
        while (i < temperatureArray.length) {
            System.out.print(temperatureArray[i] + ((temperatureArray.length - 1 != i) ? ", ":" "));
            i++;
        }
        System.out.print("is " + total/temperatureArray.length);

    }
}