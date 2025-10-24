package com.example.e_commerce.application.repository;

import com.example.e_commerce.application.model.Order;
import com.example.e_commerce.application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // Optional: find all orders by a user
    List<Order> findByUser(User user);
}
