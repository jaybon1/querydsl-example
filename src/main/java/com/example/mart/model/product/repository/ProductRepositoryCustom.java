package com.example.mart.model.product.repository;

import com.example.mart.domain.selling.dto.res.ResGetSellingProductsDTOApiV1;

// QueryDsl 매핑 인터페이스 생성
public interface ProductRepositoryCustom {

    ResGetSellingProductsDTOApiV1 getSellingProductsByQueryDsl(Integer searchType, String searchValue);

}
