package com.mindthecode.firstproject.OrdersProject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findByProductNameContainingIgnoreCase(String ProductName, Pageable pageable);

}
