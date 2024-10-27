package com.virtukch.dongiveupbe.game_member.dto;

import com.virtukch.dongiveupbe.game_member.entity.GameMember;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameMemberRequestDto {

    private Long memberId;

    private Long gameId;

    public static GameMember toEntity(GameMemberRequestDto gameMemberRequestDto) {
        return GameMember.builder()
            .memberId(gameMemberRequestDto.getMemberId())
            .gameId(gameMemberRequestDto.getGameId())
            .build();
    }
}