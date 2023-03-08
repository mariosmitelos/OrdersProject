package com.mindthecode.firstproject.OrdersProject;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductsController {

    private final ProductRepository repo1;

    public ProductsController(ProductRepository repo1) {

        this.repo1 = repo1;

    }

    @PostMapping("/products/productId")

    public Product saveNewProduct(@PathVariable Integer productId, @RequestBody Product product) {

        return (Product) repo1.save(product);

    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id) {
       Product match = (Product) repo1.findById(id)
                .orElseThrow();
        repo1.delete(match);
    }
}
