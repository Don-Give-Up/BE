package com.virtukch.dongiveupbe.domain.bank_log.service;

import com.virtukch.dongiveupbe.domain.bank_log.dto.BankLogRequestDto;
import com.virtukch.dongiveupbe.domain.bank_log.dto.BankLogResponseDto;
import com.virtukch.dongiveupbe.domain.bank_log.entity.BankLog;
import com.virtukch.dongiveupbe.domain.bank_log.repository.BankLogRepository;
import com.virtukch.dongiveupbe.domain.saving_product.entity.SavingProduct;
import com.virtukch.dongiveupbe.domain.saving_product.service.SavingProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankLogService {

    private final BankLogRepository bankLogRepository;
    private final SavingProductService savingProductService;

    // 모든 BankLog를 savingProductName과 함께 반환
    public List<BankLogResponseDto> getAll() {
        return bankLogRepository.findAllBankLogsWithProductName();
    }

    // 특정 gameMemberId의 BankLog를 savingProductName과 함께 반환
    public List<BankLogResponseDto> getBankLogsByMemberId(Long memberId) {
        return bankLogRepository.findBankLogsWithProductNameByGameMemberId(memberId);
    }

    // BankLog 저장 후 savingProductName 포함된 결과 반환
    public BankLogResponseDto save(BankLogRequestDto requestDto) {
        System.out.println("SavingProductId: " + requestDto.getSavingProductId()); // 로그 추가

        SavingProduct savingProduct = savingProductService.findById(requestDto.getSavingProductId());

        BankLog bankLog = new BankLog(
                requestDto.getGameMemberId(),
                savingProduct.getSavingProductId(),
                requestDto.getBankTotalPrice());

        BankLog saved = bankLogRepository.save(bankLog);

        return bankLogRepository.findResponseDtoByBankLogId(saved.getBankLogId())
                .orElseThrow(() -> new IllegalArgumentException("저장된 로그를 찾을 수 없습니다."));
    }

}
