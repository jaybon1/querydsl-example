package com.example.mart.domain.product.dto.res;

import com.example.mart.model.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.web.PagedModel;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ResGetProductsDTOApiV1 {

    private ProductPage productPage;

    public static ResGetProductsDTOApiV1 of(Page<Product> productPage) {
        return ResGetProductsDTOApiV1.builder()
                .productPage(new ProductPage(productPage))
                .build();
    }

    @Getter
    @ToString
    public static class ProductPage extends PagedModel<ProductPage.Product> {

        public ProductPage(Page<com.example.mart.model.product.entity.Product> productPage) {
            super(
                    new PageImpl<>(
                            ProductPage.Product.from(productPage.getContent()),
                            productPage.getPageable(),
                            productPage.getTotalElements()
                    )
            );
        }

        @Getter
        @Builder
        @AllArgsConstructor
        public static class Product {
            private Long id;
            private String name;
            private Boolean isDiscount;
            private Integer price;
            private Integer discountPrice;
            private String productKindName;
            private String productMakerName;
            private Integer stock;

            public static List<Product> from(List<com.example.mart.model.product.entity.Product> productList) {
                return productList.stream()
                        .map(ProductPage.Product::from)
                        .toList();
            }

            public static Product from(com.example.mart.model.product.entity.Product product) {
                return ProductPage.Product.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .isDiscount(product.getIsDiscount())
                        .price(product.getPrice())
                        .discountPrice(product.getDiscountPrice())
                        .productKindName(product.getProductKind().getName())
                        .productMakerName(product.getProductMaker().getName())
                        .stock(product.getStock())
                        .build();
            }

        }

    }

}
