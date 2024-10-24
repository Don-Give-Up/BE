package com.virtukch.dongiveupbe.unit.service;

import com.virtukch.dongiveupbe.unit.dto.UnitRegisterRequestDto;
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

    public List<UnitResponseDto> findAll() {
        return unitRepository.findAll().stream()
            .map(unit -> UnitResponseDto.builder()
                .unitName(unit.getUnitName())
                .build()).toList();
    }

    public UnitResponseDto save(UnitRegisterRequestDto unitRegisterRequestDto) {
        Unit unit = Unit.builder()
            .unitName(unitRegisterRequestDto.getUnitName())
            .build();

        Unit savedUnit = unitRepository.save(unit);

        return UnitResponseDto.builder()
            .unitName(savedUnit.getUnitName())
            .build();
    }

    public UnitResponseDto findByUnitName(String unitName) {
        Unit unit = unitRepository.findByUnitName(unitName).orElse(null);

        if (unit == null) {
            throw new UnitNotFoundException(unitName + " not found");
        }

        return UnitResponseDto.builder()
            .unitName(unit.getUnitName())
            .build();
    }
}