package com.virtukch.dongiveupbe.domain.stock_status.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StockStatusRequestDto {
    private Long stockStatusId;
    private Long roundId;
    private Long stockStatusCurrentPrice;
    private String stockName;
}
