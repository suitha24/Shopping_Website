package com.myshopping.MyShopping.Service;

import com.myshopping.MyShopping.DTO.BillDTO;
import com.myshopping.MyShopping.DTO.OrderDetailsDTO;
import com.myshopping.MyShopping.DTO.OrderedProductsDTO;
import com.myshopping.MyShopping.Models.AppUser;
import com.myshopping.MyShopping.Models.OrderTable;
import com.myshopping.MyShopping.Models.Product;
import com.myshopping.MyShopping.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BuyerService {
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderRepository orderRepository;

    public  BillDTO placeOrder(List<OrderDetailsDTO> orderDetailsDTOList, UUID userId){
        //get user
        AppUser user=userService.getUserById(userId);

        //OrderTable orderTable=new OrderTable();
        BillDTO bill=new BillDTO();
        OrderedProductsDTO orderedProductsDTO=new OrderedProductsDTO();

        int totalPrice=0;
        int totalQuantity=0;

        //List<Product> products=new ArrayList<>();
        List<OrderedProductsDTO> orderedProductsList=new ArrayList<>();
        //get product one by one using prod id
        for(OrderDetailsDTO order:orderDetailsDTOList){
            UUID prodId=order.getId();
            Product product=productService.getProductById(prodId);

            OrderedProductsDTO orderedProduct=new OrderedProductsDTO();

            orderedProduct.setProdId(order.getId());
            orderedProduct.setQuantity(order.getQuantity());
            orderedProduct.setProdName(product.getName());
            // Add the products list to Bill DTO
            orderedProductsList.add(orderedProduct);
           // products.add(product);
            totalQuantity+=order.getQuantity();
            totalPrice+=product.getPrice()*order.getQuantity();
            //orderTable.setPaymentMode(order.getPaymentMode());

            //reduce product quantity in db
            int currentQuantity=product.getQuantity()-order.getQuantity();
            productService.updateProductQuantity(prodId,currentQuantity);
            //Add user details in Bill DTO
            bill.setOrderId(order.getId());
            bill.setBuyerId(user.getId());
            bill.setBuyerEmail(user.getEmail());
            bill.setBuyerPhoneNumber(user.getPhonenumber());
            bill.setBuyerName(user.getName());
            bill.setTotalPrice(totalPrice);
            bill.setTotalQuantity(totalQuantity);
            bill.setOrderedProductsList(orderedProductsList);
        }

//        orderTable.setTotalPrice(totalPrice);
//        orderTable.setTotalQuantity(totalQuantity);
//        orderTable.setProducts(products);
//        orderTable.setStatus("Not Delivered");
//        orderTable.setUser(user);
//
//        orderRepository.save(orderTable);

        return bill;
    }
}
