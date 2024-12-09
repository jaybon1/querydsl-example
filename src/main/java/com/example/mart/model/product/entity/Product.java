package com.example.mart.model.product.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PRODUCT")
@EqualsAndHashCode(of = "id", callSuper = false)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_discount", nullable = false)
    private Boolean isDiscount;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "discount_price", nullable = false)
    private Integer discountPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_kind_id", referencedColumnName = "id")
    private ProductKind productKind;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_maker_id", referencedColumnName = "id")
    private ProductMaker productMaker;

    @Column(name = "stock")
    private Integer stock; // 재고

}
