package com.virtukch.dongiveupbe.domain.select_product_purchase_record.dto;

import com.virtukch.dongiveupbe.domain.select_product_purchase_record.entity.SelectProductPurchaseRecord;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SelectProductPurchaseRecordRequestDto {
    private Long gameId;
    private Long selectProductId;
    @Hidden
    @Setter
    private Long gameMemberId;
    private Long selectProductPurchaseAmount;

    // DTO에서 엔티티로 변환
    public SelectProductPurchaseRecord toEntity() {
        return SelectProductPurchaseRecord.builder()
                .selectProductId(this.selectProductId)
                .gameMemberId(this.gameMemberId)
                .selectProductPurchaseAmount(this.selectProductPurchaseAmount)
                .build();
    }
}
