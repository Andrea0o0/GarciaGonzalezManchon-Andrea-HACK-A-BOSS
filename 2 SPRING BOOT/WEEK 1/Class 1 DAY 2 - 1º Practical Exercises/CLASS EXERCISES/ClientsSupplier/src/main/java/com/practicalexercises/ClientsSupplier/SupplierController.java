package com.practicalexercises.ClientsSupplier;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SupplierController {

    @GetMapping("/suppliers")
    public List<SupplierModel> getAll(){
        List<SupplierModel> suppliers = new ArrayList<>();
        for (int i=0; i<10;i++){
            SupplierModel client = new SupplierModel(i,"nameSupplier"+i);
            suppliers.add(client);
        }
        return suppliers;
    }
}
