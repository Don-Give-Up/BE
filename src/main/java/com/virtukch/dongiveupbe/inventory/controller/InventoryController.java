package com.virtukch.dongiveupbe.inventory.controller;

import com.virtukch.dongiveupbe.inventory.dto.InventoryRequestDto;
import com.virtukch.dongiveupbe.inventory.dto.InventoryResponseDto;
import com.virtukch.dongiveupbe.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventories")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<InventoryResponseDto> saveInventory(@RequestBody InventoryRequestDto requestDto) {
        InventoryResponseDto responseDto = inventoryService.saveInventory(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{inventoryId}")
    public ResponseEntity<InventoryResponseDto> getInventory(@PathVariable Long inventoryId) {
        InventoryResponseDto responseDto = inventoryService.getInventory(inventoryId);
        return ResponseEntity.ok(responseDto);
    }
}
