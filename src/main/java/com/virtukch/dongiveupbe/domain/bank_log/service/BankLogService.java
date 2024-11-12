package com.virtukch.dongiveupbe.domain.bank_log.service;

import com.virtukch.dongiveupbe.domain.bank_log.Dto.BankLogRequestDto;
import com.virtukch.dongiveupbe.domain.bank_log.Dto.BankLogResponseDto;
import com.virtukch.dongiveupbe.domain.bank_log.entity.BankLog;
import com.virtukch.dongiveupbe.domain.bank_log.repository.BankLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankLogService {
    private final BankLogRepository bankLogRepository;

    public BankLogService(BankLogRepository bankLogRepository) {
        this.bankLogRepository = bankLogRepository;
    }

    public List<BankLogResponseDto> getAll() {
        return bankLogRepository.findAll().stream()
                .map(BankLogResponseDto::fromEntity)
                .toList();
    }

    public List<BankLogResponseDto> getBankLogsByMemberId(Long memberId) {
        return bankLogRepository.findByGameMemberId(memberId).stream()
                .map(BankLogResponseDto::fromEntity)
                .toList();
    }

    public BankLogResponseDto save(BankLogRequestDto requestDto) {
        BankLog bankLog = new BankLog(requestDto.getGameMemberId(), requestDto.getSavingProductStatusId());
        BankLog saved = bankLogRepository.save(bankLog);
        return BankLogResponseDto.fromEntity(saved);
    }
}

