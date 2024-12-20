package com.virtukch.dongiveupbe.domain.essential_product.dto;

import com.virtukch.dongiveupbe.domain.essential_product.entity.EssentialProduct;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EssentialProductRequestDto {
    private String essentialProductName;
    private Long essentialProductHp;
    private String essentialProductDescription;

    public EssentialProduct toEntity() {
        return EssentialProduct.builder()
                .essentialProductName(this.essentialProductName)
                .essentialProductHp(this.essentialProductHp)
                .essentialProductDescription(this.essentialProductDescription)
                .build();
    }
}
