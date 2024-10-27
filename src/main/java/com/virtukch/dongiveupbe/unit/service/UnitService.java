package com.virtukch.dongiveupbe.unit.service;

import com.virtukch.dongiveupbe.unit.dto.UnitRequestDto;
import com.virtukch.dongiveupbe.unit.dto.UnitResponseDto;
import com.virtukch.dongiveupbe.unit.entity.Unit;
import com.virtukch.dongiveupbe.unit.exception.UnitNotFoundException;
import com.virtukch.dongiveupbe.unit.repository.UnitRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitService {

    private final UnitRepository unitRepository;

    @Autowired
    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    // 1. 단원 전체 조회
    public List<UnitResponseDto> findAll() {
        return unitRepository.findAll().stream().map(UnitResponseDto::fromEntity).toList();
    }

    // 2. 단원 추가
    public UnitResponseDto save(UnitRequestDto unitRequestDto) {
        Unit unit = unitRepository.save(UnitRequestDto.toEntity(unitRequestDto));
        return UnitResponseDto.fromEntity(unit);
    }

    // 3. 단원 이름으로 단원 코드 찾기
    public UnitResponseDto findByUnitName(String unitName) {
        Unit unit = unitRepository.findByUnitName(unitName)
            .orElseThrow(() -> new UnitNotFoundException(unitName + " not found"));
        return UnitResponseDto.fromEntity(unit);
    }
}