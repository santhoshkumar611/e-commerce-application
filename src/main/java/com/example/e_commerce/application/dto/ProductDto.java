package com.example.e_commerce.application.dto;


import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class ProductDto {
    @NotBlank(message = "Product name is required")
    private String name;

    private String description;

    @Min(value = 0, message = "Price must be non-negative")
    private double price;

    @Min(value = 0, message = "Stock quantity must be non-negative")
    private int stockQuantity;

    private String imageUrl;

    private  String category;
}