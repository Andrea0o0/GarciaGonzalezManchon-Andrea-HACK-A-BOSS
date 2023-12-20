package practicalexercises.models;

public class Bird extends Animal {
    
    int wingspan;
    String typeFlight;
    String plumageColor;
    String beak;
    

    public Bird(String name, int age, String skinType, String feeding,
            // Bird attributes:
            int wingspan, String typeFlight, String plumageColor, String beak) {
        super(name, age, skinType, feeding);
        this.wingspan = wingspan;
        this.typeFlight = typeFlight;
        this.plumageColor = plumageColor;
        this.beak = beak;
        
    }
    
     public void greet() {
        
        System.out.println("Hello, I'm a bird");
    }

    @Override
    public String toString() {
        return super.toString() + "Bird{" + "wingspan=" + wingspan + ", typeFlight=" + typeFlight + ", plumageColor=" + plumageColor + ", beak=" + beak + '}';
    }
     
    
    
    
    
    
    
}
