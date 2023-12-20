package practicalexercises.models;

public class Reptile extends Animal {
    
    double length;
    String scales;
    String poison;
    String habitat;

    public Reptile( String name, int age, String skinType, String feeding,
            // Reptile attributes:
            double length, String scales, String poison, String habitat) {
        super(name, age, skinType, feeding);
        this.length = length;
        this.scales = scales;
        this.poison = poison;
        this.habitat = habitat;
    }
    
     public void greet() {
        
        System.out.println("Hello, I'm a reptile");
    }

    @Override
    public String toString() {
        return super.toString() + "Reptile{" + "length=" + length + ", scales=" + scales + ", poison=" + poison + ", habitat=" + habitat + '}';
    }
     
    
    
}
