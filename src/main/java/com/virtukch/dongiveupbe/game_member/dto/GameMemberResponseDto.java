package com.virtukch.dongiveupbe.game_member.dto;

import com.virtukch.dongiveupbe.game_member.entity.GameMember;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GameMemberResponseDto {

    private Long gameMemberId;

    private Long memberId;

    private Long gameId;

    public static GameMemberResponseDto fromEntity(GameMember gameMember) {
        return GameMemberResponseDto.builder()
            .gameMemberId(gameMember.getGameMemberId())
            .memberId(gameMember.getMemberId())
            .gameId(gameMember.getGameId())
            .build();
    }
}
