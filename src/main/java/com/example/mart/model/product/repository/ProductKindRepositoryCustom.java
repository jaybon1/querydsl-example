package com.example.mart.model.product.repository;

import com.example.mart.domain.productkind.dto.res.ResGetProductKindsDTOApiV1;

// QueryDsl 매핑 인터페이스 생성
public interface ProductKindRepositoryCustom {

    ResGetProductKindsDTOApiV1 getProductKindsWithQueryDsl();
}
