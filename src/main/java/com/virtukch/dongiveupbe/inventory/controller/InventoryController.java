package com.virtukch.dongiveupbe.inventory.controller;

import com.virtukch.dongiveupbe.inventory.dto.InventoryRequestDto;
import com.virtukch.dongiveupbe.inventory.dto.InventoryResponseDto;
import com.virtukch.dongiveupbe.inventory.service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventories")
@RequiredArgsConstructor
@Tag(name = "인벤토리 API", description = "인벤토리 관리를 위한 API")
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    @Operation(summary = "인벤토리 저장", description = "새로운 인벤토리 항목을 저장합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "인벤토리 저장 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = InventoryResponseDto.class)))
    })
    public ResponseEntity<InventoryResponseDto> saveInventory(@RequestBody InventoryRequestDto requestDto) {
        InventoryResponseDto responseDto = inventoryService.saveInventory(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{inventoryId}")
    @Operation(summary = "특정 인벤토리 조회", description = "특정 인벤토리 항목을 ID로 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "인벤토리 조회 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = InventoryResponseDto.class)))
    })
    public ResponseEntity<InventoryResponseDto> getInventory(@PathVariable Long inventoryId) {
        InventoryResponseDto responseDto = inventoryService.getInventory(inventoryId);
        return ResponseEntity.ok(responseDto);
    }
}
