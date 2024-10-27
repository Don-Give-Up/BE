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

    private Integer gameMemberMoney;

    private Integer problemsSolved = 0; // 추가된 필드: 문제 풀이 횟수
    private Integer daysSolved = 0; // 추가된 필드: 완료된 일수

    // 문제 풀기 횟수 증가 메서드
    public void incrementProblemSolved() {
        this.problemsSolved++;
    }

    // 문제 풀이 일수 증가 메서드
    public void incrementDaysSolved() {
        this.daysSolved++;
    }

    // 문제 풀기 횟수 초기화 메서드
    public void resetProblemsSolved() {
        this.problemsSolved = 0;
    }

    // 문제 풀이 일수 초기화 메서드
    public void resetDaysSolved() {
        this.daysSolved = 0;
    }

    // 돈 증가 메서드
    public void addMoney(Integer amount) {
        this.gameMemberMoney += amount;
    }

}
