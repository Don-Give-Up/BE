package com.virtukch.dongiveupbe.unit.controller;

import com.virtukch.dongiveupbe.unit.dto.UnitRequestDto;
import com.virtukch.dongiveupbe.unit.dto.UnitResponseDto;
import com.virtukch.dongiveupbe.unit.service.UnitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @GetMapping
    @Operation(summary = "현재 존재하는 단원 전체 조회")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "단원 전체 조회 성공",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = UnitResponseDto.class))),
        @ApiResponse(responseCode = "404", description = "단원 없음",
            content = @Content)
    })
    public ResponseEntity<List<UnitResponseDto>> findAll() {
        List<UnitResponseDto> units = unitService.findAll();
        return ResponseEntity.ok(units);
    }

    @PostMapping
    @Operation(summary = "단원 추가")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "단원 추가 성공",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = UnitResponseDto.class))),
        @ApiResponse(responseCode = "400", description = "잘못된 요청",
            content = @Content)
    })
    public ResponseEntity<UnitResponseDto> save(
        @RequestBody UnitRequestDto unitRequestDto) {
        UnitResponseDto savedUnit = unitService.save(unitRequestDto);
        return ResponseEntity.status(201).body(savedUnit);
    }

    @GetMapping("{unitName}")
    @Operation(summary = "단원 이름으로 단원 ID & 단원 이름 찾기")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "단원 단일 조회 성공",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = UnitResponseDto.class))),
        @ApiResponse(responseCode = "404", description = "단원이 존재하지 않음",
            content = @Content)
    })
    public ResponseEntity<UnitResponseDto> findByUnitName(@PathVariable String unitName) {
        UnitResponseDto unit = unitService.findByUnitName(unitName);
        return ResponseEntity.ok(unit);
    }
}
