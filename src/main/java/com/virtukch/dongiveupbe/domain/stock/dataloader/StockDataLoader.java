package com.virtukch.dongiveupbe.domain.stock.dataloader;

import com.virtukch.dongiveupbe.domain.stock.repository.StockRepository;
import com.virtukch.dongiveupbe.domain.stock.entity.Stock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
@Profile({"localCreate", "devCreate", "prodCreate"})
public class StockDataLoader implements CommandLineRunner {

    private final StockRepository stockRepository;

    public StockDataLoader(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadStockData();
    }

    private void loadStockData() {
        if (stockRepository.count() == 0) {
            List<Stock> stocks = Arrays.asList(
                    new Stock("삼성전자"),
                    new Stock("테슬라"),
                    new Stock("애플"),
                    new Stock("화이자"),
                    new Stock("삼양식품"),
                    new Stock("한진중공업홀딩스"),
                    new Stock("대한항공"),
                    new Stock("SK이노베이션")
            );

            stockRepository.saveAll(stocks);
            log.info("주식 스텁 데이터가 삽입되었습니다.");
        } else {
            log.info("주식 데이터가 이미 존재합니다. 데이터 로드를 생략합니다.");
        }
    }
}
