package com.virtukch.dongiveupbe.stock_trade_record.entity;

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
public class StockTradeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockTradeRecordId;

    private Long stockStatusId;

    private Long gameMemberId;

    private Long stockTradeRecordAmount;

    private BuyOrSell tradeType;

    @Builder

    public StockTradeRecord(Long stockStatusId, Long gameMemberId, Long stockTradeRecordAmount, BuyOrSell tradeType) {
        this.stockStatusId = stockStatusId;
        this.gameMemberId = gameMemberId;
        this.stockTradeRecordAmount = stockTradeRecordAmount;
        this.tradeType = tradeType;
    }
}