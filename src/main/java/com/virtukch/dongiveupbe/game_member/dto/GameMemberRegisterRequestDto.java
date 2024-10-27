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
public class GameMemberRegisterRequestDto {

    private Long memberId;

    private Long gameId;

    public static GameMember toEntity(GameMemberRegisterRequestDto gameMemberRegisterRequestDto) {
        return GameMember.builder()
            .memberId(gameMemberRegisterRequestDto.getMemberId())
            .gameId(gameMemberRegisterRequestDto.getGameId())
            .build();
    }
}