package com.virtukch.dongiveupbe.domain.select_product_purchase_record.dto;

import com.virtukch.dongiveupbe.domain.select_product_purchase_record.entity.SelectProductPurchaseRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SelectProductPurchaseRecordResponseDto {
    private Long gameId;
    private Long selectProductPurchaseRecordId;
    private String selectProductName;
    private Long gameMemberId;
    private Long selectProductPurchaseAmount;
    private Integer productTotalPrice;


    public static SelectProductPurchaseRecordResponseDto fromEntity(SelectProductPurchaseRecord entity, String selectProductName, Long gameId) {
        return new SelectProductPurchaseRecordResponseDto(
                entity.getGameId(),
                entity.getSelectProductPurchaseRecordId(),
                selectProductName,
                entity.getGameMemberId(),
                entity.getSelectProductPurchaseAmount(),
                entity.getProductTotalPrice()
        );
    }

}
