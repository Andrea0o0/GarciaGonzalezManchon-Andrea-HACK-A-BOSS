package com.practicalexercises.Roman.numerals;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogicController {
    String romanN = "";

    public String logic(int numberInput) {
        if (numberInput == 1000) {
            romanN += "M";
        } else if (numberInput >= 500) {
            romanN += "D";
            logic(numberInput - 500);
        } else if (numberInput >= 100) {
            romanN += "C";
            logic(numberInput - 100);
        } else if (numberInput >= 50) {
            romanN += "L";
            logic(numberInput - 50);
        } else if (numberInput >= 10) {
            romanN += "X";
            logic(numberInput - 10);
        } else if (numberInput == 9 ) {
            romanN += "IX";
        } else if (numberInput == 8) {
            romanN += "VIII";
        } else if (numberInput == 7) {
            romanN += "VII";
        } else if (numberInput == 6) {
            romanN += "VI";
        } else if (numberInput == 5) {
            romanN += "V";
        } else if (numberInput == 4) {
            romanN += "IV";
        } else if (numberInput == 3) {
            romanN += "III";
        } else if (numberInput == 2) {
            romanN += "II";
        } else if (numberInput == 1) {
            System.out.println(numberInput);
            romanN += "I";
        }
        return romanN;
    }

    public String getRomanN(Double numberOrigin) {
        String data = numberOrigin.toString();
        int whole = Integer.parseInt(data.substring(0, data.indexOf(".")));
        int decimal = Integer.parseInt(data.substring(data.indexOf(".") + 1));

        if (whole <= 0 || whole > 1000) {
            return "Please enter a valid number between 1 and 1000";
        }

        if(decimal > 1000){
            return "Please enter a decimal number under 1000";
        }
        System.out.println(whole + " " + decimal);
        String wholeRoman = logic(whole);
        romanN = "";
        String decimalRoman = logic(decimal);
        romanN = "";
        return decimalRoman.isEmpty() ? wholeRoman:
                wholeRoman + "." + decimalRoman;

    }
    @GetMapping("/{number0}")
    public String validation(@PathVariable String number0) {
        try {
            double numericValue = Double.parseDouble(number0);
            return getRomanN(numericValue);
        } catch (NumberFormatException e) {
            return "Enter a valid number";
        }
    }
}