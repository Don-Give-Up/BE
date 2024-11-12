package com.virtukch.dongiveupbe.domain.stock_trade_record.dto;

import com.virtukch.dongiveupbe.domain.stock_trade_record.entity.StockTradeRecord;
import com.virtukch.dongiveupbe.domain.stock_trade_record.entity.BuyOrSell;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StockTradeRecordResponseDto {
    @Schema(description = "주식 거래 기록 ID")
    private Long stockTradeRecordId;

    @Schema(description = "게임 멤버 ID")
    private Long gameMemberId;

    @Schema(description = "주식 거래 수량")
    private Long stockTradeRecordAmount;

    @Schema(description = "거래 유형 (BUY or SELL)")
    private BuyOrSell tradeType;

    @Schema(description = "주식 이름")
    private String stockName;

    @Builder
    public StockTradeRecordResponseDto(Long stockTradeRecordId, Long gameMemberId, Long stockTradeRecordAmount, BuyOrSell tradeType, String stockName) {
        this.stockTradeRecordId = stockTradeRecordId;
        this.gameMemberId = gameMemberId;
        this.stockTradeRecordAmount = stockTradeRecordAmount;
        this.tradeType = tradeType;
        this.stockName = stockName;
    }

    public static StockTradeRecordResponseDto fromDto(StockTradeRecord stockTradeRecord, String stockName) {
        return StockTradeRecordResponseDto.builder()
                .stockTradeRecordId(stockTradeRecord.getStockTradeRecordId())
                .gameMemberId(stockTradeRecord.getGameMemberId())
                .stockTradeRecordAmount(stockTradeRecord.getStockTradeRecordAmount())
                .tradeType(stockTradeRecord.getTradeType())
                .stockName(stockName)
                .build();
    }
}
