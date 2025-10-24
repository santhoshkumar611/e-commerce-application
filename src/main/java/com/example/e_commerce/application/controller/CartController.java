package com.example.e_commerce.application.controller;

import com.example.e_commerce.application.model.Cart;
import com.example.e_commerce.application.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/{userId}/add/{productId}")
    public Cart addToCart(@PathVariable Long userId, @PathVariable Long productId) {
        return cartService.addProductToCart(userId, productId);
    }

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable Long userId) {
        return cartService.getCartByUser(userId).orElseThrow(() -> new RuntimeException("Cart is empty"));
    }

}
