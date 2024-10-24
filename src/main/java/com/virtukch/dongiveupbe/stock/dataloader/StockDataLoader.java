package com.virtukch.dongiveupbe.stock.dataloader;

import com.virtukch.dongiveupbe.stock.entity.Stock;
import com.virtukch.dongiveupbe.stock.repository.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StockDataLoader implements CommandLineRunner {
    private final StockRepository stockRepository;

    public StockDataLoader(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Stock samsungStock = new Stock("삼성전자");

        stockRepository.save(samsungStock);
        System.out.println("삼성전자 스텁 데이터가 삽입되었습니다.");
    }
}
