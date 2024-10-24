package com.virtukch.dongiveupbe.essential_product_status.dto;

import com.virtukch.dongiveupbe.essential_product_status.entity.EssentialProductStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EssentialProductStatusResponseDto {

    private Long essentialProductStatusId;
    private Long essentialProductId;
    private Long roundId;
    private Long essentialProductStatusPrice;
    private Long essentialProductAmount;

    @Builder
    public EssentialProductStatusResponseDto(Long essentialProductStatusId, Long essentialProductId, Long roundId, Long essentialProductStatusPrice, Long essentialProductAmount) {
        this.essentialProductStatusId = essentialProductStatusId;
        this.essentialProductId = essentialProductId;
        this.roundId = roundId;
        this.essentialProductStatusPrice = essentialProductStatusPrice;
        this.essentialProductAmount = essentialProductAmount;
    }

    public static EssentialProductStatusResponseDto fromEntity(EssentialProductStatus essentialProductStatus) {
        return EssentialProductStatusResponseDto.builder()
                .essentialProductStatusId(essentialProductStatus.getEssentialProductStatusId())
                .essentialProductId(essentialProductStatus.getEssentialProductId())
                .roundId(essentialProductStatus.getRoundId())
                .essentialProductStatusPrice(essentialProductStatus.getEssentialProductStatusPrice())
                .essentialProductAmount(essentialProductStatus.getEssentialProductAmount())
                .build();
    }
}
