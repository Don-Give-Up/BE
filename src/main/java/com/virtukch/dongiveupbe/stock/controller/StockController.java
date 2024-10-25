package com.virtukch.dongiveupbe.stock.controller;

import com.virtukch.dongiveupbe.stock.entity.Stock;
import com.virtukch.dongiveupbe.stock.service.StockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stocks")
@Tag(name = "Stock API", description = "주식 정보 조회를 위한 API")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{stockId}")
    @Operation(summary = "주식 정보 조회", description = "주식 ID를 통해 주식 정보를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "주식 정보 조회 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Stock.class))),
            @ApiResponse(responseCode = "404", description = "해당 ID의 주식을 찾을 수 없음")
    })
    public Stock getStock(@PathVariable Long stockId) {
        return stockService.findById(stockId);
    }
}
