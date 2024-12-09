package com.example.mart.domain.selling.service;

import com.example.mart.domain.selling.dto.res.ResGetSellingProductsDTOApiV1;
import com.example.mart.model.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SellingServiceApiV1 {

    private final ProductRepository productRepository;

    public ResGetSellingProductsDTOApiV1 getSellingProductsByQueryDsl(Integer searchType, String searchValue) {
        return productRepository.getSellingProductsByQueryDsl(searchType, searchValue);
    }

}

