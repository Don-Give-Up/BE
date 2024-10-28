package com.virtukch.dongiveupbe.stock.controller;

import com.virtukch.dongiveupbe.stock.entity.Stock;
import com.virtukch.dongiveupbe.stock.service.StockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stocks")
@Tag(name = "주식 API", description = "주식 정보 조회를 위한 API")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{stockId}")
    @Operation(summary = "주식 정보 조회", description = "주식 ID를 통해 주식 정보를 조회합니다.")
    public Stock getStock(@PathVariable Long stockId) {
        return stockService.findById(stockId);
    }

    @GetMapping
    @Operation(summary = "주식 정보 전체 조회", description = "모든 주식의 아이디를 조회할 수 있습니다.")
    public List<Stock> findAll() {
        return stockService.findAll();
    }
}
