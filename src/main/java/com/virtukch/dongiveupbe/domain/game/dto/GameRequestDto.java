package com.virtukch.dongiveupbe.domain.game.dto;

import com.virtukch.dongiveupbe.domain.game.entity.Game;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GameRequestDto {
    private Long memberId;
    @NotBlank(message = "gameName은 필수 값입니다.")
    private String gameName;
    @NotBlank(message = "password는 필수 값입니다.")
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
