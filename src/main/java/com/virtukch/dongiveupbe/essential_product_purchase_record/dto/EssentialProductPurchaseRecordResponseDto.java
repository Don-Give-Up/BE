package com.virtukch.dongiveupbe.essential_product_purchase_record.dto;

import com.virtukch.dongiveupbe.essential_product_purchase_record.entity.EssentialProductPurchaseRecord;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EssentialProductPurchaseRecordResponseDto {

    private Long essentialProductPurchaseRecordId;
    private Long essentialProductStatusId;
    private Long gameMemberId;
    private Long essentialProductPurchaseAmount;

    @Builder
    public EssentialProductPurchaseRecordResponseDto(Long essentialProductPurchaseRecordId, Long essentialProductStatusId, Long gameMemberId, Long essentialProductPurchaseAmount) {
        this.essentialProductPurchaseRecordId = essentialProductPurchaseRecordId;
        this.essentialProductStatusId = essentialProductStatusId;
        this.gameMemberId = gameMemberId;
        this.essentialProductPurchaseAmount = essentialProductPurchaseAmount;
    }

    public static EssentialProductPurchaseRecordResponseDto fromEntity(EssentialProductPurchaseRecord essentialProductPurchaseRecord) {
        return EssentialProductPurchaseRecordResponseDto.builder()
                .essentialProductPurchaseRecordId(essentialProductPurchaseRecord.getEssentialProductPurchaseRecordId())
                .essentialProductStatusId(essentialProductPurchaseRecord.getEssentialProductStatusId())
                .gameMemberId(essentialProductPurchaseRecord.getGameMemberId())
                .essentialProductPurchaseAmount(essentialProductPurchaseRecord.getEssentialProductPurchaseAmount())
                .build();
    }
}
