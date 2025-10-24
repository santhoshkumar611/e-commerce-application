package com.example.e_commerce.application.service;

import com.example.e_commerce.application.model.Cart;
import com.example.e_commerce.application.model.Order;
import com.example.e_commerce.application.model.User;
import com.example.e_commerce.application.repository.CartRepository;
import com.example.e_commerce.application.repository.OrderRepository;
import com.example.e_commerce.application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    @Transactional
    public Order placeOrder(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        if (cart.getProducts().isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        Order order = new Order();
        order.setUser(user);
        order.setProducts(new ArrayList<>(cart.getProducts()));

        double total = cart.getProducts().stream()
                .mapToDouble(p -> p.getPrice() * p.getStockQuantity()) // fix method call
                .sum();
        order.setTotalPrice(total);
        order.setOrderDate(LocalDateTime.now());

        orderRepository.save(order);

        cart.getProducts().clear();
        cartRepository.save(cart);

        return order;
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }
}
