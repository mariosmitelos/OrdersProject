package com.mindthecode.firstproject.OrdersProject;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrdersRepository extends JpaRepository<Order, Integer> {
    Page<Order> findByQuantity(Integer quantity, Pageable pageable);
    Page<Order> findByDiscount(Float discount, Pageable pageable);
    Page<Order> findByDiscountGreaterThanEqual(Float discount, Pageable pageable);
    Page<Order> findByDiscountGreaterThan(Float discount, Pageable pageable);
    Page<Order> findByDiscountLessThan(Float discount, Pageable pageable);
    Page<Order> findById(Integer id, Pageable pageable);
    Page<Order> findByQuantityGreaterThanEqual(Float quantity, Pageable pageable);
    Page<Order> findByQuantityGreaterThan(Float quantity, Pageable pageable);
    Page<Order> findByQuantityLessThan(Float quantity, Pageable pageable);
}
