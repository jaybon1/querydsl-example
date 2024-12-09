package com.example.mart.domain.product.controller;

import com.example.mart.domain.product.dto.res.ResGetProductsDTOApiV1;
import com.example.mart.domain.product.service.ProductServiceApiV1;
import com.example.mart.model.product.entity.Product;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/products")
public class ProductControllerApiV1 {

    private final ProductServiceApiV1 productServiceApiV1;

    @GetMapping
    public ResponseEntity<ResGetProductsDTOApiV1> findPageByQuerydsl(
            @RequestParam(required = false) List<Long> idList,
            @QuerydslPredicate(root = Product.class) Predicate predicate,
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
//        return ResponseEntity.ok(productServiceApiV1.findAllByQueryDsl_Mark_1(predicate, pageable));
        return ResponseEntity.ok(productServiceApiV1.findAllByQueryDsl_Mark_2(idList, predicate, pageable));
    }

}
