package com.virtukch.dongiveupbe.domain.essential_product_status.dto;

import com.virtukch.dongiveupbe.domain.essential_product_status.entity.EssentialProductStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EssentialProductStatusRequestDto {
    private Long essentialProductId;
    private Long roundId;
    private Long essentialProductStatusPrice;
    private Long essentialProductAmount;

    @Builder
    public EssentialProductStatusRequestDto(Long essentialProductId, Long roundId, Long essentialProductStatusPrice, Long essentialProductAmount) {
        this.essentialProductId = essentialProductId;
        this.roundId = roundId;
        this.essentialProductStatusPrice = essentialProductStatusPrice;
        this.essentialProductAmount = essentialProductAmount;
    }

    public EssentialProductStatus toEntity() {
        return EssentialProductStatus.builder()
                .essentialProductId(essentialProductId)
                .roundId(roundId)
                .essentialProductStatusPrice(essentialProductStatusPrice)
                .essentialProductAmount(essentialProductAmount)
                .build();
    }
}
