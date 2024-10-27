package com.virtukch.dongiveupbe.unit.controller;

import com.virtukch.dongiveupbe.unit.dto.UnitRequestDto;
import com.virtukch.dongiveupbe.unit.dto.UnitResponseDto;
import com.virtukch.dongiveupbe.unit.service.UnitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/units")
@Tag(name = "단원 API", description = "문제가 속할 단원을 미리 만들고 관리하기 위한 API")
public class UnitController {

    private final UnitService unitService;

    @Autowired
    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    // 1. 단원 전체 조회
    @GetMapping
    @Operation(summary = "단원 전체 조회", description = "모든 단원 정보를 조회합니다.")
    public ResponseEntity<List<UnitResponseDto>> findAll() {
        List<UnitResponseDto> units = unitService.findAll();
        return ResponseEntity.ok(units);
    }

    // 2. 단원 추가
    @PostMapping
    @Operation(summary = "단원 추가", description = "새로운 단원을 추가합니다.")
    public ResponseEntity<UnitResponseDto> save(
        @RequestBody UnitRequestDto unitRequestDto) {
        UnitResponseDto savedUnit = unitService.save(unitRequestDto);
        return ResponseEntity.status(201).body(savedUnit);
    }

    // 3. 단원 이름으로 단원 찾기
    @GetMapping("/{unitName}")
    @Operation(summary = "단원 이름으로 단원 찾기", description = "단원 이름으로 단원 정보를 조회합니다.")
    public ResponseEntity<UnitResponseDto> findByUnitName(@PathVariable String unitName) {
        UnitResponseDto unit = unitService.findByUnitName(unitName);
        return ResponseEntity.ok(unit);
    }
}
