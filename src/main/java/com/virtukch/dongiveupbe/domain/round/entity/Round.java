package com.virtukch.dongiveupbe.domain.round.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roundId;

    private Long gameId;

    private Double roundInterestRate;

    private Long roundSalary;

    private Integer roundSequence;

    @Builder
    public Round(Long gameId, Double roundInterestRate, Long roundSalary, Integer roundSequence) {
        this.gameId = gameId;
        this.roundInterestRate = roundInterestRate;
        this.roundSalary = roundSalary;
        this.roundSequence = roundSequence;
    }
}
