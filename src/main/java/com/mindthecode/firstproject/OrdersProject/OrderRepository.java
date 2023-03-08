package com.mindthecode.firstproject.OrdersProject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


interface OrderRepository extends JpaRepository<Order, Integer> {

    Page<Order> findByOrderIdContainingIgnoreCase(Integer OrderId, Pageable pageable);

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Page<Order> findByOrderId(Integer orderId, Pageable pageable);
    Page<OrderProduct> findByQuantityGreaterThanEqual(Integer quantity, Pageable pageable);
    Page<OrderProduct> findByQuantityGreaterThan(Integer quantity, Pageable pageable);
    Page<OrderProduct> findByQuantityLessThan(Integer quantity, Pageable pageable);
}
