package com.virtukch.dongiveupbe.unit.controller;

import com.virtukch.dongiveupbe.unit.dto.UnitRegisterRequestDto;
import com.virtukch.dongiveupbe.unit.dto.UnitResponseDto;
import com.virtukch.dongiveupbe.unit.service.UnitService;
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
public class UnitController {

    private final UnitService unitService;

    @Autowired
    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping
    public ResponseEntity<List<UnitResponseDto>> getUnits() {
        return ResponseEntity.ok(unitService.findAll());
    }

    @PostMapping
    public ResponseEntity<UnitResponseDto> save(@RequestBody UnitRegisterRequestDto unitRegisterRequestDto) {
        return ResponseEntity.ok(unitService.save(unitRegisterRequestDto));
    }

    @GetMapping("{unitName}")
    public ResponseEntity<UnitResponseDto> findByUnitName(@PathVariable String unitName) {
        return ResponseEntity.ok(unitService.findByUnitName(unitName));
    }
}