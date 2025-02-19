package com.example.mart.model.product.repository;

import com.example.mart.domain.selling.dto.res.ResGetSellingDTOApiV1;

// QueryDsl 매핑 인터페이스 생성
public interface ProductRepositoryCustom {

    ResGetSellingDTOApiV1 getSellingWithQueryDsl(Integer searchType, String searchValue);

}
