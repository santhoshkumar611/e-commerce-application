package com.example.e_commerce.application.repository;

import com.example.e_commerce.application.model.Cart;
import com.example.e_commerce.application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    // Find cart by user
    Optional<Cart> findByUser(User user);
}
