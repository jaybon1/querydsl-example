package com.example.mart.model.product.repository;

import com.example.mart.domain.selling.dto.res.QResGetSellingProductsDTOApiV1_Product;
import com.example.mart.domain.selling.dto.res.ResGetSellingProductsDTOApiV1;
import com.example.mart.model.product.entity.Product;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.mart.model.product.entity.QProduct.product;
import static com.example.mart.model.product.entity.QProductKind.productKind;
import static com.example.mart.model.product.entity.QProductMaker.productMaker;

// ProductRepositoryCustom 에서 생성한 인터페이스를 여기서 구현
@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public ResGetSellingProductsDTOApiV1 getSellingProductsByQueryDsl(Integer searchType, String searchValue) {
        JPAQuery<ResGetSellingProductsDTOApiV1.Product> query = jpaQueryFactory
//                .select(Projections.constructor(ResGetSellingProductsDTOApiV1.Product.class
                .select(new QResGetSellingProductsDTOApiV1_Product( // DTO로 리턴
                        product.id,
                        new CaseBuilder() // case when,
                                .when(product.isDiscount.eq(true))
                                .then(product.name.append(Expressions.stringTemplate("' (할인 중)'")))
                                .otherwise(product.name),
                        product.isDiscount,
                        product.price,
                        product.discountPrice,
                        JPAExpressions // 스칼라 서브 쿼리
                                .select(productKind.name)
                                .from(productKind)
                                .where(productKind.id.eq(product.productKind.id)),
                        productMaker.name,
                        product.stock
                ))
                .from(product) // 기준 테이블
                .join(productMaker).on(product.productMaker.id.eq(productMaker.id)) // 조인
                .where(customSearch(searchType, searchValue)) // 동적 조건을 위한 함수 호출
                .orderBy(product.id.desc()); // 역정렬
        return ResGetSellingProductsDTOApiV1.builder()
                .productList(query.fetch())
                .build();
    }

    // searchType에 따라 동적으로 쿼리를 변경시킨다.
    private Predicate customSearch(Integer searchType, String searchValue) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(product.name.isNotEmpty());
        // 주의 productKind처럼 기준테이블이나 조인에 쓰이지 않은 테이블은 조건에 넣으면 안된다.
        if (searchType == 1) {
            booleanBuilder.and(product.name.contains(searchValue));
        } else if (searchType == 2) {
            booleanBuilder.and(productMaker.name.contains(searchValue));
        }
        return booleanBuilder;
    }

    //////////////////////////////////////
    // 여기서 부터는 참고용 코드 입니다.//
    //////////////////////////////////////

    // 상품 목록 조회
    public List<Product> getProducts(Integer searchType, String searchValue) {
        JPAQuery<Product> query = jpaQueryFactory
                .select(product)
                .from(product)
                .where(customSearch(searchType, searchValue));
        return query.fetch();
    }

    // 단일 상품 조회
    public Product getProductById(Long id) {
        JPAQuery<Product> query = jpaQueryFactory
                .select(product)
                .from(product)
                .where(product.id.eq(id));
        return query.fetchOne();
    }

    // 상품 수량 조회
    public Long getProductCount() {
        JPAQuery<Long> query = jpaQueryFactory
                .select(product.count())
                .from(product);
        return query.fetchOne();
    }


    // QueryDsl은 from절에 서브쿼리가 불가능하다.
    // 배민에서는 조건을 미리 걸어 쿼리를 하여 리스트를 가져오고
    // 해당 리스트를 다음 쿼리의 where 조건으로 넣어서 해결했다고 한다.
    public List<Product> getProductsByInlineViewSubQuery() {

        List<Long> idList = jpaQueryFactory
                .select(product.id)
                .from(product)
                .where(customSearch(2, "농심"))
                .fetch();

        JPAQuery<Product> query = jpaQueryFactory
                .select(product)
                .from(product)
                .where(product.id.in(idList))
                .where(product.stock.gt(0));

        return query.fetch();
    }

}
