package com.virtukch.dongiveupbe.stock_status.dataloader;

import com.opencsv.CSVReader;
import com.virtukch.dongiveupbe.stock_status.entity.StockStatus;
import com.virtukch.dongiveupbe.stock_status.repository.StockStatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.FileReader;

@Component
public class StockStatusDataLoader implements CommandLineRunner {

    private final StockStatusRepository stockStatusRepository;

    public StockStatusDataLoader(StockStatusRepository stockStatusRepository) {
        this.stockStatusRepository = stockStatusRepository;
    }

    @Override
    @Profile({"localCreate", "devCreate", "prod"})
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

        System.out.println("StockStatus 데이터가 라운드별로 저장되었습니다.");
    }
}
