package com.mindthecode.firstproject.OrdersProject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class ProductsController {

    private final ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository) {

        this.productRepository = productRepository;

    }

    @PostMapping("/products")
    public Product newProduct(@RequestBody Product product) {

        return productRepository.save(product);

    }

    @GetMapping("/products/{id}")
    public Product one(@PathVariable Integer id) {
        return productRepository.findById(id)
                .orElseThrow();
    }

    @GetMapping("/products")
    public Page<Product> all(
            @RequestParam(required = false) String productName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "ASC", required = false) String sort
    ) {

        PageRequest paging = PageRequest
                .of(page, size)
                .withSort(sort.equalsIgnoreCase("ASC") ?
                        Sort.by("productName").ascending() :
                        Sort.by("productName").descending());

        Page<Product> res;
        if (productName == null) {
            res = productRepository.findAll(paging);
        } else {
            res = productRepository.findByProductNameContainingIgnoreCase(productName, paging);
        }

        return res;

    }

    @PutMapping("/products/{id}")
    public Product update(@PathVariable Integer id, @RequestBody Product product) {
        if (!id.equals(product.getProductId())) {
            throw new HttpClientErrorException(HttpStatusCode.valueOf(400), "id in path does not patch id in body");
        }
        return productRepository.save(product);
    }

        @DeleteMapping("/products/{id}")
        public void delete(@PathVariable Integer id){

            Product match = productRepository.findById(id)
                    .orElseThrow();
            productRepository.delete(match);

        }

    }
