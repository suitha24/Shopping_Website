package com.myshopping.MyShopping.Service;

import com.myshopping.MyShopping.DTO.ProductDTO;
import com.myshopping.MyShopping.Exception.ResourceNotFound;
import com.myshopping.MyShopping.Exception.UnAuthorised;
import com.myshopping.MyShopping.Models.AppUser;
import com.myshopping.MyShopping.Models.Product;
import com.myshopping.MyShopping.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    UserService userService;
    @Autowired
    ProductRepository productRepository;

    public List<ProductDTO> convertProductListToProductDTOList(List<Product> products){
        List<ProductDTO> productList=new ArrayList<>();
        for(Product product:products){
            ProductDTO productDTO=new ProductDTO();
            productDTO.setProductName(product.getName());
            productDTO.setProductCategory(product.getCategory());
            productDTO.setId(product.getId());
            productDTO.setPrice(product.getPrice());
            productDTO.setDescription(product.getDescription());
            productDTO.setRating(product.getRating());
            productDTO.setSellerName(product.getSellerName());
            productList.add(productDTO);
        }
        return productList;
    }
    public List<ProductDTO> searchProductByName(String productName){
        List<Product> products= productRepository.getProductByName(productName);
        System.out.println(products);
        List<ProductDTO> productList=convertProductListToProductDTOList(products);
        return productList;
    }
    public List<ProductDTO> searchProductByCategory(String category){
        List<Product> products= productRepository.getProductByCategory(category);
        System.out.println(products);
        List<ProductDTO> productList=convertProductListToProductDTOList(products);
        return productList;
    }
    public List<ProductDTO> searchProductByNameAndCategory(String category, String productName){
        List<Product> products= productRepository.getProductByNameAndCategory(category,productName);
        System.out.println(products);
        List<ProductDTO> productList=convertProductListToProductDTOList(products);
        return productList;
    }
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productList = convertProductListToProductDTOList(products);
        return productList;
    }
    public Product getProductById(UUID id){
        return productRepository.findById(id).orElse(null);
    }
    void updateProductQuantity(UUID id,int quantity){
        productRepository.updateProductQuantity(id,quantity);
    }
        public void registerProduct( Product product,  UUID sellerId){
        AppUser user=userService.getUserById(sellerId);
        if(user==null){
            throw new ResourceNotFound(String.format("Seller with sellerId %s does not exist",sellerId.toString()));
        }
        if(!user.getUserType().equals("SELLER")){
            throw new UnAuthorised(String.format("User with ID %s is not authorised to perform this operation",sellerId.toString()));
        }
        product.setUser(user);
        product.setSellerName(user.getName());
        productRepository.save(product);
    }
}
