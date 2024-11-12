package com.virtukch.dongiveupbe.domain.bank_log.dto;

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
    private String savingProductName;

    // 엔티티에서 DTO로 변환
    public static BankLogResponseDto fromEntity(BankLog bankLog, String savingProductName) {
        return BankLogResponseDto.builder()
                .bankLogId(bankLog.getBankLogId())
                .gameMemberId(bankLog.getGameMemberId())
                .savingProductName(savingProductName)
                .build();
    }
}
