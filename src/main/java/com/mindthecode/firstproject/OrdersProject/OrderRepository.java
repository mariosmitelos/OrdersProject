package com.mindthecode.firstproject.OrdersProject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


interface OrderRepository extends JpaRepository<Order, Integer> {

    Page<Order> findByOrderId(Integer OrderId, Pageable pageable);

}
