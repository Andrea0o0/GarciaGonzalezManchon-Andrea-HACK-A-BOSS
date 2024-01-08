package practicalexercises.exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import practicalexercises.exercise2.models.Pet;
import practicalexercises.exercise2.models.PetRegistration;


public class Exercise2 {

    public static void main(String[] args) {
        Random random = new Random();
        
        List<Pet> pets = new ArrayList<>();
        String[] specieType = {"Dog", "Cat", "Reptile", "Bird","Hamster","Horse","Rabbit"};
        for (int i = 0; i < random.nextInt(100); i++) {
            pets.add(new Pet(
                    "Pet "+i, 
                    random.nextInt(22)+1, 
                    specieType[random.nextInt(specieType.length)], 
                    i));
        }
        
        for (Pet pet : pets) {
            System.out.println(pet);
        }
        
        PetRegistration petReg = new PetRegistration();
        
        petReg.addPets(pets);
        Pet petUnique = new Pet("Pet 1", 5, "Dog", pets.size());
        petReg.addPet(petUnique);
        
        // Search by name
        List<Pet> petByName = petReg.searchByName("Pet 1");
        System.out.println("Search by name: \n" + petByName);
        
        // Search by specie
        String specieSearch = "Rabbit";
        List<Pet> petBySpecie = petReg.searchByName(specieSearch);
        System.out.println("Search by " + specieSearch + ": \n" + petBySpecie);
        
        // Total
        int totalPets = petReg.totalPets();
        System.out.println("There's " + totalPets + " pets");
    }
}
