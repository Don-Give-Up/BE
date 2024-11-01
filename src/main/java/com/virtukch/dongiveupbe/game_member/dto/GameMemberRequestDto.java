package com.virtukch.dongiveupbe.game_member.dto;

import com.virtukch.dongiveupbe.game_member.entity.GameMember;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameMemberRequestDto {

    @Schema(hidden = true)
    private Long gameMemberId;
    private Long memberId;
    private Long gameId;
    @Schema(hidden = true)
    private Integer gameMemberMoney;


    public static GameMember toEntity(GameMemberRequestDto gameMemberRequestDto) {
        return GameMember.builder()
                .gameMemberId(gameMemberRequestDto.getGameMemberId())
                .memberId(gameMemberRequestDto.getMemberId())
                .gameId(gameMemberRequestDto.getGameId())
                .gameMemberMoney(gameMemberRequestDto.getGameMemberMoney())
                .build();
    }
}
