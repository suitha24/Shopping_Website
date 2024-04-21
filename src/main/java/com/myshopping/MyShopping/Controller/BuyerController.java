package com.myshopping.MyShopping.Controller;

import com.myshopping.MyShopping.DTO.BillDTO;
import com.myshopping.MyShopping.DTO.OrderDetailsDTO;
import com.myshopping.MyShopping.Models.OrderTable;
import com.myshopping.MyShopping.Service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/buyer")
public class BuyerController {
//    @Autowired
//    OrderDetailsDTO orderDetailsDTO;

    @Autowired
    BuyerService buyerService;
    @PostMapping("/placeorder")
    public BillDTO placeOrder(@RequestBody List<OrderDetailsDTO> orders, @RequestParam UUID userId){
        return buyerService.placeOrder(orders,userId);
    }
}
