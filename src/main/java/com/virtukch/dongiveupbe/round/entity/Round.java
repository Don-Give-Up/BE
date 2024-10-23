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
    private Long round_id;

    private Long game_id;

    private Double round_interest_rate;

    private Long round_salary;

    public Round(Long game_id, Double round_interest_rate, Long round_salary) {
        this.game_id = game_id;
        this.round_interest_rate = round_interest_rate;
        this.round_salary = round_salary;
    }
}
