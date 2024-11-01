package com.virtukch.dongiveupbe.select_product.dto;

import com.virtukch.dongiveupbe.select_product.entity.SelectProduct;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SelectProductRequestDto {
    private String selectProductName;

    private String selectProductDescription;

    private Long selectProductViewAmount;

    private String selectProductUrl;


    public SelectProduct toEntity() {
        return SelectProduct.builder()
                .selectProductName(selectProductName)
                .selectProductDescription(selectProductDescription)
                .selectProductViewAmount(selectProductViewAmount)
                .selectProductUrl(selectProductUrl)
                .build();
    }
}
