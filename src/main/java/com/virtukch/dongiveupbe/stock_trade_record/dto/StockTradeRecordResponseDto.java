package com.virtukch.dongiveupbe.stock_trade_record.dto;

import com.virtukch.dongiveupbe.stock_trade_record.entity.BuyOrSell;
import com.virtukch.dongiveupbe.stock_trade_record.entity.StockTradeRecord;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StockTradeRecordResponseDto {
    private Long stockTradeRecordId;
    private Long stockStatusId;
    private Long gameMemberId;
    private Long stockTradeRecordAmount;
    private BuyOrSell tradeType;

    @Builder
    public StockTradeRecordResponseDto(Long stockTradeRecordId, Long stockStatusId, Long gameMemberId, Long stockTradeRecordAmount, BuyOrSell tradeType) {
        this.stockTradeRecordId = stockTradeRecordId;
        this.stockStatusId = stockStatusId;
        this.gameMemberId = gameMemberId;
        this.stockTradeRecordAmount = stockTradeRecordAmount;
        this.tradeType = tradeType;
    }

    public static StockTradeRecordResponseDto fromDto(StockTradeRecord stockTradeRecord) {
        return StockTradeRecordResponseDto.builder()
                .stockTradeRecordId(stockTradeRecord.getStockTradeRecordId())
                .stockStatusId(stockTradeRecord.getStockStatusId())
                .gameMemberId(stockTradeRecord.getGameMemberId())
                .stockTradeRecordAmount(stockTradeRecord.getStockTradeRecordAmount())
                .tradeType(stockTradeRecord.getTradeType())
                .build();
    }
}
