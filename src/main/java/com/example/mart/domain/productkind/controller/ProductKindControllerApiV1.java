package com.example.mart.domain.productkind.controller;

import com.example.mart.domain.productkind.dto.res.ResGetProductKindByIdDTOApiV1;
import com.example.mart.domain.productkind.dto.res.ResGetProductKindsDTOApiV1;
import com.example.mart.domain.productkind.service.ProductKindServiceApiV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/product-kinds")
public class ProductKindControllerApiV1 {

    private final ProductKindServiceApiV1 productKindServiceApiV1;

    @GetMapping
    public ResponseEntity<ResGetProductKindsDTOApiV1> get(
    ) {
        return ResponseEntity.ok(productKindServiceApiV1.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResGetProductKindByIdDTOApiV1> getById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(productKindServiceApiV1.getById(id));
    }

}
