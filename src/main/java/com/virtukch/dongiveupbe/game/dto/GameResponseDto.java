package com.virtukch.dongiveupbe.game.dto;

import com.virtukch.dongiveupbe.game.entity.Game;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GameResponseDto {
    private Long gameId;

    private Long memberId;

    private String gameName;

    private String gamePassword;

    @Builder
    public GameResponseDto(Long gameId, Long memberId, String gameName, String gamePassword) {
        this.gameId = gameId;
        this.memberId = memberId;
        this.gameName = gameName;
        this.gamePassword = gamePassword;
    }

    public static GameResponseDto fromEntity(Game game) {
        return GameResponseDto.builder()
                .gameId(game.getGameId())
                .memberId(game.getMemberId())
                .gameName(game.getGameName())
                .gamePassword(game.getGamePassword())
                .build();
    }
}
