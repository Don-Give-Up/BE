package com.virtukch.dongiveupbe.domain.select_product_purchase_record.dto;

import com.virtukch.dongiveupbe.domain.select_product_purchase_record.entity.SelectProductPurchaseRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SelectProductPurchaseRecordRequestDto {
    private Long selectProductStatusId;
    private Long gameMemberId;
    private Long selectProductPurchaseAmount;

    // DTO에서 엔티티로 변환
    public SelectProductPurchaseRecord toEntity() {
        return SelectProductPurchaseRecord.builder()
                .selectProductStatusId(this.selectProductStatusId)
                .gameMemberId(this.gameMemberId)
                .selectProductPurchaseAmount(this.selectProductPurchaseAmount)
                .build();
    }
}
