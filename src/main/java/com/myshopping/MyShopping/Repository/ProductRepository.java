package com.myshopping.MyShopping.Repository;

import com.myshopping.MyShopping.Models.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query(value = "select * from product where category=:category and name=:productName",nativeQuery = true)
    public List<Product> getProductByNameAndCategory(String category,String productName);

    @Query(value = "select * from product where name=:productName",nativeQuery = true)
    public List<Product> getProductByName(String productName);

    @Query(value = "select * from product where category=:category",nativeQuery = true)
    public List<Product> getProductByCategory(String category);

    @Transactional  //to lock the db- as we are performing update operation DB, no other API calls will be allowed till this query update is done
    @Modifying //as we are modifying the db
    @Query(value = "update product set quantity=:quantity where id=:prodId",nativeQuery = true)
    public void updateProductQuantity(UUID prodId,int quantity);

}
