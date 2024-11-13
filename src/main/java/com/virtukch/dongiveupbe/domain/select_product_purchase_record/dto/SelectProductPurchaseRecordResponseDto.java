package com.virtukch.dongiveupbe.domain.select_product_purchase_record.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SelectProductPurchaseRecordResponseDto {
    private Long selectProductPurchaseRecordId;
    private String selectProductName;
    private Long gameMemberId;
    private Long selectProductPurchaseAmount;
    private Integer productTotalPrice;

}
