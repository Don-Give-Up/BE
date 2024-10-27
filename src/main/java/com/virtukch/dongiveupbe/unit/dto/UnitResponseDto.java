package com.virtukch.dongiveupbe.unit.dto;

import com.virtukch.dongiveupbe.unit.entity.Unit;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UnitResponseDto {

    private Long unitId;

    String unitName;

    public static UnitResponseDto fromEntity(Unit unit) {
        return UnitResponseDto.builder()
            .unitId(unit.getUnitId())
            .unitName(unit.getUnitName())
            .build();
    }
}