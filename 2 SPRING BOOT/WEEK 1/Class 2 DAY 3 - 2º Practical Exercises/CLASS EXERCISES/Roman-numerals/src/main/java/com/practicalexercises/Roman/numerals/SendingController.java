package com.practicalexercises.Roman.numerals;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SendingController {

    List<ProductModel> products = new ArrayList<>();
    public void productController() {
        // Initialize productList with some products
        for (int i = 0; i<5; i++ ) {
            products.add(new ProductModel((i+1), "Product"+(i+1)));
        }
    }

    @GetMapping("/products/{id}")
    public String getProductById(@PathVariable int id) {
        productController();
        Optional<String> productName = products.stream()
                .filter(product -> product.getId() == id)
                .map(ProductModel::getProduct)
                .findFirst();

        return productName.orElse("ProductModel not found");
    }
}
