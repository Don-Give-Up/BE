package com.virtukch.dongiveupbe.select_product.entity;

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
public class SelectProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long selectProductId;

    private String selectProductName;

    private String selectProductDescription;

    private Long selectProductViewAmount;

    private String selectProductUrl;

    @Builder

    public SelectProduct(Long selectProductId, String selectProductName, String selectProductDescription, Long selectProductViewAmount, String selectProductUrl) {
        this.selectProductId = selectProductId;
        this.selectProductName = selectProductName;
        this.selectProductDescription = selectProductDescription;
        this.selectProductViewAmount = selectProductViewAmount;
        this.selectProductUrl = selectProductUrl;
    }
}