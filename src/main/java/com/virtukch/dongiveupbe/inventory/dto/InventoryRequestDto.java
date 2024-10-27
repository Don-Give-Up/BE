package com.virtukch.dongiveupbe.inventory.dto;

import com.virtukch.dongiveupbe.inventory.entity.Inventory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InventoryRequestDto {
    private Long gameMemberId;
    private Long essentialProductId;
    private Long savingProductId;
    private Long selectProductId;
    private Long stockId;
    private Integer inventoryAmount;

    @Builder
    public InventoryRequestDto(Long gameMemberId, Long essentialProductId, Long savingProductId, Long selectProductId, Long stockId, Integer inventoryAmount) {
        this.gameMemberId = gameMemberId;
        this.essentialProductId = essentialProductId;
        this.savingProductId = savingProductId;
        this.selectProductId = selectProductId;
        this.stockId = stockId;
        this.inventoryAmount = inventoryAmount;
    }

    public Inventory toEntity() {
        return Inventory.builder()
                .gameMemberId(this.gameMemberId)
                .essentialProductId(this.essentialProductId)
                .savingProductId(this.savingProductId)
                .selectProductId(this.selectProductId)
                .stockId(this.stockId)
                .inventoryAmount(this.inventoryAmount)
                .build();
    }
}
