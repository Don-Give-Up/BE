package com.virtukch.dongiveupbe.domain.game.dto;

import com.virtukch.dongiveupbe.domain.game.entity.Game;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GameRequestDto {
    private Long memberId;

    private String gameName;

    private String gamePassword;

    @Builder
    public GameRequestDto(Long memberId, String gameName, String gamePassword) {
        this.memberId = memberId;
        this.gameName = gameName;
        this.gamePassword = gamePassword;
    }

    public Game toEntity() {
        return Game.builder()
                .memberId(this.memberId)
                .gameName(this.gameName)
                .gamePassword(this.gamePassword)
                .build();
    }
}
