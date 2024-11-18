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
                    new Stock("민정전자",67100),
                    new Stock("호진자동차", 220096),
                    new Stock("메타IT", 133703),
                    new Stock("보영바이오", 43533),
                    new Stock("여원푸드", 102000),
                    new Stock("민주중공업", 4180),
                    new Stock("채호에어", 25950),
                    new Stock("유진에너지", 176000)
            );

            stockRepository.saveAll(stocks);
            log.info("주식 스텁 데이터가 삽입되었습니다.");
        } else {
            log.info("주식 데이터가 이미 존재합니다. 데이터 로드를 생략합니다.");
        }
    }
}
