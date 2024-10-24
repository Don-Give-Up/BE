package com.virtukch.dongiveupbe.essential_product_status.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class EssentialProductStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long essentialProductStatusId;

    private Long essentialProductId;

    private Long roundId;

    private Long essentialProductStatusPrice;

    private Long essentialProductAmount;

    public EssentialProductStatus(Long essentialProductId, Long roundId, Long essentialProductStatusPrice, Long essentialProductAmount) {
        this.essentialProductId = essentialProductId;
        this.roundId = roundId;
        this.essentialProductStatusPrice = essentialProductStatusPrice;
        this.essentialProductAmount = essentialProductAmount;
    }
}