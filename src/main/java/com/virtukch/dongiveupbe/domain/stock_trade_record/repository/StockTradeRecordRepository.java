package com.virtukch.dongiveupbe.domain.stock_trade_record.repository;

import com.virtukch.dongiveupbe.domain.stock_trade_record.entity.StockTradeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockTradeRecordRepository extends JpaRepository<StockTradeRecord, Long> {

    List<StockTradeRecord> findByGameMemberId(Long gameMemberId);

}
