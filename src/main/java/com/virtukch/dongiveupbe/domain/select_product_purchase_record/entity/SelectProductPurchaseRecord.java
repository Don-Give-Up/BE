package com.virtukch.dongiveupbe.domain.select_product_purchase_record.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class SelectProductPurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long selectProductPurchaseRecordId;

    private Long selectProductStatusId;
    private Long gameMemberId;
    private Long selectProductPurchaseAmount;

    @Builder
    public SelectProductPurchaseRecord(Long selectProductStatusId, Long gameMemberId, Long selectProductPurchaseAmount) {
        this.selectProductStatusId = selectProductStatusId;
        this.gameMemberId = gameMemberId;
        this.selectProductPurchaseAmount = selectProductPurchaseAmount;
    }
}
