package com.practicalexercises.PostAndRequestPostman;

import com.practicalexercises.PostAndRequestPostman.models.Dish;
import com.practicalexercises.PostAndRequestPostman.models.Menu;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodOrderController {

    private final List<Menu> menus = new ArrayList<>();

    @GetMapping("/menu")
    public List<Menu> getMenus() {
        return menus;
    }

    @GetMapping("/menu/{id}")
    public Menu getMenu(@PathVariable int id) {
        return menus.stream()
                .filter(menu -> menu.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/menu")
    public void createMenu(@RequestBody List<Dish> dishes) {
        Menu createMenu = new Menu(dishes);
        menus.add(createMenu);
    }

    @PostMapping("/menu/{id}")
    public Menu editMenu(@RequestBody Dish dish, @PathVariable int id) {
        List<Dish> dishes = getMenu(id).getDishes();
        dishes.add(dish);
        getMenu(id).setDishes(dishes);
        return getMenu(id);
    }

    @DeleteMapping("/menuDelete/{id}")
    public String deleteMenu(@PathVariable int id) {
        System.out.println("in");
        String message = "Not found any Menu with this index";
        for (int i=0;i<menus.size();i++){
            if(menus.get(i).getId() == id ){
                menus.remove(i);
                message = "deleted Menu";
            }
        }
        return message;
    }

}