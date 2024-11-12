package com.virtukch.dongiveupbe.domain.bank_log.Dto;

import com.virtukch.dongiveupbe.domain.bank_log.entity.BankLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankLogResponseDto {
    private Long bankLogId;
    private Long gameMemberId;
    private Long savingProductStatusId;

    public static BankLogResponseDto fromEntity(BankLog bankLog) {
        return BankLogResponseDto.builder()
                .bankLogId(bankLog.getBankLogId())
                .gameMemberId(bankLog.getGameMemberId())
                .savingProductStatusId(bankLog.getSavingProductStatusId())
                .build();
    }
}
