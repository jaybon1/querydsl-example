package com.example.mart.domain.productkind.service;

import com.example.mart.domain.productkind.dto.res.ResGetProductKindByIdDTOApiV1;
import com.example.mart.domain.productkind.dto.res.ResGetProductKindsDTOApiV1;
import com.example.mart.model.product.repository.ProductKindRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductKindServiceApiV1 {

    private final ProductKindRepository productKindRepository;

    public ResGetProductKindsDTOApiV1 get() {
        return productKindRepository.getProductKindsWithQueryDsl();
    }

    public ResGetProductKindByIdDTOApiV1 getById(Long id) {
        return null;
    }

}

