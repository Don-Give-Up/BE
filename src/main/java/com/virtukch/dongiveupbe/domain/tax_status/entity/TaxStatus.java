package com.virtukch.dongiveupbe.domain.tax_status.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class TaxStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taxStatusId;

    private Long taxId;

    private Long roundId;

    private Double taxRate;

    public TaxStatus(Long taxId, Long roundId, Double taxRate) {
        this.taxId = taxId;
        this.roundId = roundId;
        this.taxRate = taxRate;
    }
}