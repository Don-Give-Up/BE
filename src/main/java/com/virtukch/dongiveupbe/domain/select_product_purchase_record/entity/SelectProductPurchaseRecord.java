package com.virtukch.dongiveupbe.domain.select_product_purchase_record.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class SelectProductPurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long selectProductPurchaseRecordId;

    private Long selectProductStatusId;

    private Long gameMemberId;

    private Long selectProductPurchaseAmount;
}