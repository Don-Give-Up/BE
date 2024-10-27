package com.virtukch.dongiveupbe.inventory.service;

import com.virtukch.dongiveupbe.essential_product.exception.EntityNotFoundException;
import com.virtukch.dongiveupbe.inventory.dto.InventoryRegisterRequestDto;
import com.virtukch.dongiveupbe.inventory.dto.InventoryResponseDto;
import com.virtukch.dongiveupbe.inventory.entity.Inventory;
import com.virtukch.dongiveupbe.inventory.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional
    public InventoryResponseDto saveInventory(InventoryRegisterRequestDto requestDto) {
        Inventory inventory = inventoryRepository.save(requestDto.toEntity());
        return InventoryResponseDto.fromEntity(inventory);
    }

    @Transactional(readOnly = true)
    public InventoryResponseDto getInventory(Long inventoryId) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new EntityNotFoundException("인벤토리 ID를 찾을 수 없습니다. ID: " + inventoryId));
        return InventoryResponseDto.fromEntity(inventory);
    }
}
