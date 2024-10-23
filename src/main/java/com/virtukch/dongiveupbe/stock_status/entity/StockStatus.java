package com.virtukch.dongiveupbe.stock_status.entity;

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
    private Long stock_status_id;

    private Long round_id;

    private Long stock_id;

    private Long stock_status_current_price;

    public StockStatus(Long round_id, Long stock_id, Long stock_status_current_price) {
        this.round_id = round_id;
        this.stock_id = stock_id;
        this.stock_status_current_price = stock_status_current_price;
    }
}
