package com.mindthecode.firstproject.OrdersProject;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    private Integer productId;
    private String productName;
    private double productPrice;
    private String productDescription;


    public Product(Integer productId, String productName, double productPrice, String productDescription) {

        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;

    }

    public Integer getProductId() {

        return productId;

    }

    public void setProductId(Integer productId) {

        this.productId = productId;

    }

    public String getProductName() {

        return productName;

    }

    public void setProductName(String productName) {

        this.productName = productName;

    }

    public double getProductPrice() {

        return productPrice;

    }

    public void setProductPrice(double productPrice) {

        this.productPrice = productPrice;
    }

    public String getProductDescription() {

        return productDescription;

    }

    public void setProductDescription(String productDescription) {

        this.productDescription = productDescription;

    }
}
