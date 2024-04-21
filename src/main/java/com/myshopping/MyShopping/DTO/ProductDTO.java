package com.myshopping.MyShopping.DTO;

import com.myshopping.MyShopping.Models.AppUser;
import com.myshopping.MyShopping.Service.ProductService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class ProductDTO {

    String productName;
    String productCategory;
    float rating;
    int price;
    UUID id;
    String description;
    String sellerName;

    public ProductDTO(String productName, String productCategory, float rating, int price, UUID id, String description,String sellerName) {

        this.productName = productName;
        this.productCategory = productCategory;
        this.rating = rating;
        this.price = price;
        this.id = id;
        this.description = description;
        this.sellerName=sellerName;
    }

    public ProductDTO() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName=sellerName;
    }
}
