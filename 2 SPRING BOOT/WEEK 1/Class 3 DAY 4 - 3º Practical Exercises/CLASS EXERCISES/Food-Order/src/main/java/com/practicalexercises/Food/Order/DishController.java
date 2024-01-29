package com.practicalexercises.Food.Order;

import com.practicalexercises.Food.Order.models.Dish;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DishController {

    List<Dish> dishes;

    @GetMapping("/dishes")
    public List<Dish> getCustomers (){
        return dishes;
    }

    @PostMapping("/dish")
    public String createCustomer(@RequestBody Dish dish) {
        dishes.add(dish);
        return "Dish created";
    }

    @GetMapping("/dish/{id}")
    public Dish getCustomer(@PathVariable int id) {
        return dishes.stream().filter(
                dish -> dish.getId() == id).findFirst().orElse(null);
    }

}
