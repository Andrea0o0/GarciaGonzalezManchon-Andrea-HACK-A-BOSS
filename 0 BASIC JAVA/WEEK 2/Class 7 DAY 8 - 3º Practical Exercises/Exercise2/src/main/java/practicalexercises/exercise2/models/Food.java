package practicalexercises.exercise2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Food implements Serializable{
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String recipe;
    private double price;

    public Food() {
    }
    
    public Food(int id, String name, String recipe, double price) {
        this.id = id;
        this.name = name;
        this.recipe = recipe;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + id + ", name=" + name + ", recipe=" + recipe + ", price=" + price + '}';
    }
    
       
}


