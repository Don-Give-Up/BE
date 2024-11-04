package com.virtukch.dongiveupbe.domain.select_product_status.entity;

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
public class SelectProductStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long selectProductStatusId;

    private Long roundId;

    private Long selectProductId;

    private Long selectProductAmount;

    private Long selectProductPrice;

    @Builder
    public SelectProductStatus(Long roundId, Long selectProductId, Long selectProductAmount, Long selectProductPrice) {
        this.roundId = roundId;
        this.selectProductId = selectProductId;
        this.selectProductAmount = selectProductAmount;
        this.selectProductPrice = selectProductPrice;
    }
}