package com.example.e_commerce.application.service;

import com.example.e_commerce.application.model.Cart;
import com.example.e_commerce.application.model.Product;
import com.example.e_commerce.application.model.User;
import com.example.e_commerce.application.repository.CartRepository;
import com.example.e_commerce.application.repository.ProductRepository;
import com.example.e_commerce.application.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public Cart addProductToCart(Long userId, Long productId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        Cart cart = cartRepository.findByUser(user).orElse(new Cart(null, user, new ArrayList<>()));
        cart.getProducts().add(product);

        return cartRepository.save(cart);
    }

    public Optional<Cart> getCartByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return cartRepository.findByUser(user);
    }
}
