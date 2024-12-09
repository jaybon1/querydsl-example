package com.example.mart.domain.selling.dto.res;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ResGetSellingProductsDTOApiV1 {

    private List<Product> productList;

    @Getter
    @Builder
    public static class Product {
        private Long id;
        private String name;
        private Boolean isDiscount;
        private Integer price;
        private Integer discountPrice;
        private String productKindName;
        private String productMakerName;
        private Integer stock;

        @QueryProjection
        public Product(Long id, String name, Boolean isDiscount, Integer price, Integer discountPrice, String productKindName, String productMakerName, Integer stock) {
            this.id = id;
            this.name = name;
            this.isDiscount = isDiscount;
            this.price = price;
            this.discountPrice = discountPrice;
            this.productKindName = productKindName;
            this.productMakerName = productMakerName;
            this.stock = stock;
        }
    }

}

