package practicalexercises.exercise2.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PetRegistration <T extends Pet> {
    private List<T> petRegistry;
    
    public PetRegistration() {
        this.petRegistry = new ArrayList<>();
    }
    
    public void addPets(List<T> pets) {
        for (T pet : pets) {
            this.petRegistry.add(pet);
        }
        System.out.println("Pets added");
    }
    
    public void addPet(T pet) {
        this.petRegistry.add(pet);
        System.out.println("Pet added");
    }
    
    public List<T> searchByName(String namePet){
        List<T> byName = this.petRegistry.stream().
                filter(pet -> pet.getName().equalsIgnoreCase(namePet))
                .collect(Collectors.toList());
        if(byName.isEmpty()){
            System.out.println("There's no result by " + namePet + " name");
            return null;
        } else {
            return byName;
        }
    }
    
    public List<T> searchBySpecie(String specie){
        List<T> bySpecie = this.petRegistry.stream().
                filter(pet -> pet.getSpecies().equalsIgnoreCase(specie))
                .collect(Collectors.toList());
        if(bySpecie.isEmpty()){
            System.out.println("There's no result by " + specie);
            return null;
        } else {
            return bySpecie;
        }
    }
    
    public int totalPets (){
        return this.petRegistry.size();
    }
}
