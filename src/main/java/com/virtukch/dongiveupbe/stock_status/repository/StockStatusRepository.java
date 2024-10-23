package com.virtukch.dongiveupbe.stock_status.repository;

import com.virtukch.dongiveupbe.stock_status.entity.StockStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockStatusRepository extends JpaRepository<StockStatus, Long> {

    // 특정 라운드에서의 모든 주식 상태 조회
    @Query("SELECT ss FROM StockStatus ss WHERE ss.round_id= :roundId")
    List<StockStatus> findAllByRoundId(@Param("roundId") Long roundId);

    // 특정 주식의 특정 라운드에서의 상태 조회
    @Query("SELECT ss FROM StockStatus ss WHERE ss.stock_id = :stockId AND ss.round_id = :roundId")
    StockStatus findByStockIdAndRoundId(@Param("stockId") Long stockId, @Param("roundId") Long roundId);
}
