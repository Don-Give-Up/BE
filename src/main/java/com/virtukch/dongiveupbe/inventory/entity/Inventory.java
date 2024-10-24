package com.virtukch.dongiveupbe.inventory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
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
}
