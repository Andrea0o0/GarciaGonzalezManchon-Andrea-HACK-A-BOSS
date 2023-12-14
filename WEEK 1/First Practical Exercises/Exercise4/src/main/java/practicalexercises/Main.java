package practicalexercises;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double firstNum;
        double secondNum;
        String operator;

        System.out.println("Please enter first number: ");
        firstNum = sc.nextInt();

        System.out.println("Please enter second number: ");
        secondNum = sc.nextInt();

        System.out.println("Please enter in one character which operator do you want (+ - / *): ");
        operator = sc.next();

        double result = operator.equals("+") ? (firstNum + secondNum):
                operator.equals("-") ? (firstNum - secondNum):
                        operator.equals("*") ? (firstNum * secondNum): (firstNum / secondNum);

        System.out.println("The result is: " + result);
    }
}