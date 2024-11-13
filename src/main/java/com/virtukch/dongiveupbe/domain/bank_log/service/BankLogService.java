package com.virtukch.dongiveupbe.domain.bank_log.service;

import com.virtukch.dongiveupbe.domain.bank_log.dto.BankLogRequestDto;
import com.virtukch.dongiveupbe.domain.bank_log.dto.BankLogResponseDto;
import com.virtukch.dongiveupbe.domain.bank_log.entity.BankLog;
import com.virtukch.dongiveupbe.domain.bank_log.repository.BankLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankLogService {

    private final BankLogRepository bankLogRepository;

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
        BankLog bankLog = new BankLog(requestDto.getGameMemberId(), requestDto.getSavingProductStatusId());
        BankLog saved = bankLogRepository.save(bankLog);

        // 저장된 BankLog의 ID로 BankLogResponseDto 조회
        return bankLogRepository.findResponseDtoByBankLogId(saved.getBankLogId())
                .orElseThrow(() -> new IllegalArgumentException("저장된 로그를 찾을 수 없습니다."));
    }

}
