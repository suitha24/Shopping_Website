package com.myshopping.MyShopping.Controller;

import com.myshopping.MyShopping.Exception.ResourceNotFound;
import com.myshopping.MyShopping.Exception.UnAuthorised;
import com.myshopping.MyShopping.Models.Product;
import com.myshopping.MyShopping.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    ProductService productService;
    @PostMapping("/product/add")
    public String addProduct(@RequestBody Product product, @RequestParam UUID sellerId){
        //to save prod, we need to write some logic
        //for that we need service class
        try{
            productService.registerProduct(product,sellerId);
        }
        catch(ResourceNotFound resourceNotFound){
            return resourceNotFound.getMessage();
        }
        catch (UnAuthorised unAuthorised){
            return unAuthorised.getMessage();
        }
        return "Product got saved successfully";
    }
}
