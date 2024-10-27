package com.virtukch.dongiveupbe.game_member.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameMemberId;

    private Long memberId;

    private Long gameId;
}
