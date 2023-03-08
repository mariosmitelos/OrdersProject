//package com.mindthecode.firstproject.OrdersProject;
//
//import jakarta.persistence.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer orderId;
//    private double discount;
//
//    private double finalPriceAfterDiscount;
//
//    @OneToMany(mappedBy = "pk.order")
//    private List<OrderProduct> orderProducts = new ArrayList<>();
//
//    public double getFinalPriceAfterDiscount() {
//
//        double sum = 0D;
//        List<OrderProduct> orderProducts = getOrderProducts();
//        for(OrderProduct op : orderProducts) {
//            sum += op.getTotalPrice();
//        }
//
//        sum = sum*(100-discount)/100;
//
//        return sum;
//
//    }
//
//    @Transient
//    public int getNumberOfProducts() {
//
//        return this.orderProducts.size();
//
//    }
//
//    public Integer getOrderId() {
//
//        return orderId;
//
//    }
//
//    public double getDiscount() {
//
//        return discount;
//
//    }
//
//    public void setDiscount(double discount) {
//
//        this.discount = discount;
//
//    }
//
//    public void setOrderId(Integer orderId) {
//
//        this.orderId = orderId;
//
//    }
//
//
//    public void setOrderProducts(List<OrderProduct> orderProducts) {
//
//        this.orderProducts = orderProducts;
//
//    }
//
//    public List<OrderProduct> getOrderProducts() {
//
//        return orderProducts;
//
//    }
//}
