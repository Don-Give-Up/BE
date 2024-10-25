package com.virtukch.dongiveupbe.stock_trade_record.controller;

import com.virtukch.dongiveupbe.stock_trade_record.dto.StockTradeRecordRegisterRequestDto;
import com.virtukch.dongiveupbe.stock_trade_record.dto.StockTradeRecordResponseDto;
import com.virtukch.dongiveupbe.stock_trade_record.service.StockTradeRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stock-trade-records")
public class StockTradeRecordController {
    private final StockTradeRecordService stockTradeRecordService;

    public StockTradeRecordController(StockTradeRecordService stockTradeRecordService) {
        this.stockTradeRecordService = stockTradeRecordService;
    }

    @GetMapping
    public ResponseEntity<List<StockTradeRecordResponseDto>> getAllTradeRecords() {
        List<StockTradeRecordResponseDto> tradeRecords = stockTradeRecordService.getALlTradeRecords();
        return ResponseEntity.ok(tradeRecords);
    }

    @GetMapping("/gameMember/{gameMemberId}")
    public ResponseEntity<List<StockTradeRecordResponseDto>> getTradeRecordsByMemberId(@PathVariable Long gameMemberId) {
        List<StockTradeRecordResponseDto> tradeRecords = stockTradeRecordService.getTradeRecordsByGameMemberId(gameMemberId);
        return ResponseEntity.ok(tradeRecords);
    }

    @PostMapping
    public ResponseEntity<Void> createTradeRecord(@RequestBody StockTradeRecordRegisterRequestDto requestDto) {
        stockTradeRecordService.tradeStock(requestDto);
        return ResponseEntity.ok().build();
    }
}
