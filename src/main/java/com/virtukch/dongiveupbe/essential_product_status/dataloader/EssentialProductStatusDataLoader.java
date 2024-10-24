package com.virtukch.dongiveupbe.essential_product_status.dataloader;

import com.virtukch.dongiveupbe.essential_product_status.entity.EssentialProductStatus;
import com.virtukch.dongiveupbe.essential_product_status.repository.EssentialProductStatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EssentialProductStatusDataLoader implements CommandLineRunner {

    private final EssentialProductStatusRepository essentialProductStatusRepository;

    public EssentialProductStatusDataLoader(EssentialProductStatusRepository essentialProductStatusRepository) {
        this.essentialProductStatusRepository = essentialProductStatusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // 실제 빵 가격 데이터
        Long[] prices = {
                670L, 743L, 776L, 804L, 834L, 905L, 983L, 1009L, 1270L, 1346L, 1346L, 1302L, 1526L, 1657L, 1557L,
                1994L, 1723L, 1611L, 1867L, 1936L, 1948L, 2069L, 2994L, 1916L, 2122L, 2429L, 2612L, 2534L
        };

        // 판매량 예시 데이터 (랜덤값 또는 주어진 기준)
        Long[] amounts = {
                50L, 60L, 55L, 70L, 65L, 80L, 75L, 90L, 85L, 100L,
                95L, 110L, 105L, 120L, 115L, 130L, 125L, 140L,
                135L, 150L, 145L, 160L, 155L, 170L, 165L, 180L,
                175L, 190L
        };

        Long essentialProductId = 1L;
        Long roundId = 1L;

        // 각 라운드마다 데이터를 삽입
        for (int i = 0; i < prices.length; i++) {
            EssentialProductStatus status = new EssentialProductStatus(
                    essentialProductId,
                    roundId,
                    prices[i], // Long 타입의 가격 데이터
                    amounts[i]
            );
            essentialProductStatusRepository.save(status);
            roundId++;
        }

        System.out.println("EssentialProductStatus 데이터가 라운드별로 저장되었습니다.");
    }
}
