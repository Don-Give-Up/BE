package com.virtukch.dongiveupbe.quiz_solve_record.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
public class QuizSolveRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizSolveRecordId;

    private Long gameMemberId;

    private Long quizId;

    private Long roundId;

    private Timestamp createdAt;

    private Correct correct;

    private Integer attemptCount;

    @Builder
    public QuizSolveRecord(Long gameMemberId, Long quizId, Long roundId, Timestamp createdAt,
        Correct correct, Integer attemptCount) {
        this.gameMemberId = gameMemberId;
        this.quizId = quizId;
        this.roundId = roundId;
        this.createdAt = createdAt;
        this.correct = correct;
        this.attemptCount = attemptCount;
    }
}