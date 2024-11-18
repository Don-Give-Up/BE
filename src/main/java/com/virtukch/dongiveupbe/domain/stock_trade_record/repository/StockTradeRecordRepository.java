package com.virtukch.dongiveupbe.domain.stock_trade_record.repository;

import com.virtukch.dongiveupbe.domain.stock_trade_record.dto.StockTradeRecordResponseDto;
import com.virtukch.dongiveupbe.domain.stock_trade_record.entity.StockTradeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockTradeRecordRepository extends JpaRepository<StockTradeRecord, Long> {

    @Query("SELECT new com.virtukch.dongiveupbe.domain.stock_trade_record.dto.StockTradeRecordResponseDto(" +
            "str.stockTradeRecordId, str.gameMemberId, str.stockTradeRecordAmount, str.tradeType, s.stockName, " +
            "str.stockTotalPrice) " +
            "FROM StockTradeRecord str JOIN Stock s ON str.stockId = s.stockId WHERE str.gameMemberId = :gameMemberId")
    List<StockTradeRecordResponseDto> findTradeRecordsWithStockNameByGameMemberId(@Param("gameMemberId") Long gameMemberId);

    @Query("SELECT new com.virtukch.dongiveupbe.domain.stock_trade_record.dto.StockTradeRecordResponseDto(" +
            "str.stockTradeRecordId, str.gameMemberId, str.stockTradeRecordAmount, str.tradeType, s.stockName, " +
            "str.stockTotalPrice) " +
            "FROM StockTradeRecord str JOIN Stock s ON str.stockId = s.stockId")
    List<StockTradeRecordResponseDto> findAllTradeRecordsWithStockName();


}
