package com.virtukch.dongiveupbe.saving_product_status.dto;

import com.virtukch.dongiveupbe.saving_product_status.entity.SavingProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SavingProductStatusResponseDto {

    private Long savingProductStatusId;

    private Long savingProductId;

    private Long roundId;

    private Double savingProductStatusRate;

    public static SavingProductStatusResponseDto fromEntity(
        SavingProductStatus savingProductStatus) {
        return SavingProductStatusResponseDto.builder()
            .savingProductStatusId(savingProductStatus.getSavingProductStatusId())
            .savingProductId(savingProductStatus.getSavingProductId())
            .roundId(savingProductStatus.getRoundId())
            .savingProductStatusRate(savingProductStatus.getSavingProductStatusRate())
            .build();
    }
}
