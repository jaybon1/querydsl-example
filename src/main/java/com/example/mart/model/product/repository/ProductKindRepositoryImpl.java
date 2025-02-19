package com.example.mart.model.product.repository;

import com.example.mart.domain.productkind.dto.res.QResGetProductKindsDTOApiV1_ProductKindDTO;
import com.example.mart.domain.productkind.dto.res.ResGetProductKindsDTOApiV1;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.mart.model.product.entity.QProduct.product;
import static com.example.mart.model.product.entity.QProductKind.productKind;
import static com.example.mart.model.product.entity.QProductMaker.productMaker;

// ProductRepositoryCustom 에서 생성한 인터페이스를 여기서 구현
@Repository
@RequiredArgsConstructor
public class ProductKindRepositoryImpl implements ProductKindRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public ResGetProductKindsDTOApiV1 getProductKindsWithQueryDsl() {
        JPAQuery<ResGetProductKindsDTOApiV1.ProductKindDTO> query = jpaQueryFactory
                .select(
                        new QResGetProductKindsDTOApiV1_ProductKindDTO(productKind)
                )
                .from(productKind);











        return ResGetProductKindsDTOApiV1.builder()
                .productKindList(query.fetch())
                .build();
    }
}
