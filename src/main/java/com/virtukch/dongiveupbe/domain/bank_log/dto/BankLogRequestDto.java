package com.virtukch.dongiveupbe.domain.bank_log.dto;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BankLogRequestDto {
    @Hidden
    @Setter
    private Long gameMemberId;

    private Long gameId;

    @NotNull(message = "savingProductId는 필수입니다.")
    private Long savingProductId;

    @NotNull(message = "bankTotalPrice는 필수입니다.")
    private Integer bankTotalPrice;
}

