//package com.mindthecode.firstproject.OrdersProject;
//
//import jakarta.persistence.Embeddable;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.ManyToOne;
//
//import java.io.Serializable;
//
//@Embeddable
//public class OrderProductPK implements Serializable {
//
//
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    private Order order;
//
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    private Product product;
//
//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//}
