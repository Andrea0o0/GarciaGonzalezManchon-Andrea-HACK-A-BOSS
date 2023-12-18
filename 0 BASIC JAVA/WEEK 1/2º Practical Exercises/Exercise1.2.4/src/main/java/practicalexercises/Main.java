package practicalexercises;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] seatMatrix = {
                //    0   1   2   3   4
                {"O", "O", "O", "O", "O"},
                {"O", "O", "O", "O", "O"},
                {"O", "O", "O", "O", "O"},
                {"O", "O", "O", "O", "O"},
                {"O", "O", "O", "O", "O"},
        };

        boolean decisionFlag;
        do {
            int row;
            int column;
            System.out.println("Choose the row you want for your seat: ");
            row = sc.nextInt();
            System.out.println("Now choose the seat you want in row " + row + ":");
            column = sc.nextInt();
            if (seatMatrix[row - 1][column - 1].equals("X")) {
                System.out.println("Please choose a new place because this one is already chosen");
                decisionFlag = true;
            } else {
                seatMatrix[row - 1][column - 1] = "X";
                System.out.println("Do you want to continue choosing places? YES or NO:");
                String continueDecision = sc.next();
                decisionFlag = continueDecision.equalsIgnoreCase("YES");
            }
        } while (decisionFlag);
        for (int i = 0; i < seatMatrix.length; i++) {
            for (int j = 0; j < seatMatrix[i].length; j++) {
                System.out.print(seatMatrix[i][j] + " ");
            }
            System.out.println();
        }


    }
}