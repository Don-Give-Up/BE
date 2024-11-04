package com.virtukch.dongiveupbe.domain.stock.repository;

import com.virtukch.dongiveupbe.domain.stock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
