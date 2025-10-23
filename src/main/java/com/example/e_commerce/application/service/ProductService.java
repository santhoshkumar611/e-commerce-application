package com.example.e_commerce.application.service;

import com.example.e_commerce.application.model.Product;
import com.example.e_commerce.application.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;
    }
    public List<Product> getAllProduct(){
        return repository.findAll();
    }

    public Product getProductById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Product addProduct(Product product){
        return repository.save(product);
    }

    public Product updateProduct(Long id,Product updated){

        Product existing = repository.findById(id).orElse(null);
        if(existing != null){
            existing.setName(updated.getName());
            existing.setDescription(updated.getDescription());
            existing.setPrice(updated.getPrice());
            existing.setStockQuantity(updated.getStockQuantity());
            existing.setImageUrl(updated.getImageUrl());
            return repository.save(existing);
        }
        return null;
    }
    public  void  deleteProduct(Long id){
        repository.deleteById(id);
    }
}
