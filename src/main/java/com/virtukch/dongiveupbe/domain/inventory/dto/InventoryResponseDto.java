package com.virtukch.dongiveupbe.domain.inventory.dto;

import com.virtukch.dongiveupbe.domain.inventory.entity.Inventory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Getter
@NoArgsConstructor
public class InventoryResponseDto {
    private Long inventoryId;
    private Long gameMemberId;
    private Long essentialProductId;
    private Long savingProductId;
    private Long selectProductId;
    private Long stockId;
    private Integer inventoryAmount;

    @Builder
    public InventoryResponseDto(Long inventoryId, Long gameMemberId, Long essentialProductId, Long savingProductId, Long selectProductId, Long stockId, Integer inventoryAmount) {
        this.inventoryId = inventoryId;
        this.gameMemberId = gameMemberId;
        this.essentialProductId = essentialProductId;
        this.savingProductId = savingProductId;
        this.selectProductId = selectProductId;
        this.stockId = stockId;
        this.inventoryAmount = inventoryAmount;
    }

    public static InventoryResponseDto fromEntity(Inventory inventory) {
        return InventoryResponseDto.builder()
                .inventoryId(inventory.getInventoryId())
                .gameMemberId(inventory.getGameMemberId())
                .essentialProductId(inventory.getEssentialProductId())
                .savingProductId(inventory.getSavingProductId())
                .selectProductId(inventory.getSelectProductId())
                .stockId(inventory.getStockId())
                .inventoryAmount(inventory.getInventoryAmount())
                .build();
    }
}
