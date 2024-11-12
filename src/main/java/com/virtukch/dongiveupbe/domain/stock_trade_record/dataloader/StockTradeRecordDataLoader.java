package com.virtukch.dongiveupbe.domain.stock_trade_record.dataloader;

import com.virtukch.dongiveupbe.domain.stock_trade_record.entity.StockTradeRecord;
import com.virtukch.dongiveupbe.domain.stock_trade_record.entity.BuyOrSell;
import com.virtukch.dongiveupbe.domain.stock_trade_record.repository.StockTradeRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
@Profile({"localCreate", "devCreate", "prodCreate"})
public class StockTradeRecordDataLoader implements CommandLineRunner {

    private final StockTradeRecordRepository stockTradeRecordRepository;

    public StockTradeRecordDataLoader(StockTradeRecordRepository stockTradeRecordRepository) {
        this.stockTradeRecordRepository = stockTradeRecordRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadStockTradeRecords();
    }

    private void loadStockTradeRecords() {
        if (stockTradeRecordRepository.count() == 0) {
            Long memberId = 6L;
            BuyOrSell tradeType = BuyOrSell.BUY;

            // 주식 구매 이력
            List<StockTradeRecord> stockTradeRecords = Arrays.asList(
                    new StockTradeRecord(1L, memberId, 4L, tradeType), // 주식 ID 1
                    new StockTradeRecord(2L, memberId, 3L, tradeType), // 주식 ID 2
                    new StockTradeRecord(3L, memberId, 2L, tradeType), // 주식 ID 3
                    new StockTradeRecord(4L, memberId, 1L, tradeType), // 주식 ID 4
                    new StockTradeRecord(5L, memberId, 2L, tradeType), // 주식 ID 5
                    new StockTradeRecord(6L, memberId, 3L, tradeType), // 주식 ID 6
                    new StockTradeRecord(7L, memberId, 4L, tradeType), // 주식 ID 7
                    new StockTradeRecord(8L, memberId, 5L, tradeType)  // 주식 ID 8
            );

            stockTradeRecordRepository.saveAll(stockTradeRecords);
            log.info("memberId 6에 대한 주식 거래 기록이 추가되었습니다.");
        } else {
            log.info("이미 주식 거래 기록 데이터가 존재합니다. 데이터 로드를 생략합니다.");
        }
    }
}
