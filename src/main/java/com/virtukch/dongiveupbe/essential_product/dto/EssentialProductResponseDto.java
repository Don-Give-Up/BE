package com.virtukch.dongiveupbe.essential_product.dto;

import com.virtukch.dongiveupbe.essential_product.entity.EssentialProduct;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EssentialProductResponseDto {
    @Schema(description = "필수 상품 ID")
    private Long essentialProductId;
    @Schema(description = "필수 상품 이름")
    private String essentialProductName;
    @Schema(description = "필수 상품 회복량")
    private Long essentialProductHp;
    @Schema(description = "필수 상품 설명")
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
