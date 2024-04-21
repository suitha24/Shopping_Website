package com.myshopping.MyShopping.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

public class BillDTO {
    UUID orderId;
    int totalQuantity;
    int totalPrice;
    UUID buyerId;
    String buyerName;
    long buyerPhoneNumber;
    String buyerEmail;
    List<OrderedProductsDTO> orderedProductsList;

    public BillDTO(UUID orderId, int totalQuantity, int totalPrice, UUID buyerId, String buyerName, long buyerPhoneNumber, String buyerEmail, List<OrderedProductsDTO> orderedProductsList) {
        this.orderId = orderId;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
        this.buyerId = buyerId;
        this.buyerName = buyerName;
        this.buyerPhoneNumber = buyerPhoneNumber;
        this.buyerEmail = buyerEmail;
        this.orderedProductsList = orderedProductsList;
    }

    public BillDTO() {
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

    public UUID getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(UUID buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public long getBuyerPhoneNumber() {
        return buyerPhoneNumber;
    }

    public void setBuyerPhoneNumber(long buyerPhoneNumber) {
        this.buyerPhoneNumber = buyerPhoneNumber;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public List<OrderedProductsDTO> getOrderedProductsList() {
        return orderedProductsList;
    }

    public void setOrderedProductsList(List<OrderedProductsDTO> orderedProductsList) {
        this.orderedProductsList = orderedProductsList;
    }
}
