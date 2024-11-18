package com.virtukch.dongiveupbe.domain.bank_log.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BankLogRequestDto {

    @NotNull(message = "gameMemberId는 필수입니다.")
    private Long gameMemberId;

    @NotNull(message = "savingProductId는 필수입니다.")
    private Long savingProductId;

    @NotNull(message = "bankTotalPrice는 필수입니다.")
    private Integer bankTotalPrice;
}

