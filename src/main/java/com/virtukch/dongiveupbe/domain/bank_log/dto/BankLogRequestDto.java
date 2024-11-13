package com.virtukch.dongiveupbe.domain.bank_log.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BankLogRequestDto {
    private Long gameMemberId;
    private Long savingProductStatusId;
}
