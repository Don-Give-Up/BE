package com.virtukch.dongiveupbe.domain.stock_trade_record.service;

import com.virtukch.dongiveupbe.domain.essential_product.exception.EntityNotFoundException;
import com.virtukch.dongiveupbe.domain.game_member.dto.GameMemberResponseDto;
import com.virtukch.dongiveupbe.domain.game_member.service.GameMemberService;
import com.virtukch.dongiveupbe.domain.stock.entity.Stock; // StockService를 사용하여 Stock을 조회
import com.virtukch.dongiveupbe.domain.stock.service.StockService; // 추가된 부분: StockService
import com.virtukch.dongiveupbe.domain.stock_trade_record.dto.StockTradeRecordResponseDto;
import com.virtukch.dongiveupbe.domain.stock_trade_record.entity.StockTradeRecord;
import com.virtukch.dongiveupbe.domain.stock_trade_record.dto.StockTradeRecordRequestDto;
import com.virtukch.dongiveupbe.domain.stock_trade_record.repository.StockTradeRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StockTradeRecordService {

    private final StockTradeRecordRepository stockTradeRecordRepository;
    private final GameMemberService gameMemberService;
    private final StockService stockService; // 추가된 부분: StockService

    public StockTradeRecordService(StockTradeRecordRepository stockTradeRecordRepository, GameMemberService gameMemberService, StockService stockService) {
        this.stockTradeRecordRepository = stockTradeRecordRepository;
        this.gameMemberService = gameMemberService;
        this.stockService = stockService; // StockService 주입
    }

    @Transactional
    public StockTradeRecordResponseDto tradeStock(StockTradeRecordRequestDto requestDto) {
        // 게임 멤버 검증
        GameMemberResponseDto gameMemberResponse = gameMemberService.findById(requestDto.getGameMemberId());
        if (gameMemberResponse == null) {
            throw new EntityNotFoundException("게임에 참가하지 않은 멤버입니다. gameMemberId: " + requestDto.getGameMemberId());
        }

        // StockService를 통해 Stock을 가져옵니다.
        Stock stock = stockService.findStockById(requestDto.getStockId())
                .orElseThrow(() -> new EntityNotFoundException("해당 ID의 Stock을 찾을 수 없습니다: " + requestDto.getStockId()));

        // 총 거래 금액 계산
        int totalPrice = stock.getStockPrice() * requestDto.getStockTradeRecordAmount().intValue();

        // 거래 기록 생성
        StockTradeRecord stockTradeRecord = StockTradeRecord.builder()
                .stockId(stock.getStockId())
                .gameMemberId(requestDto.getGameMemberId())
                .stockTradeRecordAmount(requestDto.getStockTradeRecordAmount())
                .tradeType(requestDto.getTradeType())
                .stockTotalPrice(totalPrice)
                .build();

        // 거래 기록 저장
        StockTradeRecord savedRecord = stockTradeRecordRepository.save(stockTradeRecord);

        // stockName을 포함한 DTO 반환
        return new StockTradeRecordResponseDto(
                savedRecord.getStockTradeRecordId(),
                savedRecord.getGameMemberId(),
                savedRecord.getStockTradeRecordAmount(),
                savedRecord.getTradeType(),
                stock.getStockName(),
                savedRecord.getStockTotalPrice()
        );
    }

    @Transactional(readOnly = true)
    public List<StockTradeRecordResponseDto> getAllTradeRecords() {
        return stockTradeRecordRepository.findAllTradeRecordsWithStockName();
    }

    @Transactional(readOnly = true)
    public List<StockTradeRecordResponseDto> getTradeRecordsByGameMemberId(Long gameMemberId) {
        return stockTradeRecordRepository.findTradeRecordsWithStockNameByGameMemberId(gameMemberId);
    }
}
