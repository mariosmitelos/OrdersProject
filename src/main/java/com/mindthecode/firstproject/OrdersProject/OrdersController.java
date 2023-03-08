package com.mindthecode.firstproject.OrdersProject;


import org.springframework.web.bind.annotation.*;

@RestController
public class OrdersController {

    private final OrderRepository orderRepository;

    public OrdersController(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;

    }

    @PostMapping("/orders/orderId")

    public Order saveNewOrder(@RequestBody Order order) {

        return orderRepository.save(order);

    }

    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable Integer id) {
        Order match = orderRepository.findById(id)
                .orElseThrow();
        orderRepository.delete(match);
    }



}
