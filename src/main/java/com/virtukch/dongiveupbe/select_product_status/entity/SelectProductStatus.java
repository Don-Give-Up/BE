package com.virtukch.dongiveupbe.select_product_status.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}