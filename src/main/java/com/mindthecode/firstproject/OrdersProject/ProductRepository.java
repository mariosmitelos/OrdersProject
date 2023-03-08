package com.mindthecode.firstproject.OrdersProject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findByProductName(String productName, Pageable pageable);
    Page<Product> findByProductPrice(Double productPrice, Pageable pageable);
    Page<Product> findByProductPriceGreaterThanEqual(Double productPrice, Pageable pageable);
    Page<Product> findByProductPriceGreaterThan(Double productPrice, Pageable pageable);
    Page<Product> findByProductPriceLessThan(Double productPrice, Pageable pageable);
    Page<Product> findByProductProductNameContainingIgnoreCase(String productName, Pageable pageable);
}