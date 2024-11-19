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
            BuyOrSell tradeType = BuyOrSell.BUY;

            // 주식 구매 이력
            List<StockTradeRecord> stockTradeRecords = Arrays.asList(
                    new StockTradeRecord(1L,6L, 1L, 6L, tradeType, 25080), // 주식 ID 1
                    new StockTradeRecord(1L,7L, 2L, 1L, tradeType, 25950) // 주식 ID 2
            );

            stockTradeRecordRepository.saveAll(stockTradeRecords);
            log.info("memberId 6에 대한 주식 거래 기록이 추가되었습니다.");
        } else {
            log.info("이미 주식 거래 기록 데이터가 존재합니다. 데이터 로드를 생략합니다.");
        }
    }
}
