package com.example.mart.model.product.repository;

import com.example.mart.model.product.entity.Product;
import com.example.mart.model.product.entity.QProduct;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringPath;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.example.mart.model.product.entity.QProduct.product;

public interface ProductRepository extends JpaRepository<Product, Long>,
        ProductRepositoryCustom,
        QuerydslPredicateExecutor<Product>,
        QuerydslBinderCustomizer<QProduct> {

//    default Page<Product> findAll(List<Long> idList, Predicate predicate, Pageable pageable) {
//        BooleanBuilder booleanBuilder = new BooleanBuilder(predicate);
//        if (idList != null && !idList.isEmpty()) {
//            booleanBuilder.and(product.id.in(idList));
//        }
//        booleanBuilder.and(product.stock.gt(0));
//        return findAll(predicate, pageable);
//    }

    @Override
    default void customize(QuerydslBindings querydslBindings, @NotNull QProduct qProduct) {
        querydslBindings.bind(String.class).all((StringPath path, Collection<? extends String> values) -> {
            List<String> valueList = new ArrayList<>(values.stream().map(String::trim).toList());
            if (valueList.isEmpty()) {
                return Optional.empty();
            }
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            for (String s : valueList) {
                booleanBuilder.or(path.containsIgnoreCase(s));
            }
            return Optional.of(booleanBuilder);
        });
    }

}
