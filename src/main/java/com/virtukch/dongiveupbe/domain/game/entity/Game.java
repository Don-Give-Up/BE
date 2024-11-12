package com.virtukch.dongiveupbe.domain.game.entity;

import jakarta.persistence.*;
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

    @Column(nullable = false)
    private String gameName;

    @Column(nullable = false)
    private String gamePassword;

    @Builder
    public Game(Long memberId, String gameName, String gamePassword) {
        this.memberId = memberId;
        this.gameName = gameName;
        this.gamePassword = gamePassword;
    }
}