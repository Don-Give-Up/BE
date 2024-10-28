package com.virtukch.dongiveupbe.inventory.controller;

import com.virtukch.dongiveupbe.inventory.dto.InventoryRequestDto;
import com.virtukch.dongiveupbe.inventory.dto.InventoryResponseDto;
import com.virtukch.dongiveupbe.inventory.service.InventoryService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inventories")
@RequiredArgsConstructor
@Tag(name = "인벤토리 API (안 쓰셔도 될 것 같습니다. 혹여나 안 쓰시게 되면 말씀해 주세요! 백엔드 일이 많이 줄어 듭니다ㅠㅠ)", description = "이미지 관리에 대한 논의가 필요할 것 같아요")
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    @Operation(summary = "인벤토리에 아이템이 추가될 때마다 호출해 주세요.", description = "essentialProductId, savingProductId, selectProductId, stockId 는 각각의 상품이 생성될 때 얻을 수 있습니다.")
    public ResponseEntity<InventoryResponseDto> saveInventory(
        @RequestBody InventoryRequestDto requestDto) {
        InventoryResponseDto responseDto = inventoryService.saveInventory(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @Hidden
    @GetMapping("/{inventoryId}")
    @Operation(summary = "특정 인벤토리 조회", description = "특정 인벤토리 항목을 ID로 조회합니다.")
    @ApiResponse(responseCode = "200", description = "인벤토리 조회 성공",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = InventoryResponseDto.class)))
    public ResponseEntity<InventoryResponseDto> getInventory(@PathVariable Long inventoryId) {
        InventoryResponseDto responseDto = inventoryService.getInventory(inventoryId);
        return ResponseEntity.ok(responseDto);
    }
}
