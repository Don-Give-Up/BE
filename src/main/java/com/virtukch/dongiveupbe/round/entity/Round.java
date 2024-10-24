package com.virtukch.dongiveupbe.round.entity;

import jakarta.persistence.*;
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
}
