package com.mindthecode.firstproject.OrdersProject;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class OrdersController {

    private final OrderRepository orderRepository;

    public OrdersController(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;

    }

    @PostMapping("/orders/orderId")

    public Order newOrder(@RequestBody Order order) {


        return orderRepository.save(order);

    }

    @GetMapping("/orders/{id}")
    public Order one(@PathVariable Integer id) {
        return orderRepository.findById(id)
                .orElseThrow();
    }

    @GetMapping("/orders")
    public Page<Order> all(
            @RequestParam(required = false) Integer orderId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "ASC", required = false) String sort
    ) {

        PageRequest paging = PageRequest
                .of(page, size)
                .withSort(sort.equalsIgnoreCase("ASC") ?
                        Sort.by("lastName").ascending() :
                        Sort.by("lastName").descending());

        Page<Order> res;
        if (orderId == null) {
            res = orderRepository.findAll(paging);
        } else {
            res = orderRepository.findByOrderIdContainingIgnoreCase(orderId, paging);
        }

        return res;
    }

    @PutMapping("/orders/{id}")
    public Order update(@PathVariable Integer id, @RequestBody Order order) {
        if (!id.equals(order.getOrderId())) {
            throw new HttpClientErrorException(HttpStatusCode.valueOf(400), "id in path does not patch id in body");
        }
        return orderRepository.save(order);
    }

    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable Integer id) {

        Order match = orderRepository.findById(id)
                .orElseThrow();
        orderRepository.delete(match);

    }

}
