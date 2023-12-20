package practicalexercises;

import practicalexercises.models.Bird;
import practicalexercises.models.Mammal;
import practicalexercises.models.Reptile;



public class Main {

    public static void main(String[] args) {
        Mammal dogueBordeaux = new Mammal(
                "Bach",
                5,
                "Thick and sufficiently broad for being a molossus, and the hair is fine, short and soft to the touch",
                "Quality feed, rich in proteins and minerals, 750 to 950 grams daily divided into 3 doses",
                4,
                "Sexual: the dog remains reproductively active throughout its life, females come into heat twice a year",
                "Range of browns tending to a mahogany color, with generally a significant white spot on the chest",
                "Originally from Bordeauz, France, now in people's homes");
        Bird hummingbird = new Bird(
                "Rainbow",
                2,
                "Plumage with delicate epidermis",
                "Seeds, berries,fruits,insects,larve,fish...",
                21,
                "Capable of flying in a straight line, in reverse, up, down and even inverted", 
                "Generally green in color but their feathers are iridescent, which means that light bounces off them like a soap bubble, resulting in thousands of bright shades that change when viewed from different angles, which is why they appear to be multicolored",
                "Is awl-shaped, thin, sharp, it could be also straight or arched");
        Reptile rattlesnake = new Reptile(
                "Manolo Bell", 
                2, 
                "Skin covered in scales", 
                "Carnivores, includes birds, lizards and small mammals", 
                2.5, 
                "Dorsal, ventral, caudal lateral, supralabial, infralabial, and rostral scales", 
                "One of the most venomous sbakes in the world, due its hemotoxic effects and variable compositions", 
                "Deserts, grassland, and forests, in North and South American environments");
        
        System.out.println(dogueBordeaux.toString());
        System.out.println(hummingbird.toString());
        System.out.println(rattlesnake.toString());
        
    }
    
}
