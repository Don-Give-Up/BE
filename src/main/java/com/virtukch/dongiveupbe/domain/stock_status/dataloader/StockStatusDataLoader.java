package com.virtukch.dongiveupbe.domain.stock_status.dataloader;

import com.opencsv.CSVReader;
import com.virtukch.dongiveupbe.domain.stock_status.entity.StockStatus;
import com.virtukch.dongiveupbe.domain.stock_status.repository.StockStatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.FileReader;

@Slf4j
@Component
@Profile({"localCreate", "devCreate", "prodCreate"})
public class StockStatusDataLoader implements CommandLineRunner {

    private final StockStatusRepository stockStatusRepository;

    public StockStatusDataLoader(StockStatusRepository stockStatusRepository) {
        this.stockStatusRepository = stockStatusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        String filePath = "src/main/resources/csv/filtered_samsung_data.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            Long stockId = 1L;
            Long roundId = 1L;
            int count = 0;

            while ((line = reader.readNext()) != null) {
                Long price = Long.parseLong(line[1].trim());
                if (count == 5) {
                    roundId++;
                    count = 0;
                }
                StockStatus stockStatus = new StockStatus(roundId, stockId, price);
                stockStatusRepository.save(stockStatus);
                count++;
            }
        }
        log.info("StockStatus 데이터가 라운드별로 저장되었습니다.");
    }
}
