package com.myshopping.MyShopping.Controller;

import com.myshopping.MyShopping.DTO.ProductDTO;
import com.myshopping.MyShopping.Models.AppUser;
import com.myshopping.MyShopping.Service.ProductService;
import com.myshopping.MyShopping.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommonController {
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @PostMapping("/user/register")
    public String registerUser(@RequestBody AppUser appUser){
        userService.registerUser(appUser);
        return "User got saved successfully";
    }
    @GetMapping("/product/search")
    //here we need to search the prod, so Product service is needed
    public List<ProductDTO> searchProductByCategory(@RequestParam(required = false) String category, @RequestParam(required = false) String productName){
        //if both args are not null, then we will search the db with both values
        if(category!=null && productName!=null){
            return productService.searchProductByNameAndCategory(category,productName);
        }
        //if any one args is null, then we'll search the db using other args
        else if(category!=null){
            return productService.searchProductByCategory(category);
        }
        else if (productName!=null) {
            return productService.searchProductByName(productName);
        }
        //return all the prod present in db
        else
        {
            return productService.getAllProducts();
        }
    }

}
