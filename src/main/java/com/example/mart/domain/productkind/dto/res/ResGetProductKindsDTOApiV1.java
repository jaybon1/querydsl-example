package com.example.mart.domain.productkind.dto.res;

import com.example.mart.model.product.entity.ProductKind;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ResGetProductKindsDTOApiV1 {

    private List<ProductKindDTO> productKindList;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductKindDTO {
        private Long id;
        private String name;
        private List<ProductDTO> productList;

        @QueryProjection
        public ProductKindDTO(ProductKind productKind) {
            this.id = productKind.getId();
            this.name = productKind.getName();
            this.productList = productKind.getProductList().stream()
                    .map(product -> ProductDTO.builder()
                            .id(product.getId())
                            .name(product.getName())
                            .price(product.getPrice())
                            .build())
                    .toList();
        }

        @Getter
        @Builder
        public static class ProductDTO {
            private Long id;
            private String name;
            private Integer price;
        }

    }

}
