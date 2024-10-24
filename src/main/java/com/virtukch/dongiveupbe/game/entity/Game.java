package com.virtukch.dongiveupbe.game.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    // 선생님 회원 번호
    private Long memberNo;

    private String gameName;

    private String gamePassword;

    public Game(Long memberNo, String gameName, String gamePassword) {
        this.memberNo = memberNo;
        this.gameName = gameName;
        this.gamePassword = gamePassword;
    }
}