package com.practicalexercises.Food.Order;

import com.practicalexercises.Food.Order.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    List<Customer> customers;

    @GetMapping("/customers")
    public List<Customer> getCustomers (){
        return customers;
    }

    @PostMapping("/customer")
    public String createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return "Customer created";
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return customers.stream().filter(
                customer -> customer.getId() == id).findFirst().orElse(null);
    }


}
