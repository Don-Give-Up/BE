package com.virtukch.dongiveupbe.domain.tax.dataloader;

import com.virtukch.dongiveupbe.domain.tax.entity.Tax;
import com.virtukch.dongiveupbe.domain.tax.repository.TaxRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"localCreate", "devCreate", "prodCreate"})
public class TaxDataLoader implements CommandLineRunner {

    private final TaxRepository taxRepository;

    public TaxDataLoader(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Tax globalIncomeTax = new Tax("종합소득세");
        taxRepository.save(globalIncomeTax);
        log.info("종합소득세 데이터가 삽입되었습니다.");
    }
}
