package com.virtukch.dongiveupbe.tax_status.dataloader;

import com.virtukch.dongiveupbe.tax_status.entity.TaxStatus;
import com.virtukch.dongiveupbe.tax_status.repository.TaxStatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"localCreate", "devCreate", "prod"})
public class TaxStatusDataLoader implements CommandLineRunner {

    private final TaxStatusRepository taxStatusRepository;

    public TaxStatusDataLoader(TaxStatusRepository taxStatusRepository) {
        this.taxStatusRepository = taxStatusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // 주어진 글로벌 소득세율 데이터
        Double[] taxRates = {
            10.0, 10.0, 10.0, 10.0, 10.0, 10.0,
            9.0, 9.0, 9.0, 8.0, 8.0, 8.0, 8.0,
            6.0, 6.0, 6.0, 6.0, 15.0, 15.0, 15.0, 15.0, 15.0, 15.0,
            15.0, 15.0, 15.0, 15.0, 15.0
        };

        Long taxId = 1L;
        Long roundId = 1L;

        for (Double rate : taxRates) {
            TaxStatus taxStatus = new TaxStatus(taxId, roundId, rate);
            taxStatusRepository.save(taxStatus);
            roundId++;
        }

        log.info("TaxStatus 데이터가 저장되었습니다.");
    }
}
