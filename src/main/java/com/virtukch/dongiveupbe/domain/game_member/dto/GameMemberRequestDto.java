package com.virtukch.dongiveupbe.domain.game_member.dto;

import com.virtukch.dongiveupbe.domain.game_member.entity.GameMember;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameMemberRequestDto {

    @Schema(hidden = true)
    private Long gameMemberId;
    @Setter
    @Schema(hidden = true)
    private Long memberId;
    private Long gameId;
    @Schema(hidden = true)
    private Integer gameMemberMoney;


    public static GameMember toEntity(GameMemberRequestDto gameMemberRequestDto) {
        return GameMember.builder()
                .gameMemberId(gameMemberRequestDto.getGameMemberId())
                .memberId(gameMemberRequestDto.getMemberId())
                .gameId(gameMemberRequestDto.getGameId())
                .gameMemberMoney(gameMemberRequestDto.getGameMemberMoney() != null
                        ? gameMemberRequestDto.getGameMemberMoney() // 요청값 사용
                        : 0)
                .build();
    }
}
