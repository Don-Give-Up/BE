package com.virtukch.dongiveupbe.domain.stock_status.repository;

import com.virtukch.dongiveupbe.domain.stock_status.entity.StockStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockStatusRepository extends JpaRepository<StockStatus, Long> {

    // stockStatusId로 StockStatus만 조회하는 메소드
}
