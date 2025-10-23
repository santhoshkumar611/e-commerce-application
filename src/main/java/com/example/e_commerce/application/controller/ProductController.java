package com.example.e_commerce.application.controller;


import com.example.e_commerce.application.model.Product;
import com.example.e_commerce.application.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

        public  final ProductService service;

        public ProductController(ProductService service){
            this.service = service;
        }
        @GetMapping
        public List<Product> getAllProduct(){
            return service.getAllProduct();
        }
        @PostMapping
        public Product addProduct(@RequestBody Product product){
            return  service.addProduct(product);
        }
        @PutMapping("/{id}")
        public  Product updateProduct(@PathVariable Long id,@RequestBody Product product){
          return service.updateProduct(id, product);
        }
        @DeleteMapping("/{id}")
        public String deleteProduct(@PathVariable Long id){
            service.deleteProduct(id);
            return "Product Deleted successfully";
        }
}
