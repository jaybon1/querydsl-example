package com.example.mart.domain.selling.controller;

import com.example.mart.domain.selling.dto.res.ResGetSellingDTOApiV1;
import com.example.mart.domain.selling.service.SellingServiceApiV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/selling")
public class SellingControllerApiV1 {

    private final SellingServiceApiV1 sellingServiceApiV1;

    @GetMapping
    public ResponseEntity<ResGetSellingDTOApiV1> getSellingWithQueryDsl(
            @RequestParam(value = "searchType", defaultValue = "0") Integer searchType,
            @RequestParam(value = "searchValue", defaultValue = "") String searchValue
    ) {
        ResGetSellingDTOApiV1 resGetSellingDTOApiV1 =
                sellingServiceApiV1.getSellingWithQueryDsl(searchType, searchValue);
        return ResponseEntity.ok(resGetSellingDTOApiV1);
    }

}
