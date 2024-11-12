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
    private Long BankLogId;

    private Long gameMemberId;

    private Long savingProductStatusId;

    public BankLog(Long gameMemberId, Long savingProductStatusId) {
        this.gameMemberId = gameMemberId;
        this.savingProductStatusId = savingProductStatusId;
    }
}