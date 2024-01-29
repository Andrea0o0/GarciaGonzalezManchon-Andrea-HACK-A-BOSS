package com.practicalexercises.Food.Order;

import com.practicalexercises.Food.Order.models.Dish;
import com.practicalexercises.Food.Order.models.Order;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodOrderController {
    private final List<Order> orders =  new ArrayList<>();

    @GetMapping("/order")
    public List<Order> getOrders() {
        return orders;
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable int id) {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/order")
    public void createOrder(@RequestBody Order order) {
        orders.add(order);
    }

    @PostMapping("/order/dishes/{id}")
    public Order editOrder(@RequestBody Dish dish, @PathVariable int id) {
        List<Dish> dishes = getOrder(id).getDishes();
        dishes.add(dish);
        getOrder(id).setDishes(dishes);
        return getOrder(id);
    }

    @DeleteMapping("/orderDelete/{id}")
    public String deleteOrder(@PathVariable int id) {
        System.out.println("in");
        String message = "Not found any Order with this index";
        for (int i=0;i<orders.size();i++){
            if(orders.get(i).getId() == id ){
                orders.remove(i);
                message = "deleted Order";
            }
        }
        return message;
    }

}
