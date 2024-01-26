package com.practicalexercises.Exercise2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class FunFactsController {

    List<String> funFacts = new ArrayList<>(List.of(
            "The Barbie doll’s full name is Barbara Millicent Roberts, from " + "Willows, Wisconsin. Her birthday is March 9, 1959, when she was first displayed at the New York Toy Fair",
            "The oldest person ever to have lived (whose age could be " + "authenticated), a French woman named Jeanne Louise " + "Calment, was 122 years old when she died in 1997",
            "Sliced bread was first manufactured by machine and sold in the " + "1920s by the Chillicothe Baking Company in Missouri. It was the greatest thing since…unsliced bread",
            "The original name for the search engine Google was Backrub. It " + "was renamed Google after the googol, which is the number one followed by 100 zeros",
            "The oldest-known living land animal is a tortoise named " + "Jonathan, who turned 190 years old in 2022. He was born in 1832 and has lived on the island of St. Helena in the Atlantic Ocean since 1882",
            "Bats are the only mammal that can actually fly",
            "Wombats are the only animal whose poop is cube-shaped. This is " + "due to how its intestines form the feces. The animals then stack the cubes to mark their territory",
            "The most common wild bird in the world isn’t the sparrow or blue" + " jay—it’s the red-billed quelea, which live in Africa and have an estimated population of 1.5 billion",
            "The heart of the blue whale, the largest animal on earth, is " + "five feet " + "long and weighs 400 pounds. The whale in total weighs 40,000 pounds",
            "Elephants can’t jump",
            "For comparison, an elephant's heart weighs around 30 pounds. And" + " a human" + " heart? A mere 10 ounces",
            "Octopuses have three hearts",
            "Cows don’t actually have four stomachs; they have one stomach " + "with four compartments",

            "The platypus doesn't have a stomach at all: Their esophagus goes" + " straight to their intestines"
    ));

    @GetMapping("/funFacts")
    public String getFunFacts() {
        Random r = new Random();
        return funFacts.get(r.nextInt(funFacts.size()-1));
    }
}
