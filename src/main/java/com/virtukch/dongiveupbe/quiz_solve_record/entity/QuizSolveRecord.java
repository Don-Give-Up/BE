package com.virtukch.dongiveupbe.quiz_solve_record.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    private Integer quizCorrectMoney;
}