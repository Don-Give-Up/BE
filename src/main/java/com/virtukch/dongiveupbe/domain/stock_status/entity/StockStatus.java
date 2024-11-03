package com.virtukch.dongiveupbe.domain.stock_status.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class StockStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockStatusId;

    private Long roundId;

    private Long stockId;

    private Long stockStatusCurrentPrice;

    public StockStatus(Long roundId, Long stockId, Long stockStatusCurrentPrice) {
        this.roundId = roundId;
        this.stockId = stockId;
        this.stockStatusCurrentPrice = stockStatusCurrentPrice;
    }
}
