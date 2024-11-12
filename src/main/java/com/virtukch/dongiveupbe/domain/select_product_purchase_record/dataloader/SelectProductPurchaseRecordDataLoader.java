package com.virtukch.dongiveupbe.domain.select_product_purchase_record.dataloader;

import com.virtukch.dongiveupbe.domain.select_product_purchase_record.entity.SelectProductPurchaseRecord;
import com.virtukch.dongiveupbe.domain.select_product_purchase_record.repository.SelectProductPurchaseRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"localCreate", "devCreate"})
public class SelectProductPurchaseRecordDataLoader implements CommandLineRunner {

    private final SelectProductPurchaseRecordRepository purchaseRecordRepository;

    public SelectProductPurchaseRecordDataLoader(SelectProductPurchaseRecordRepository purchaseRecordRepository) {
        this.purchaseRecordRepository = purchaseRecordRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // 선생님 쿠폰 구매 기록 생성 - selectProductStatusId와 gameMemberId가 6번으로 동일
        SelectProductPurchaseRecord purchaseRecord1 = SelectProductPurchaseRecord.builder()
                .selectProductStatusId(6L)  // 선생님 쿠폰 ID
                .gameMemberId(6L)           // 학생 ID 6번
                .selectProductPurchaseAmount(3L)  // 구매 금액 5,000원
                .build();

        purchaseRecordRepository.save(purchaseRecord1);

        log.info("selectProductStatusId 6번, gameMemberId 6번에 대한 선생님 쿠폰 구매 기록이 삽입되었습니다.");
    }
}
