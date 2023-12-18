package practicalexercises;

import java.util.ArrayList;
import java. util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();

        boolean flagContinue = true;
        int i = 1;
        double total = 0;

        do {
            System.out.println("Add the price of product nº " + i + ":");
            double product = sc.nextDouble();
            list.add(product);
            total += product;

            boolean flagDecision;
            System.out.println("Would you like to add the price of any more products? \nType 'YES' to add more or \"NO\" to see your list of items ");
            String decision = sc.next();
            flagDecision = decision.equalsIgnoreCase("yes") || decision.equalsIgnoreCase("no");
            if (!flagDecision) {
                do {
                    System.out.println("PLEASE PROVIDE A VALID RESPONSE, to add more prices type 'Yes' otherwise type 'No': ");
                    decision = sc.next();
                    flagDecision = decision.equalsIgnoreCase("yes") || decision.equalsIgnoreCase("no");
                } while (!flagDecision);
            }
            flagContinue = decision.equalsIgnoreCase("yes");

            i++;

        } while (flagContinue);

        System.out.println("Your list of items prices: \n"+list.toString().replaceAll(", ", "\n").replaceAll("\\[", "").replaceAll("]",""));
        System.out.println("---- \n" + total);
    }
}