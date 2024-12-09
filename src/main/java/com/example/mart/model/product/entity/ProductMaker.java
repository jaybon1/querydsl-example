package com.example.mart.model.product.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PRODUCT_MAKER")
@EqualsAndHashCode(of = "id", callSuper = false)
public class ProductMaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "productMaker", fetch = FetchType.LAZY)
    private List<Product> productList;

}
