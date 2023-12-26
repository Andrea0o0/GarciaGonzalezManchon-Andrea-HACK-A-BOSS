package practicalexercises.exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import practicalexercises.exercise2.models.Food;
import practicalexercises.exercise2.persistence.ControllerPersistence;

public class Exercise2 {

    public static void main(String[] args) {
        ControllerPersistence controller = new ControllerPersistence();
        List<Food> foods = new ArrayList<Food>();
        foods.add(new Food (1, "Cheescake", "Philadelphia cream + sugar + butter cookies + love :) ", 5.8));
        foods.add(new Food (2, "RedVelvet", "cream Cheese + Butter + sugar + cocoa powder + red food coloring +​ love :) ", 6.2));
        foods.add(new Food (3, "Cold Lemon cake", "Lemons + Gelatin + Fresh liquid cream + Butter + natural plain yogurt + love ;)", 7.2));  
        
        // RESET
        controller.deleteallFood();

        for (Food food : foods) {
            controller.createFoodMenu(food);
        }
        
        int deleteRandom = (int) (Math.floor(Math.random()*3)+1);
        controller.deleteFood(deleteRandom);
        
        boolean testRandom;
        Random random = new Random();
        int editRandom;
        do {
            editRandom = random.nextInt(3)+1;
            testRandom = editRandom == deleteRandom;
        } while (testRandom);
        
        Food food2Edit = foods.get(editRandom-1);
        food2Edit.setName(food2Edit.getName()+" edited");
        food2Edit.setPrice(food2Edit.getPrice()+10);
        food2Edit.setRecipe(food2Edit.getRecipe().replace("love", "hate"));
        controller.modifyFood(food2Edit);
        controller.allFood();
        
        
    }
}
