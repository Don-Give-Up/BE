package com.virtukch.dongiveupbe.essential_product_purchase_record.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class EssentialProductPurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long essentialProductPurchaseRecordId;

    private Long essentialProductStatusId;

    private Long gameMemberId;

    private Long essentialProductPurchaseAmount;
}
