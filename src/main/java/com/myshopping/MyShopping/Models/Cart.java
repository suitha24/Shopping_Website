package com.myshopping.MyShopping.Models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID cartId;
    int quantity;
    int totalAmount;
    @OneToOne
    AppUser user;
    @OneToMany
    List<Product> products;

    public Cart(UUID cartId, int quantity, int totalAmount, AppUser user, List<Product> products) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.user = user;
        this.products = products;
    }

    public Cart() {
    }

    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
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
}
