package com.virtukch.dongiveupbe.domain.saving_product.dataloader;

import com.virtukch.dongiveupbe.domain.saving_product.repository.SavingProductRepository;
import com.virtukch.dongiveupbe.domain.saving_product.entity.SavingProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"localCreate", "devCreate", "prodCreate"})
public class SavingProductDataLoader implements CommandLineRunner {

    private final SavingProductRepository savingProductRepository;

    @Autowired
    public SavingProductDataLoader(SavingProductRepository savingProductRepository) {
        this.savingProductRepository = savingProductRepository;
    }

    // local (ddl-auto: none, DataLoader 작동 X)
    // localCreate (ddl-auto: create, DataLoader 작동 O)
    // dev (ddl-auto: none, DataLoader 작동 X)
    // devCreate (ddl-auto: create, DataLoader 작동 O)
    // prod (ddl-auto: create, DataLoader 작동 O)
    @Override
    public void run(String... args) throws Exception {
        SavingProduct savingProduct1 = SavingProduct.builder()
            .savingProductName("자유 적금")
            .build();
        savingProductRepository.save(savingProduct1);

        SavingProduct savingProduct2 = SavingProduct.builder()
            .savingProductName("예금")
            .build();
        savingProductRepository.save(savingProduct2);

        SavingProduct savingProduct3 = SavingProduct.builder()
            .savingProductName("정기 적금")
            .build();
        savingProductRepository.save(savingProduct3);
    }
}