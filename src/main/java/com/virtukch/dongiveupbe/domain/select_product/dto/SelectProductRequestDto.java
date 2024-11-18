package com.virtukch.dongiveupbe.domain.select_product.dto;

import com.virtukch.dongiveupbe.domain.select_product.entity.SelectProduct;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SelectProductRequestDto {
    private String selectProductName;

    private String selectProductDescription;

    private Long selectProductViewAmount;

    private String selectProductUrl;

    private Integer selectProductPrice;

    public SelectProduct toEntity() {
        return SelectProduct.builder()
                .selectProductName(selectProductName)
                .selectProductDescription(selectProductDescription)
                .selectProductViewAmount(selectProductViewAmount)
                .selectProductUrl(selectProductUrl)
                .selectProductPrice(selectProductPrice)
                .build();
    }
}
