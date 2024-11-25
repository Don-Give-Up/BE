package com.virtukch.dongiveupbe.domain.bank_log.dataloader;

import com.virtukch.dongiveupbe.domain.bank_log.entity.BankLog;
import com.virtukch.dongiveupbe.domain.bank_log.repository.BankLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"localCreate", "devCreate", "prodCreate"})
public class BankDataLoader implements CommandLineRunner {

    private final BankLogRepository bankLogRepository;

    public BankDataLoader(BankLogRepository bankLogRepository) {
        this.bankLogRepository = bankLogRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBankLogs();
    }

    private void loadBankLogs() {
        if (bankLogRepository.count() == 0) {
            // 첫 번째 BankLog 데이터 생성
            BankLog bankLog1 = BankLog.builder()
                    .gameId(1L)
                    .gameMemberId(1L)
                    .savingProductId(1L)
                    .bankTotalPrice(5000)
                    .build();
            bankLogRepository.save(bankLog1);

            // 두 번째 BankLog 데이터 생성
            BankLog bankLog2 = BankLog.builder()
                    .gameId(1L)
                    .gameMemberId(2L)
                    .savingProductId(2L)
                    .bankTotalPrice(7000)
                    .build();
            bankLogRepository.save(bankLog2);

            log.info("BankLog 스텁 데이터가 성공적으로 추가되었습니다.");
        } else {
            log.info("이미 BankLog 데이터가 존재합니다. 데이터 로드를 생략합니다.");
        }
    }
}
