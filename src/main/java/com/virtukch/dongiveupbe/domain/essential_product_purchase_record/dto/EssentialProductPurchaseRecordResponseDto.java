package com.virtukch.dongiveupbe.domain.essential_product_purchase_record.dto;

import com.virtukch.dongiveupbe.domain.essential_product_purchase_record.entity.EssentialProductPurchaseRecord;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EssentialProductPurchaseRecordResponseDto {

    @Schema(description = "필수 상품 구매 ID")
    private Long essentialProductPurchaseRecordId;
    @Schema(description = "필수 상품 상태 ID")
    private Long essentialProductStatusId;
    @Schema(description = "게임 멤버 ID")
    private Long gameMemberId;
    @Schema(description = "필수 상품 구매 갯수")
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
