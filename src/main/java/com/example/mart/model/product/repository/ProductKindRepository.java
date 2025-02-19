package com.example.mart.model.product.repository;

import com.example.mart.model.product.entity.ProductKind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductKindRepository extends JpaRepository<ProductKind, Long>,
        ProductKindRepositoryCustom
{



}
