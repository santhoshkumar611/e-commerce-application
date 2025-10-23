package com.example.e_commerce.application.repository;

import com.example.e_commerce.application.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
