package com.mindthecode.firstproject.OrdersProject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductPK> {
    Page<OrderProduct> findByQuantity(Integer quantity, Pageable pageable);
    Page<OrderProduct> findByQuantityGreaterThanEqual(Integer quantity, Pageable pageable);
    Page<OrderProduct> findByQuantityGreaterThan(Integer quantity, Pageable pageable);
    Page<OrderProduct> findByQuantityLessThan(Integer quantity, Pageable pageable);
}
