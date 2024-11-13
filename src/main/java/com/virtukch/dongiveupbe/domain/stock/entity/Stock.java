package com.virtukch.dongiveupbe.domain.stock.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;

    private String stockName;

    private Integer stockPrice;

    @Builder
    public Stock(String stockName, Integer stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
    }
}