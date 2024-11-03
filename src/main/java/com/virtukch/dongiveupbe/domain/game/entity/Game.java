package com.virtukch.dongiveupbe.domain.game.entity;

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
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    private Long memberId;

    private String gameName;

    private String gamePassword;

    @Builder
    public Game(Long memberId, String gameName, String gamePassword) {
        this.memberId = memberId;
        this.gameName = gameName;
        this.gamePassword = gamePassword;
    }
}