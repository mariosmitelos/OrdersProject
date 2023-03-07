package com.mindthecode.firstproject.OrdersProject;


import org.springframework.web.bind.annotation.*;

@RestController
public class OrdersController {

    private final OrderRepository repo;

    public OrdersController(OrderRepository repo) {

        this.repo = repo;

    }

    @PostMapping("/orders/orderId")

    public Order saveNewOrder(@PathVariable Integer orderId, @RequestBody Order order) {

        return (Order) repo.save(order);

    }

    public Order putNewProductToOrder(Integer orderId, Product product) {}


    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable Integer id) {
        Order match = (Order) repo.findById(id)
                .orElseThrow();
        repo.delete(match);
    }



}
