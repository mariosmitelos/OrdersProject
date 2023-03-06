package com.mindthecode.firstproject.OrdersProject;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

    private final OrderRepository repo;

    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable Integer id) {
        Order match = repo.findById(id)
                .orElseThrow();
        repo.delete(match);
    }



}
