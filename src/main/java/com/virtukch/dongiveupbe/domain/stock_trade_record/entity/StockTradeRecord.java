package com.virtukch.dongiveupbe.domain.stock_trade_record.entity;

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

    private Long stockId;

    private Long gameMemberId;

    private Long stockTradeRecordAmount;

    private BuyOrSell tradeType;

    private Integer stockTotalPrice;

    @Builder
    public StockTradeRecord(Long stockId, Long gameMemberId, Long stockTradeRecordAmount, BuyOrSell tradeType, Integer stockTotalPrice) {
        this.stockId = stockId;
        this.gameMemberId = gameMemberId;
        this.stockTradeRecordAmount = stockTradeRecordAmount;
        this.tradeType = tradeType;
        this.stockTotalPrice = stockTotalPrice;
    }
}
