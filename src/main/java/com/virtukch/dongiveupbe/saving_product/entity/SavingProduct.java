package com.virtukch.dongiveupbe.saving_product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class SavingProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long savingProductId;

    private String savingProductName;
}