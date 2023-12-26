package practicalexercises.exercise2.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import practicalexercises.exercise2.models.Food;
import practicalexercises.exercise2.persistence.exceptions.NonexistentEntityException;


public class ControllerPersistence {
    FoodJpaController foodJPA = new FoodJpaController();
    
    public void createFoodMenu (Food food){
        foodJPA.create(food);
    }
    
    public void modifyFood (Food food) {
  
      try {
          foodJPA.edit(food);
      } catch (Exception ex) {
          Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    public void deleteFood(int id) {
      try {
          foodJPA.destroy(id);
      } catch (NonexistentEntityException ex) {
          Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
    
     public List<Food> allFood (){
       List<Food> allfood = foodJPA.findFoodEntities();
       int i = 0;
        for (Food food: allfood){
            System.out.println("food dish nº " + (i+1) + ": " + food); 
            i++;
        }
        return allfood;
    }
     
    public void deleteallFood(){
        try {
            List<Food> allfood = foodJPA.findFoodEntities();
            List<Integer> indexes = new ArrayList<>();
            for (Food food : allfood) {
                indexes.add(food.getId());
            };
            for (Integer id : indexes) {
                foodJPA.destroy(id);
            }    
        } catch (NonexistentEntityException ex) {
          Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
      }
       
    }
}
