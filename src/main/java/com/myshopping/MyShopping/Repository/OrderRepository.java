package com.myshopping.MyShopping.Repository;

import com.myshopping.MyShopping.Models.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderTable, UUID> {

}
