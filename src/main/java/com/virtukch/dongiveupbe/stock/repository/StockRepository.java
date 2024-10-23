package com.virtukch.dongiveupbe.stock.repository;

import com.virtukch.dongiveupbe.stock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
