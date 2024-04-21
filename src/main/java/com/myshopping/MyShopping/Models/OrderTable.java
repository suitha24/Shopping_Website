package com.myshopping.MyShopping.Models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;
@Entity
public class OrderTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID orderId;
    int totalQuantity;
    int totalPrice;
    @ManyToOne
    AppUser user;
   @OneToMany  //a new table will be created due to one-many relationship
    List<Product> products;
   String status;
   String paymentMode;

    public OrderTable(UUID orderId, int totalQuantity, int totalPrice, AppUser user, List<Product> products, String status, String paymentMode) {
        this.orderId = orderId;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
        this.user = user;
        this.products = products;
        this.status = status;
        this.paymentMode = paymentMode;
    }

    public OrderTable() {
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
}
