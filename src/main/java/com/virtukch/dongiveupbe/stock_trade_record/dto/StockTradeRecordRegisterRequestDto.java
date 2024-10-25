package com.virtukch.dongiveupbe.stock_trade_record.dto;

import com.virtukch.dongiveupbe.stock_trade_record.entity.BuyOrSell;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StockTradeRecordRegisterRequestDto {

    private Long stockStatusId;
    private Long gameMemberId;
    private Long stockTradeRecordAmount;
    private BuyOrSell tradeType;

    @Builder
    public StockTradeRecordRegisterRequestDto(Long stockStatusId, Long gameMemberId, Long stockTradeRecordAmount, BuyOrSell tradeType) {
        this.stockStatusId = stockStatusId;
        this.gameMemberId = gameMemberId;
        this.stockTradeRecordAmount = stockTradeRecordAmount;
        this.tradeType = tradeType;
    }
}
