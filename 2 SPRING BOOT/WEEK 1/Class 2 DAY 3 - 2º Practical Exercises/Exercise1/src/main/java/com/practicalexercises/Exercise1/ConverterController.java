package com.practicalexercises.Exercise1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    @GetMapping("/{cmNumber}")
    public String conversion(@PathVariable String cmNumber) {
        try {
            double cmValue = Double.parseDouble(cmNumber);
            return cmNumber + " centimeters are equivalent to " + (cmValue/100) + " meters";
        } catch (NumberFormatException e) {
            return "Enter a valid number";
        }
    }
}
