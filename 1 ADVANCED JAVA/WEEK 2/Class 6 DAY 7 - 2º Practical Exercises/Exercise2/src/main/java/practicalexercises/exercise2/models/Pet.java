package practicalexercises.exercise2.models;


public class Pet {
    private String name;
    private int age;
    private String species;
    private int id;

    public Pet(String name, int age, String species, int id) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pet{" + "name=" + name + ", age=" + age + ", species=" + species + ", id=" + id + '}';
    }
    
    
}
