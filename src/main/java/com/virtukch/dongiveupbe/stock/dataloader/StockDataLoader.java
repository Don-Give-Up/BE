package com.virtukch.dongiveupbe.stock.dataloader;

import com.virtukch.dongiveupbe.stock.entity.Stock;
import com.virtukch.dongiveupbe.stock.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"localCreate", "devCreate", "prod"})
public class StockDataLoader implements CommandLineRunner {

    private final StockRepository stockRepository;

    public StockDataLoader(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stock samsungStock = new Stock("삼성전자");

        stockRepository.save(samsungStock);
        log.info("삼성전자 스텁 데이터가 삽입되었습니다.");
    }
}
