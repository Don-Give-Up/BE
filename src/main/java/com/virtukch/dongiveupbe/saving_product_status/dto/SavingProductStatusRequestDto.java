package com.virtukch.dongiveupbe.saving_product_status.dto;

import com.virtukch.dongiveupbe.saving_product_status.entity.SavingProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SavingProductStatusRequestDto {

    private Long savingProductId;

    private Long roundId;

    private Double savingProductStatusRate;

    public static SavingProductStatus toEntity(
        SavingProductStatusRequestDto savingProductStatusRequestDto) {
        return SavingProductStatus.builder()
            .savingProductId(savingProductStatusRequestDto.getSavingProductId())
            .roundId(savingProductStatusRequestDto.getRoundId())
            .savingProductStatusRate(savingProductStatusRequestDto.getSavingProductStatusRate())
            .build();
    }
}
