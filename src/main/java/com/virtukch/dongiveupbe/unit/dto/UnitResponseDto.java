package com.virtukch.dongiveupbe.unit.dto;

import com.virtukch.dongiveupbe.unit.entity.Unit;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UnitResponseDto {

    String unitName;

    public static UnitResponseDto fromEntity(Unit unit) {
        return UnitResponseDto.builder()
            .unitName(unit.getUnitName())
            .build();
    }
}