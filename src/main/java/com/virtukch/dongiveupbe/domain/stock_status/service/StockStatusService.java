package com.virtukch.dongiveupbe.domain.stock_status.service;

import com.virtukch.dongiveupbe.domain.essential_product.exception.EntityNotFoundException;
import com.virtukch.dongiveupbe.domain.stock_status.dto.StockStatusRequestDto;
import com.virtukch.dongiveupbe.domain.stock_status.repository.StockStatusRepository;
import com.virtukch.dongiveupbe.domain.stock_status.entity.StockStatus;
import com.virtukch.dongiveupbe.domain.stock.repository.StockRepository;
import com.virtukch.dongiveupbe.domain.stock.entity.Stock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockStatusService {
    private final StockStatusRepository stockStatusRepository;
    private final StockRepository stockRepository;

    public StockStatusService(StockStatusRepository stockStatusRepository, StockRepository stockRepository) {
        this.stockStatusRepository = stockStatusRepository;
        this.stockRepository = stockRepository;
    }

    @Transactional(readOnly = true)
    public StockStatusRequestDto findWithNameById(Long stockStatusId) {
        // StockStatus 조회
        StockStatus stockStatus = stockStatusRepository.findById(stockStatusId)
                .orElseThrow(() -> new EntityNotFoundException("해당 ID의 StockStatus를 찾을 수 없습니다: " + stockStatusId));

        // Stock 엔티티 조회 (stockStatus에서 직접 stockId를 사용하여 Stock 조회)
        Stock stock = stockRepository.findById(stockStatus.getStockId())
                .orElseThrow(() -> new EntityNotFoundException("해당 ID의 Stock을 찾을 수 없습니다: " + stockStatus.getStockId()));

        // StockStatusRequestDto 반환 (stockName 포함)
        return new StockStatusRequestDto(
                stockStatus.getStockStatusId(),
                stockStatus.getRoundId(),
                stockStatus.getStockStatusCurrentPrice(),
                stock.getStockName()  // Stock에서 stockName을 가져옴
        );
    }
}
