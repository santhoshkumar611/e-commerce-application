package com.example.e_commerce.application.model;
import  jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name="carts")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn
    private  User user;

    @ManyToMany
    @JoinTable(
            name = "cart_products",
            joinColumns = @JoinColumn(name ="cart_id"),
            inverseJoinColumns = @JoinColumn(name ="product_id")
    )
    private List<Product> products;
}
