package com.virtukch.dongiveupbe.stock_trade_record.service;

import com.virtukch.dongiveupbe.game_member.dto.GameMemberResponseDto;
import com.virtukch.dongiveupbe.game_member.service.GameMemberService;
import com.virtukch.dongiveupbe.stock_status.entity.StockStatus;
import com.virtukch.dongiveupbe.stock_status.service.StockStatusService;
import com.virtukch.dongiveupbe.stock_trade_record.dto.StockTradeRecordRequestDto;
import com.virtukch.dongiveupbe.stock_trade_record.dto.StockTradeRecordResponseDto;
import com.virtukch.dongiveupbe.stock_trade_record.entity.StockTradeRecord;
import com.virtukch.dongiveupbe.stock_trade_record.repository.StockTradeRecordRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockTradeRecordService {

    private final StockTradeRecordRepository stockTradeRecordRepository;
    private final GameMemberService gameMemberService;
    private final StockStatusService stockStatusService;

    public StockTradeRecordService(StockTradeRecordRepository stockTradeRecordRepository, GameMemberService gameMemberService, StockStatusService stockStatusService) {
        this.stockTradeRecordRepository = stockTradeRecordRepository;
        this.gameMemberService = gameMemberService;
        this.stockStatusService = stockStatusService;
    }

    @Transactional
    public StockTradeRecordResponseDto  tradeStock(StockTradeRecordRequestDto requestDto) {
        StockStatus stockStatus = stockStatusService.findById(requestDto.getStockStatusId());

        GameMemberResponseDto gameMemberResponseDto = gameMemberService.findById(requestDto.getGameMemberId());

        StockTradeRecord stockTradeRecord = StockTradeRecord.builder()
                .stockStatusId(stockStatus.getStockStatusId())
                .gameMemberId(gameMemberResponseDto.getGameMemberId())
                .stockTradeRecordAmount(requestDto.getStockTradeRecordAmount())
                .tradeType(requestDto.getTradeType())
                .build();
        StockTradeRecord savedRecord = stockTradeRecordRepository.save(stockTradeRecord);
        return StockTradeRecordResponseDto.fromDto(savedRecord);
    }

    @Transactional(readOnly = true)
    public List<StockTradeRecordResponseDto> getALlTradeRecords() {
        return stockTradeRecordRepository.findAll().stream()
                .map(StockTradeRecordResponseDto::fromDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<StockTradeRecordResponseDto> getTradeRecordsByGameMemberId(Long gameMemberId) {
        return stockTradeRecordRepository.findByGameMemberId(gameMemberId).stream()
                .map(StockTradeRecordResponseDto::fromDto)
                .toList();
    }
}
