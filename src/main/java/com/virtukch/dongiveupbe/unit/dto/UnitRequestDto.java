package com.virtukch.dongiveupbe.unit.dto;

import com.virtukch.dongiveupbe.unit.entity.Unit;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UnitRequestDto {

    String unitName;

    public static Unit toEntity(UnitRequestDto unitRequestDto) {
        return Unit.builder()
            .unitName(unitRequestDto.getUnitName())
            .build();
    }
}