package com.example.mart.domain.product.service;

import com.example.mart.domain.product.dto.res.ResGetProductsDTOApiV1;
import com.example.mart.model.product.entity.Product;
import com.example.mart.model.product.repository.ProductRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.mart.model.product.entity.QProduct.product;

@Service
@RequiredArgsConstructor
public class ProductServiceApiV1 {

    private final ProductRepository productRepository;

    public ResGetProductsDTOApiV1 findAllByQueryDsl_Mark_1(Predicate predicate, Pageable pageable) {
        Page<Product> productEntityPage = productRepository.findAll(predicate, pageable);
        return ResGetProductsDTOApiV1.of(productEntityPage);
    }

    public ResGetProductsDTOApiV1 findAllByQueryDsl_Mark_2(Predicate predicate, Pageable pageable) {
        BooleanBuilder booleanBuilder = new BooleanBuilder(predicate);
        booleanBuilder.and(product.stock.gt(0));
        Page<Product> productEntityPage = productRepository.findAll(booleanBuilder, pageable);
        return ResGetProductsDTOApiV1.of(productEntityPage);
    }

    public ResGetProductsDTOApiV1 findAllByQueryDsl_Mark_3(List<Long> idList, Predicate predicate, Pageable pageable) {
        BooleanBuilder booleanBuilder = new BooleanBuilder(predicate);
        if (idList != null && !idList.isEmpty()) {
            booleanBuilder.and(product.id.in(idList));
        }
        booleanBuilder.and(product.stock.gt(0));
        Page<Product> productEntityPage = productRepository.findAll(booleanBuilder, pageable);
        return ResGetProductsDTOApiV1.of(productEntityPage);
    }

}
