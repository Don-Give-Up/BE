package com.virtukch.dongiveupbe.stock_trade_record.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StockTradeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockTradeRecordId;

    private Long stockStatusId;

    private Long gameMemberId;

    private Long stockTradeRecordAmount;

    private BuyOrSell stockTradeRecordIsBuyOrSell;
}