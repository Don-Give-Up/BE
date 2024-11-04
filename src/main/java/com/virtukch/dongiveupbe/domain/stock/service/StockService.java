package com.virtukch.dongiveupbe.domain.stock.service;

import com.virtukch.dongiveupbe.domain.essential_product.exception.EntityNotFoundException;
import com.virtukch.dongiveupbe.domain.stock.entity.Stock;
import com.virtukch.dongiveupbe.domain.stock.repository.StockRepository;
import java.util.List;
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
        return stock.orElseThrow(() -> new EntityNotFoundException("주식을 찾을 수 없어요. ID: " + id));
    }

    public List<Stock> findAll() {
        return stockRepository.findAll();
    }
}
