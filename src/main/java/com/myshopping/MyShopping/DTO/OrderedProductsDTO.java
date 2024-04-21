package com.myshopping.MyShopping.DTO;

import com.myshopping.MyShopping.Models.AppUser;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

public class OrderedProductsDTO {

    UUID prodId;
    String prodName;
    int quantity;

    public OrderedProductsDTO(UUID prodId, String prodName, int quantity) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.quantity = quantity;
    }

    public OrderedProductsDTO() {
    }

    public UUID getProdId() {
        return prodId;
    }

    public void setProdId(UUID prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
