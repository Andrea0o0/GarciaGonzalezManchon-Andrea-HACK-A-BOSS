package com.practicalexercises.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class Exercise1Controller {

    @GetMapping
    public String greet(){
        String nameGreet = "Andrea";
        return "Hello world, welcome " + nameGreet + "!!";
    }

    Random random = new Random();
    @GetMapping("/randomNumb")
    public String drawnNumber(){
//        int numberRandom = ThreadLocalRandom.current().nextInt(1, 100);
        return "The drawn number is " + (random.nextInt(100)+1) + "!!";
    }

    @GetMapping("/randomNumbers")
    public List<String> drawnNumbers(){
        List<String> listRandom = new ArrayList<>();
        for (int i=0; i<10;i++){
            int numberR = random.nextInt(100)+1;
            listRandom.add("The drawn number is " + numberR + "!!");
        }
        return listRandom;
    }
}
