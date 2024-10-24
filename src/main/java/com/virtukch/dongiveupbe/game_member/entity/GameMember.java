package com.virtukch.dongiveupbe.game_member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class GameMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameMemberId;

    private Long memberId;

    private String gameId;
}
