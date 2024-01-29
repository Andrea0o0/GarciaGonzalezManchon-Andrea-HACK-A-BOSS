package com.practicalexercises.Exercise2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseController {

    Map<Character, String> valuesConversion = new HashMap<Character, String>() {{
        put('A', "· -");
        put('B', "- · · ·");
        put('C', "- · - ·");
        put('D', "- · ·");
        put('E', "·");
        put('F', "· · - ·");
        put('G', "- - ·");
        put('H', "· · · ·");
        put('I', "· ·");
        put('J', "· - - -");
        put('K', "- · -");
        put('L', "· - · ·");
        put('M', "- -");
        put('N', "- ·");
        put('O', "- - -");
        put('P', "· - - ·");
        put('Q', "- - · -");
        put('R', "· - ·");
        put('S', "· · ·");
        put('T', "-");
        put('U', "· · -");
        put('V', "· · · -");
        put('W', "· - -");
        put('X', "- · · -");
        put('Y', "- · - -");
        put('Z', "- - · ·");
        put('0', "- - - - -");
        put('1', "· - - - -");
        put('2', "· · - - -");
        put('3', "· · · - -");
        put('4', "· · · · -");
        put('5', "· · · · ·");
        put('6', "- · · · ·");
        put('7', "- - · · ·");
        put('8', "- - - · ·");
        put('9', "- - - - ·");
    }};


    public String eachOne(char charr) {
        String morseValue = "";
        for (Map.Entry<Character, String> entry : valuesConversion.entrySet()) {
            if (entry.getKey() == charr) {
                morseValue = entry.getValue() + " &nbsp; ";
                break;
            }
        }
        if(charr == ' '){
            return " &nbsp; &nbsp; &nbsp; ";
        }
        return morseValue;
    }

    @GetMapping("/{phrase}")
    public String converter(@PathVariable String phrase){
        String response = "";
        phrase = phrase.toUpperCase();
        for (int i=0; i<phrase.length(); i++){
            response += eachOne(phrase.charAt(i));
        }
        return response;
    }

}
