package com.virtukch.dongiveupbe.domain.stock_trade_record.dto;

import com.virtukch.dongiveupbe.domain.stock_trade_record.entity.BuyOrSell;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StockTradeRecordRequestDto {

    private Long stockId;
    private Long gameMemberId;
    private Long stockTradeRecordAmount;
    private BuyOrSell tradeType;

    @Builder
    public StockTradeRecordRequestDto(Long stockId, Long gameMemberId, Long stockTradeRecordAmount, BuyOrSell tradeType) {
        this.stockId = stockId;
        this.gameMemberId = gameMemberId;
        this.stockTradeRecordAmount = stockTradeRecordAmount;
        this.tradeType = tradeType;
    }
}
