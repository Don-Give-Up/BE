package com.virtukch.dongiveupbe.domain.bank_log.controller;

import com.virtukch.dongiveupbe.domain.bank_log.dto.BankLogRequestDto;
import com.virtukch.dongiveupbe.domain.bank_log.dto.BankLogResponseDto;
import com.virtukch.dongiveupbe.domain.bank_log.service.BankLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/banklogs")
public class BankLogController {
    private final BankLogService bankLogService;

    public BankLogController(BankLogService bankLogService) {
        this.bankLogService = bankLogService;
    }

    @GetMapping
    public ResponseEntity<List<BankLogResponseDto>> getAllBankLogs() {
        List<BankLogResponseDto> bankLogs = bankLogService.getAll();
        return ResponseEntity.ok(bankLogs);
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<BankLogResponseDto>> getAllBankLogsByMemberId(@PathVariable("memberId") Long memberId) {
        List<BankLogResponseDto> bankLogs = bankLogService.getBankLogsByMemberId(memberId);
        return ResponseEntity.ok(bankLogs);
    }

    @PostMapping
    public ResponseEntity<BankLogResponseDto> save(@RequestBody BankLogRequestDto requestDto) {
        BankLogResponseDto responseDto = bankLogService.save(requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
