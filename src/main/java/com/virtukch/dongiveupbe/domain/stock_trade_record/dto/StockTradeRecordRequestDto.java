package com.virtukch.dongiveupbe.domain.stock_trade_record.dto;

import com.virtukch.dongiveupbe.domain.stock_trade_record.entity.BuyOrSell;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class StockTradeRecordRequestDto {

    private Long stockId;
    private Long gameId;
    @Hidden
    @Setter
    private Long gameMemberId;
    private Long stockTradeRecordAmount;
    private BuyOrSell tradeType;


    @Builder
    public StockTradeRecordRequestDto(Long stockId, Long gameId, Long gameMemberId, Long stockTradeRecordAmount, BuyOrSell tradeType) {
        this.stockId = stockId;
        this.gameId = gameId;
        this.gameMemberId = gameMemberId;
        this.stockTradeRecordAmount = stockTradeRecordAmount;
        this.tradeType = tradeType;
    }
}
