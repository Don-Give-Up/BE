package com.virtukch.dongiveupbe.unit.dto;

import com.virtukch.dongiveupbe.unit.entity.Unit;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UnitRegisterRequestDto {

    String unitName;

    public static Unit toEntity(UnitRegisterRequestDto unitRegisterRequestDto) {
        return Unit.builder()
            .unitName(unitRegisterRequestDto.getUnitName())
            .build();
    }
}