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
            Long gameMemberId = 6L;
            Long savingProductStatusId = 3L;
            Integer bankTotalPrice = 10000;  // amount 설정

            // 수정된 생성자를 통해 BankLog 생성
            BankLog bankLog = new BankLog(gameMemberId, savingProductStatusId, bankTotalPrice);

            bankLogRepository.save(bankLog);
            log.info("memberId 6에 대한 BankLog 스텁 데이터가 추가되었습니다. savingProductStatusId는 3, amount는 10000으로 설정되었습니다.");
        } else {
            log.info("이미 BankLog 데이터가 존재합니다. 데이터 로드를 생략합니다.");
        }
    }
}
