package com.mindthecode.firstproject.OrdersProject;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Integer> {
    Page<Product> findByDescription(String description, Pageable pageable);
    Page<Product> findByPrice(Float price, Pageable pageable);
    Page<Product> findByPriceGreaterThanEqual(Float price, Pageable pageable);
    Page<Product> findByPriceGreaterThan(Float price, Pageable pageable);
    Page<Product> findByPriceLessThan(Float price, Pageable pageable);
    Page<Product> findByDescriptionContainingIgnoreCase(String description, Pageable pageable);
}
