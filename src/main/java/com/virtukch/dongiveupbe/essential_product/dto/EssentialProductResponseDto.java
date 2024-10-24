package com.virtukch.dongiveupbe.essential_product.dto;

import com.virtukch.dongiveupbe.essential_product.entity.EssentialProduct;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EssentialProductResponseDto {
    private Long essentialProductId;
    private String essentialProductName;
    private Long essentialProductHp;
    private String essentialProductDescription;

    public static EssentialProductResponseDto fromEntity(EssentialProduct product) {
        return EssentialProductResponseDto.builder()
                .essentialProductId(product.getEssentialProductId())
                .essentialProductName(product.getEssentialProductName())
                .essentialProductHp(product.getEssentialProductHp())
                .essentialProductDescription(product.getEssentialProductDescription())
                .build();
    }
}
