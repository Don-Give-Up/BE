package com.virtukch.dongiveupbe.domain.select_product.dto;

import com.virtukch.dongiveupbe.domain.select_product.entity.SelectProduct;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SelectProductResponseDto {
    private Long selectProductId;

    private String selectProductName;

    private String selectProductDescription;

    private Long selectProductViewAmount;

    private String selectProductUrl;

    private Integer selectProductPrice;

    @Builder
    public SelectProductResponseDto(Long selectProductId, String selectProductName, String selectProductDescription, Long selectProductViewAmount, String selectProductUrl, Integer selectProductPrice) {
        this.selectProductId = selectProductId;
        this.selectProductName = selectProductName;
        this.selectProductDescription = selectProductDescription;
        this.selectProductViewAmount = selectProductViewAmount;
        this.selectProductUrl = selectProductUrl;
        this.selectProductPrice = selectProductPrice;
    }

    public static SelectProductResponseDto fromEntity(SelectProduct selectProduct) {
        return SelectProductResponseDto.builder()
                .selectProductId(selectProduct.getSelectProductId())
                .selectProductName(selectProduct.getSelectProductName())
                .selectProductDescription(selectProduct.getSelectProductDescription())
                .selectProductViewAmount(selectProduct.getSelectProductViewAmount())
                .selectProductUrl(selectProduct.getSelectProductUrl())
                .selectProductPrice(selectProduct.getSelectProductPrice())
                .build();
    }
}
