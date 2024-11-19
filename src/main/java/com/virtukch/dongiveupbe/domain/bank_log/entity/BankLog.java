package com.virtukch.dongiveupbe.domain.bank_log.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class BankLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankLogId;

    private Long gameId;

    private Long gameMemberId;

    private Long savingProductId;

    private Integer bankTotalPrice;

    public BankLog(Long gameId, Long gameMemberId, Long savingProductId) {
        this.gameId = gameId;
        this.gameMemberId = gameMemberId;
        this.savingProductId = savingProductId;
    }

    public BankLog(Long gameId, Long gameMemberId, Long savingProductId, Integer bankTotalPrice) {
        this.gameId = gameId;
        this.gameMemberId = gameMemberId;
        this.savingProductId = savingProductId;
        this.bankTotalPrice = bankTotalPrice;
    }
}