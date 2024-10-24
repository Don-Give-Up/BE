package com.virtukch.dongiveupbe.essential_product_purchase_record.entity;

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
public class EssentialProductPurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long essentialProductPurchaseRecordId;

    private Long essentialProductStatusId;

    private Long gameMemberId;

    private Long essentialProductPurchaseAmount;

    @Builder
    public EssentialProductPurchaseRecord(Long essentialProductStatusId, Long gameMemberId, Long essentialProductPurchaseAmount) {
        this.essentialProductStatusId = essentialProductStatusId;
        this.gameMemberId = gameMemberId;
        this.essentialProductPurchaseAmount = essentialProductPurchaseAmount;
    }
}
