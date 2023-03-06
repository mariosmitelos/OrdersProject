package com.mindthecode.firstproject.OrdersProject;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    private final ProductRepository repo;

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id) {
       Product match = repo.findById(id)
                .orElseThrow();
        repo.delete(match);
    }
}
