package com.virtukch.dongiveupbe.essential_product.dataloader;

import com.virtukch.dongiveupbe.essential_product.entity.EssentialProduct;
import com.virtukch.dongiveupbe.essential_product.repository.EssentialProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EssentialProductDataLoader implements CommandLineRunner {
    private final EssentialProductRepository essentialProductRepository;

    public EssentialProductDataLoader(EssentialProductRepository essentialProductRepository) {
        this.essentialProductRepository = essentialProductRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        EssentialProduct bread = new EssentialProduct("빵", 5L, "기본 회복 아이템");

        essentialProductRepository.save(bread);
        System.out.println("빵 스텁 데이터가 삽입되었습니다.");
    }
}
