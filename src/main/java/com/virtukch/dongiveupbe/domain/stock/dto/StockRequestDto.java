package com.virtukch.dongiveupbe.domain.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StockRequestDto {

    private Long stockId;
    private String stockName;
    private String stockPrice;

}
