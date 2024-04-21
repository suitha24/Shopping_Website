package com.myshopping.MyShopping.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

public class OrderDetailsDTO {
    UUID id;
    int quantity;
    String paymentMode;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(UUID id, int quantity, String paymentMode) {
        this.id = id;
        this.quantity = quantity;
        this.paymentMode = paymentMode;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getPaymentMode() {
        return paymentMode;
    }
    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

}
