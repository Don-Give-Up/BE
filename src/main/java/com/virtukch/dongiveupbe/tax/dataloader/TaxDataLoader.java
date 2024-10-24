package com.virtukch.dongiveupbe.tax.dataloader;

import com.virtukch.dongiveupbe.tax.entity.Tax;
import com.virtukch.dongiveupbe.tax.repository.TaxRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TaxDataLoader implements CommandLineRunner {

    private final TaxRepository taxRepository;

    public TaxDataLoader(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Tax globalIncomeTax = new Tax("종합소득세");
        taxRepository.save(globalIncomeTax);

        System.out.println("종합소득세 데이터가 삽입되었습니다.");
    }
}
