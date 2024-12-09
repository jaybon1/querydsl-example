package com.example.mart.model.product.repository;

import com.example.mart.model.product.entity.Product;
import com.example.mart.model.product.entity.QProduct;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.StringPath;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom,
        QuerydslPredicateExecutor<Product>,
        QuerydslBinderCustomizer<QProduct> {

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
