package com.virtukch.dongiveupbe.stock_status.service;

import com.virtukch.dongiveupbe.essential_product.exception.EntityNotFoundException;
import com.virtukch.dongiveupbe.stock_status.entity.StockStatus;
import com.virtukch.dongiveupbe.stock_status.repository.StockStatusRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockStatusService {
    private final StockStatusRepository stockStatusRepository;

    public StockStatusService(StockStatusRepository stockStatusRepository) {
        this.stockStatusRepository = stockStatusRepository;
    }

    @Transactional(readOnly = true)
    public StockStatus findById(Long stockStatusId) {
        return stockStatusRepository.findById(stockStatusId)
                .orElseThrow(() -> new EntityNotFoundException("해당 ID의 StockStatus를 찾을 수 없습니다 "+ stockStatusId));
    }
}
