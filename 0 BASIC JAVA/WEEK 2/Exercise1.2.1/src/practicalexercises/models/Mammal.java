package practicalexercises.models;


public class Mammal extends Animal {
     int numberLegs;
     String reproduction;
     String coatColor;
     String habitat;
    

    public Mammal(String name, int age, String skinType, String feeding, 
            // Mammal attributes:
            int numberLegs, String reproduction, String coatColor,String habitat) {
        super(name, age, skinType, feeding);
         this.numberLegs = numberLegs;
         this.reproduction = reproduction;
         this.coatColor = coatColor;
         this.habitat = habitat;
    }
    
    public void greet() {
        
        System.out.println("Hello, I'm an mammal");
    }

    @Override
    public String toString() {
        return super.toString() + "Mammal{" + "numberLegs=" + numberLegs + ", reproduction=" + reproduction + ", coatColor=" + coatColor + ", habitat=" + habitat + '}';
    }
    
    
    
    
    
}
