package com.virtukch.dongiveupbe.stock_trade_record.controller;

import com.virtukch.dongiveupbe.stock_trade_record.dto.StockTradeRecordRegisterRequestDto;
import com.virtukch.dongiveupbe.stock_trade_record.dto.StockTradeRecordResponseDto;
import com.virtukch.dongiveupbe.stock_trade_record.service.StockTradeRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stock-trade-records")
@Tag(name = "Stock Trade Records", description = "주식 거래 내역 관리 API")
public class StockTradeRecordController {
    private final StockTradeRecordService stockTradeRecordService;

    public StockTradeRecordController(StockTradeRecordService stockTradeRecordService) {
        this.stockTradeRecordService = stockTradeRecordService;
    }

    @GetMapping
    @Operation(summary = "전체 거래 내역 조회", description = "전체 주식 거래 내역을 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "전체 주식 거래 내역 조회 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StockTradeRecordResponseDto.class)))
    })
    public ResponseEntity<List<StockTradeRecordResponseDto>> getAllTradeRecords() {
        List<StockTradeRecordResponseDto> tradeRecords = stockTradeRecordService.getALlTradeRecords();
        return ResponseEntity.ok(tradeRecords);
    }

    @GetMapping("/gameMember/{gameMemberId}")
    @Operation(summary = "특정 멤버의 거래 내역 조회", description = "특정 게임 멤버의 주식 거래 내역을 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "특정 게임 멤버의 거래 내역 조회 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StockTradeRecordResponseDto.class)))
    })
    public ResponseEntity<List<StockTradeRecordResponseDto>> getTradeRecordsByMemberId(@PathVariable Long gameMemberId) {
        List<StockTradeRecordResponseDto> tradeRecords = stockTradeRecordService.getTradeRecordsByGameMemberId(gameMemberId);
        return ResponseEntity.ok(tradeRecords);
    }

    @PostMapping
    @Operation(summary = "주식 거래 내역 생성", description = "새로운 주식 거래 기록을 생성합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "주식 거래 내역 생성 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StockTradeRecordRegisterRequestDto.class)))
    })
    public ResponseEntity<StockTradeRecordResponseDto> createTradeRecord(@RequestBody StockTradeRecordRegisterRequestDto requestDto) {
        StockTradeRecordResponseDto responseDto = stockTradeRecordService.tradeStock(requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
