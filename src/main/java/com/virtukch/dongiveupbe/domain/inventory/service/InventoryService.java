package com.virtukch.dongiveupbe.domain.inventory.service;

import com.virtukch.dongiveupbe.domain.inventory.dto.InventoryRequestDto;
import com.virtukch.dongiveupbe.domain.inventory.dto.InventoryResponseDto;
import com.virtukch.dongiveupbe.domain.inventory.entity.Inventory;
import com.virtukch.dongiveupbe.domain.inventory.repository.InventoryRepository;
import com.virtukch.dongiveupbe.domain.essential_product.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional
    public InventoryResponseDto saveInventory(InventoryRequestDto requestDto) {
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
