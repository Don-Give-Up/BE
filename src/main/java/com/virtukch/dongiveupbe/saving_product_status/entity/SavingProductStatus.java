package com.virtukch.dongiveupbe.saving_product_status.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SavingProductStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long savingProductStatusId;

    private Long savingProductId;

    private Double savingProductStatusRate;

    private Long round;
}
