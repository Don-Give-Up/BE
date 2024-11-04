package com.virtukch.dongiveupbe.domain.inventory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    private Long gameMemberId;

    private Long essentialProductId;

    private Long savingProductId;

    private Long selectProductId;

    private Long stockId;

    private Integer inventoryAmount;

    @Builder
    public Inventory(Long gameMemberId, Long essentialProductId, Long savingProductId, Long selectProductId, Long stockId, Integer inventoryAmount) {
        this.gameMemberId = gameMemberId;
        this.essentialProductId = essentialProductId;
        this.savingProductId = savingProductId;
        this.selectProductId = selectProductId;
        this.stockId = stockId;
        this.inventoryAmount = inventoryAmount;
    }
}
