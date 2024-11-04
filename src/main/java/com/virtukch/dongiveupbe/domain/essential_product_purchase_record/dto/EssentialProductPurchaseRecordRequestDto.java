package com.virtukch.dongiveupbe.domain.essential_product_purchase_record.dto;

import com.virtukch.dongiveupbe.domain.essential_product_purchase_record.entity.EssentialProductPurchaseRecord;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EssentialProductPurchaseRecordRequestDto {

    private Long essentialProductStatusId;
    private Long gameMemberId;
    private Long essentialProductPurchaseAmount;

    @Builder
    public EssentialProductPurchaseRecordRequestDto(Long essentialProductStatusId, Long gameMemberId, Long essentialProductPurchaseAmount) {
        this.essentialProductStatusId = essentialProductStatusId;
        this.gameMemberId = gameMemberId;
        this.essentialProductPurchaseAmount = essentialProductPurchaseAmount;
    }

    public EssentialProductPurchaseRecord toEntity() {
        return EssentialProductPurchaseRecord.builder()
                .essentialProductStatusId(essentialProductStatusId)
                .gameMemberId(gameMemberId)
                .essentialProductPurchaseAmount(essentialProductPurchaseAmount)
                .build();
    }
}
