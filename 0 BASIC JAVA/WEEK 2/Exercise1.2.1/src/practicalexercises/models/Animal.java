package practicalexercises.models;

import java.util.UUID;

public class Animal {
    private String name;
    private int age;
    private String skinType;
    private String feeding;
    private String id;
    
    public final String setId() {
        return UUID.randomUUID().toString();        
    }

    private Animal(String name, int age, String skinType, String feeding) {
        this.id = this.setId();
        this.name = name;
        this.age = age;
        this.skinType = skinType;
        this.feeding = feeding;
    }

    public String getId() {
        return id;
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
   

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    public String getTypeFeeding() {
        return feeding;
    }

    public void setTypeFeeding(String typeFeeding) {
        this.feeding = typeFeeding;
    }
    
    public void greet(){
        System.out.println("Hello, I'm an animal");
    }    

    public String toString() {
        return "Animal{" + "name=" + name + ", age=" + age + ", skinType=" + skinType + ", feeding=" + feeding + ", id=" + id + '}';
    }
    
    
    
}
