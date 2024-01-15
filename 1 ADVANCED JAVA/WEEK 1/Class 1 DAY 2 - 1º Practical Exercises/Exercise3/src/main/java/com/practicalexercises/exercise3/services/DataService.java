package com.practicalexercises.exercise3.services;

import com.practicalexercises.exercise3.exceptions.InvalidVectorException;
import com.practicalexercises.exercise3.models.VectorM;
import java.util.Scanner;


public class DataService {
    Scanner sc = new Scanner(System.in);
    VectorM vector = new VectorM();

    public void main() throws InvalidVectorException {
        System.err.println("What do you want to do?");
        System.out.println("1. Add data");
        System.out.println("2. See data");
        System.out.println("Enter valid option:");

        
        String option = sc.nextLine();
        if (!option.equals("1") && !option.equals("2")) {
            throw new InvalidVectorException(option + " is not a valid option");
        }
        if (option.equals("1")) {
            addData();
        } else if (option.equals("2")) {
            seeData();
        }
    }

    public void addData() throws InvalidVectorException {
        System.out.println("Please add data you want to add");
        String toAdd = sc.nextLine();
        vector.addDataList(toAdd);

        System.out.println("Do you want to make more actions?");
        String result = sc.nextLine();
        if (!result.equalsIgnoreCase("NO") && !result.equalsIgnoreCase("YES")) {
            throw new InvalidVectorException("There's no valid option" + result);
        }
        if (result.equalsIgnoreCase("YES")) {
            main();
        }
        sc.close();
    }

    public void seeData() throws InvalidVectorException {
        System.out.println("Enter the index of the data you want to review or enter All if you want to see all the info stored");
        String option = sc.nextLine();
        if (option.equalsIgnoreCase("all")) {
            System.out.println(vector.getDataList());
        } else {
            try {
                int num = Integer.parseInt(option);
                System.out.println(vector.getOneData(num));
            } catch (NumberFormatException e) {
                throw new InvalidVectorException("Invalid number for the index");
            }
        }
        sc.close();
    }
}
