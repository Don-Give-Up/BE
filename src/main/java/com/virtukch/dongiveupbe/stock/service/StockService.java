package com.virtukch.dongiveupbe.stock.service;

import com.virtukch.dongiveupbe.stock.entity.Stock;
import com.virtukch.dongiveupbe.stock.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock findById(Long id) {
        Optional<Stock> stock = stockRepository.findById(id);
        return stock.orElseThrow(() -> new IllegalArgumentException("주식을 찾을 수 없어요."));
    }

}
